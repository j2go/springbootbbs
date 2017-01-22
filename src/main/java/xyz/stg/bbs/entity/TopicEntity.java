package xyz.stg.bbs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by shitiangao on 16/7/6.
 */
@Entity
@Table(name = "topic", indexes = {@Index(name = "IDX_TITLE", columnList = "title")})
public class TopicEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "section_id", foreignKey = @ForeignKey(name = "FK_topic_section"))
    private SectionEntity section;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false, length = 2000)
    private String content;

    @Column(name = "last_reply_time")
    private Date lastReplyTime;

    @Column(name = "last_reply_user_id")
    private int lastReplyUserId;

    @Column(name = "author_id", nullable = false)
    private int authorId;
    /**
     * 置顶状态 0,默认; 1,置顶
     */
    @Column(name = "top_status", nullable = false)
    private int topStatus;
    /**
     * 浏览量
     */
    @Column(name = "visit_times", nullable = false)
    private int visitTimes;

    @Column(name = "reply_times", nullable = false)
    private int replyTimes;
    /**
     * 点赞数
     */
    @Column(name = "like_times", nullable = false)
    private int likeTimes;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    public SectionEntity getSection() {
        return section;
    }

    public void setSection(SectionEntity section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonIgnore
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLastReplyTime() {
        return lastReplyTime;
    }

    public void setLastReplyTime(Date lastReplyTime) {
        this.lastReplyTime = lastReplyTime;
    }

    public int getLastReplyUserId() {
        return lastReplyUserId;
    }

    public void setLastReplyUserId(int lastReplyUserId) {
        this.lastReplyUserId = lastReplyUserId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getVisitTimes() {
        return visitTimes;
    }

    public void setVisitTimes(int visitTimes) {
        this.visitTimes = visitTimes;
    }

    public int getTopStatus() {
        return topStatus;
    }

    public void setTopStatus(int topStatus) {
        this.topStatus = topStatus;
    }

    public int getLikeTimes() {
        return likeTimes;
    }

    public void setLikeTimes(int likeTimes) {
        this.likeTimes = likeTimes;
    }

    @JsonIgnore
    public boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getReplyTimes() {
        return replyTimes;
    }

    public void setReplyTimes(int replyTimes) {
        this.replyTimes = replyTimes;
    }
}
