package xyz.stg.bbs.repository;

import xyz.stg.bbs.entity.TopicEntity;
import xyz.stg.bbs.entity.TopicReplyEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by shitiangao on 16/7/6.
 */
public interface TopicReplyRepo extends CrudRepository<TopicReplyEntity, Long> {

    List<TopicReplyEntity> findByTopic(TopicEntity topic);

    List<TopicReplyEntity> findByReplyId(long replyId);
}
