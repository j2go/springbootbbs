package xyz.stg.bbs.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stg.bbs.entity.SectionEntity;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shitiangao on 2016/11/11.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class SectionRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SectionRepo repo;

    @Test
    public void findByShowStatus() throws Exception {
        SectionEntity sectionEntity = new SectionEntity();
        sectionEntity.setName("test");
        sectionEntity.setShowStatus(true);
        sectionEntity.setShowIndex(1);
        entityManager.persist(sectionEntity);

        List<SectionEntity> list = repo.findByShowStatus(true);
        assertEquals(1, list.size());
        assertEquals("test", list.get(0).getName());
    }

}