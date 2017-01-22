package xyz.stg.bbs.repository;

import xyz.stg.bbs.entity.BannerEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shitiangao on 16/7/6.
 */
@Repository
public interface BannerRepo extends CrudRepository<BannerEntity, Long>{
}
