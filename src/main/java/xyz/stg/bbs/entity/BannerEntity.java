package xyz.stg.bbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by shitiangao on 16/7/6.
 */
@Entity
@Table(name = "banner")
public class BannerEntity extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text")
    private String text;

    /**
     * 是否显示
     */
    @Column(name = "show_status", nullable = false)
    private Boolean showStatus;

    /**
     * 显示顺序
     */
    @Column(name = "show_index")
    private Integer showIndex;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Boolean showStatus) {
        this.showStatus = showStatus;
    }
}
