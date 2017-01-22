package xyz.stg.bbs.controllers;

import xyz.stg.bbs.controllers.dto.Result;
import xyz.stg.bbs.entity.TopicEntity;
import xyz.stg.bbs.entity.TopicReplyEntity;
import xyz.stg.bbs.entity.UserEntity;
import xyz.stg.bbs.event.TopicReplyEvent;
import xyz.stg.bbs.exception.BadRequestException;
import xyz.stg.bbs.exception.ForbiddenException;
import xyz.stg.bbs.exception.ResourceNotFoundException;
import xyz.stg.bbs.repository.TopicReplyRepo;
import xyz.stg.bbs.repository.TopicRepo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by shitiangao on 16/7/18.
 */
@RestController
@RequestMapping(value = "/topics")
public class TopicReplyController {

    @Autowired
    TopicReplyRepo topicReplyRepo;

    @Autowired
    TopicRepo topicRepo;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping(value = "/{topicId}/replies", method = RequestMethod.POST)
    public Result replyTopic(@PathVariable long topicId, @RequestParam String content) {

        if (StringUtils.isBlank(content)) {
            throw new BadRequestException("no reply message");
        }
        TopicEntity topic = topicRepo.findOne(topicId);
        if (topic == null) {
            throw new ResourceNotFoundException("topic not found");
        }
        TopicReplyEntity reply = new TopicReplyEntity();
        reply.setTopic(topic);
        reply.setContent(content);
        reply.setLevel(0);
        reply.setAuthorId(getAuthUser().getId());
        topicReplyRepo.save(reply);

        applicationContext.publishEvent(new TopicReplyEvent(reply));

        return  Result.succeed("ok", reply.getId());
    }

    @RequestMapping(value = "/replies/{replyId}", method = RequestMethod.POST)
    public Result replyReply(@PathVariable long replyId, @RequestParam String content) {
        if (StringUtils.isBlank(content)) {
            throw new BadRequestException("no reply message");
        }
        TopicReplyEntity sourceReply = topicReplyRepo.findOne(replyId);
        if (sourceReply == null) {
            throw new ResourceNotFoundException("reply not found");
        }
        TopicReplyEntity reply = new TopicReplyEntity();
        reply.setTopic(sourceReply.getTopic());
        reply.setContent(content);
        reply.setAuthorId(getAuthUser().getId());
        reply.setLevel(1);
        topicReplyRepo.save(reply);

        applicationContext.publishEvent(new TopicReplyEvent(reply));

        return  Result.succeed("ok", reply.getId());
    }

    @RequestMapping(value = "/replies/{replyId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable long replyId) {
        TopicReplyEntity reply = topicReplyRepo.findOne(replyId);
        if (reply == null) {
            throw new ResourceNotFoundException("reply not found");
        }
        checkUserId(reply);

        reply.setDeleted(true);
        topicReplyRepo.save(reply);

        return  Result.succeed("ok", reply.getId());
    }

    @RequestMapping(value = "/replies/{replyId}", method = RequestMethod.PUT)
    public Result update(@PathVariable long replyId, @RequestParam String content) {
        if (StringUtils.isBlank(content)) {
            throw new BadRequestException("no reply message");
        }
        TopicReplyEntity reply = topicReplyRepo.findOne(replyId);
        if (reply == null) {
            throw new ResourceNotFoundException("reply not found");
        }
        checkUserId(reply);

        reply.setContent(content);
        topicReplyRepo.save(reply);

        return  Result.succeed("ok", reply.getId());
    }

    private void checkUserId(TopicReplyEntity reply) {
        UserEntity authUser = getAuthUser();
        if (reply.getAuthorId() != authUser.getId()) {
            throw new ForbiddenException("operation forbidden");
        }
    }

    private UserEntity getAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (UserEntity) auth.getDetails();
    }
}
