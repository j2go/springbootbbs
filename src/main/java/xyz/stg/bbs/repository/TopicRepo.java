package xyz.stg.bbs.repository;


import xyz.stg.bbs.entity.SectionEntity;
import xyz.stg.bbs.entity.TopicEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by shitiangao on 16/7/8.
 */
@Repository
public interface TopicRepo extends PagingAndSortingRepository<TopicEntity, Long> {

    Page<TopicEntity> findBySectionAndIsDeleted(SectionEntity section, boolean isDeleted, Pageable pageable);

    @Query("SELECT w FROM #{#entityName} w WHERE w.section = ?1 and w.isDeleted = false " +
            "ORDER BY w.topStatus DESC, w.createTime DESC")
    Page<TopicEntity> listByTime(SectionEntity section, Pageable page);

    @Query("SELECT w FROM #{#entityName} w WHERE w.section = ?1 and w.isDeleted = false " +
            "ORDER BY w.topStatus DESC, w.likeTimes DESC")
    Page<TopicEntity> listByLikeTimes(SectionEntity section, Pageable page);

    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} t SET t.visitTimes = t.visitTimes + 1 where t = ?1")
    void increaseVisitTimes(TopicEntity topic);

    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} t SET t.isDeleted = true where t = ?1")
    void logicDel(TopicEntity topic);
}
