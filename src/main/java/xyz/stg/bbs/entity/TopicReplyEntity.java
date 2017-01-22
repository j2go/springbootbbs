package xyz.stg.bbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by shitiangao on 16/7/6.
 */
@Entity
@Table(name = "topic_reply")
public class TopicReplyEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "topic_id", foreignKey = @ForeignKey(name = "FK_reply_topic"))
    private TopicEntity topic;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "author_id", nullable = false)
    private int authorId;

    @Column(name = "reply_id")
    private Long replyId;
    /**
     * 回复等级
     * 0 一级评论,可再评论
     * 1 二级评论,不可再评论消息
     */
    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "like_times")
    private int likeTimes;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public TopicReplyEntity() {
        likeTimes = 0;
        level = 0;
        isDeleted = false;
    }

    public TopicEntity getTopic() {
        return topic;
    }

    public void setTopic(TopicEntity topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLikeTimes() {
        return likeTimes;
    }

    public void setLikeTimes(int likeTimes) {
        this.likeTimes = likeTimes;
    }

    public boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
