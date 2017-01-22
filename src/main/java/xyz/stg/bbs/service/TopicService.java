package xyz.stg.bbs.service;

import xyz.stg.bbs.controllers.dto.TopicDetail;
import xyz.stg.bbs.entity.TopicEntity;

/**
 * Created by shitiangao on 16/7/19.
 */
public interface TopicService {

    TopicDetail detail(TopicEntity topic);

    TopicEntity create(String title, int type, String content);

    TopicEntity delete(TopicEntity topic);

    TopicEntity update(TopicEntity topic, String content);
}
