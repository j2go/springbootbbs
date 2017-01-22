package xyz.stg.bbs.controllers.dto;

import java.util.List;

/**
 * Created by shitiangao on 16/7/19.
 */
public class TopicDetail {

    private String title;
    private String sectionName;
    private long createTimestamp;
    private int visitTimes;
    private int replyTimes;
    private int likeTimes;
    private boolean editable;
    private String content;

    private List<TopicReply> replies;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public int getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(int visitTimes) {
        this.visitTimes = visitTimes;
    }

    public int getReplyTimes() {
        return replyTimes;
    }

    public void setReplyTimes(int replyTimes) {
        this.replyTimes = replyTimes;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<TopicReply> getReplies() {
        return replies;
    }

    public void setReplies(List<TopicReply> replies) {
        this.replies = replies;
    }

    public int getLikeTimes() {
        return likeTimes;
    }

    public void setLikeTimes(int likeTimes) {
        this.likeTimes = likeTimes;
    }
}
