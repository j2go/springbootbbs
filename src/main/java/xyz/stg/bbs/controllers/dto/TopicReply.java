package xyz.stg.bbs.controllers.dto;

import xyz.stg.bbs.entity.TopicReplyEntity;

import java.util.List;

/**
 * Created by shitiangao on 16/7/21.
 */
public class TopicReply {

    private String username;
    private long createTimestamp;
    private int likeTimes;
    private String content;

    private List<TopicReply> replies;

    public TopicReply(){}

    public TopicReply(TopicReplyEntity replyEntity) {
        username = replyEntity.getCreator();
        createTimestamp = replyEntity.getCreateTime().getTime();
        likeTimes = replyEntity.getLikeTimes();
        content = replyEntity.getContent();
    }

    public String getUsername() {
        return username;
    }

    public long getCreateTimestamp() {
        return createTimestamp;
    }

    public int getLikeTimes() {
        return likeTimes;
    }

    public String getContent() {
        return content;
    }

    public List<TopicReply> getReplies() {
        return replies;
    }

    public void setReplies(List<TopicReply> replies) {
        this.replies = replies;
    }
}
