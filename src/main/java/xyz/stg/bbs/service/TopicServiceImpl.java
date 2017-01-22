package xyz.stg.bbs.service;

import xyz.stg.bbs.controllers.dto.TopicReply;
import xyz.stg.bbs.entity.TopicEntity;
import xyz.stg.bbs.controllers.dto.TopicDetail;
import xyz.stg.bbs.entity.TopicReplyEntity;
import xyz.stg.bbs.entity.UserEntity;
import xyz.stg.bbs.event.TopicReplyEvent;
import xyz.stg.bbs.repository.SectionRepo;
import xyz.stg.bbs.repository.TopicReplyRepo;
import xyz.stg.bbs.repository.TopicRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shitiangao on 16/7/8.
 */
@Service
public class TopicServiceImpl implements TopicService, ApplicationListener<TopicReplyEvent> {

//    public static final Logger log = LoggerFactory.getLogger(TopicService.class);

    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private SectionRepo sectionRepo;
    @Autowired
    private TopicReplyRepo topicReplyRepo;

    @Override
    public TopicEntity create(String title, int type, String content) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = (UserEntity) auth.getDetails();

        TopicEntity topic = new TopicEntity();
        topic.setSection(sectionRepo.findOne(type));
        topic.setTitle(title);
        topic.setContent(content);
        topic.setVisitTimes(0);
        topic.setLikeTimes(0);
        topic.setTopStatus(0);
        topic.setAuthorId(user.getId());
        topic.setReplyTimes(0);

        return topicRepo.save(topic);
    }

    @Override
    public TopicEntity delete(TopicEntity topic) {

        topicRepo.logicDel(topic);
        return topic;
    }

    @Override
    public TopicEntity update(TopicEntity topic, String content) {

        topic.setContent(content);
        return topicRepo.save(topic);
    }



    @Override
    public TopicDetail detail(TopicEntity topic) {

        TopicDetail detail = new TopicDetail();
        detail.setTitle(topic.getTitle());

        UserEntity user = getAuthUser();
        detail.setEditable((user == null) ? false : user.getId() == topic.getAuthorId());

        detail.setContent(topic.getContent());
        detail.setCreateTimestamp(topic.getCreateTime().getTime());
        detail.setVisitTimes(topic.getVisitTimes());
        detail.setLikeTimes(topic.getLikeTimes());
        detail.setReplyTimes(topic.getReplyTimes());
        detail.setSectionName(topic.getSection().getName());

        List<TopicReplyEntity> replies = topicReplyRepo.findByTopic(topic);
        List<TopicReply>  repliesRes = new ArrayList<>();

        for (TopicReplyEntity entity : replies) {
            TopicReply reply = new TopicReply(entity);

            if (entity.getReplyId() != null) {
                reply.setReplies(repliesOfReply(entity.getReplyId()));
            }
            repliesRes.add(reply);
        }
        detail.setReplies(repliesRes);

        topicRepo.increaseVisitTimes(topic);
        return detail;
    }


    private List<TopicReply> repliesOfReply(long replyId) {
        List<TopicReplyEntity> repliesOfReply = topicReplyRepo.findByReplyId(replyId);
        if (repliesOfReply == null || repliesOfReply.size() == 0) {
            return null;
        }
        return repliesOfReply.stream().map(TopicReply::new).collect(Collectors.toList());
    }

    private UserEntity getAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getDetails() instanceof UserEntity) {
            return (UserEntity) auth.getDetails();
        } else {
            return null;
        }
    }

    @Override
    public void onApplicationEvent(TopicReplyEvent event) {

        TopicReplyEntity source = (TopicReplyEntity) event.getSource();

        TopicEntity topic = source.getTopic();
        topic.setLastReplyTime(new Date());
        topic.setReplyTimes(topic.getReplyTimes() + 1);
        topic.setLastReplyUserId(source.getAuthorId());

        topicRepo.save(topic);
    }
}
