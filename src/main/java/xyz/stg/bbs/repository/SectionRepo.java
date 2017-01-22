package xyz.stg.bbs.repository;

import xyz.stg.bbs.entity.SectionEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shitiangao on 16/7/8.
 */
@Repository
public interface SectionRepo extends CrudRepository<SectionEntity, Integer> {

    List<SectionEntity> findByShowStatus(boolean showStatus);

 }
