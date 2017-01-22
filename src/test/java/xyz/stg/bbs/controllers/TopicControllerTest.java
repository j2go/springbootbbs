package xyz.stg.bbs.controllers;

import xyz.stg.bbs.entity.SectionEntity;
import xyz.stg.bbs.repository.SectionRepo;
import xyz.stg.bbs.repository.TopicRepo;
import xyz.stg.bbs.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Administrator on 2016/8/19.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TopicController.class)
public class TopicControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    TopicService topicService;
    @MockBean
    TopicRepo topicRepo;
    @MockBean
    SectionRepo sectionRepo;

    @Test
    public void list() throws Exception {
        given(sectionRepo.findByShowStatus(true)).willReturn(new ArrayList<>());
        mvc.perform(get("/topics")).andExpect(status().isOk());
    }

    @Test
    public void newTopic() throws Exception {

    }

    @Test
    public void detail() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}