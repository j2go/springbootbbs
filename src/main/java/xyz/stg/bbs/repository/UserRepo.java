package xyz.stg.bbs.repository;

import xyz.stg.bbs.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shitiangao on 16/7/21.
 */
@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);

    UserEntity findByName(String username);
}
