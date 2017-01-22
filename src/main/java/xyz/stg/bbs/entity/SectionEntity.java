package xyz.stg.bbs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created by shitiangao on 16/7/6.
 */
@Entity
@Table(name = "section")
public class SectionEntity extends BaseEntity {

    /**
     * 板块名称
     */
    @Column(name = "name", nullable = false)
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Boolean getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Boolean showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getShowIndex() {
        return showIndex;
    }

    public void setShowIndex(Integer showIndex) {
        this.showIndex = showIndex;
    }
}
