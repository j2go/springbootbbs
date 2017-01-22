package xyz.stg.bbs.event;

import xyz.stg.bbs.entity.TopicReplyEntity;

import org.springframework.context.ApplicationEvent;

/**
 * Created by shitiangao on 16/7/22.
 */
public class TopicReplyEvent extends ApplicationEvent{

    long topicReplyId;
    long topicId;

    public TopicReplyEvent(TopicReplyEntity entity) {
        super(entity);
        topicReplyId = entity.getId();
        topicId = entity.getTopic().getId();
    }

    public long getTopicReplyId() {
        return topicReplyId;
    }

    public long getTopicId() {
        return topicId;
    }
}
