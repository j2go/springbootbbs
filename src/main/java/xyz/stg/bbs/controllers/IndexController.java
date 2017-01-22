package xyz.stg.bbs.controllers;

import xyz.stg.bbs.entity.SectionEntity;
import xyz.stg.bbs.model.IndexPage;
import xyz.stg.bbs.repository.SectionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shitiangao on 16/7/20.
 */
@RestController
public class IndexController {

    @Autowired
    IndexPage indexPage;

    @Autowired
    SectionRepo sectionRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public IndexPage all() {
        return indexPage;
    }

    @RequestMapping(value = "/sections", method = RequestMethod.GET)
    public List<SectionEntity> getSections() {
        return sectionRepo.findByShowStatus(true);
    }

}
