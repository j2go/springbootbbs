package xyz.stg.bbs.controllers;

import xyz.stg.bbs.controllers.dto.Result;
import xyz.stg.bbs.controllers.dto.TopicDetail;
import xyz.stg.bbs.entity.SectionEntity;
import xyz.stg.bbs.entity.TopicEntity;
import xyz.stg.bbs.exception.BadRequestException;
import xyz.stg.bbs.repository.SectionRepo;
import xyz.stg.bbs.repository.TopicRepo;
import xyz.stg.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.Sort.Direction.DESC;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by shitiangao on 16/7/6.
 */
@RestController
public class TopicController {

    @Autowired
    TopicService topicService;
    @Autowired
    TopicRepo topicRepo;
    @Autowired
    SectionRepo sectionRepo;

    @RequestMapping(value = "/topics", method = GET, produces = APPLICATION_JSON_VALUE)
    public Page<TopicEntity> list(@RequestParam(value = "sectionId", required = false) SectionEntity section,
                                  @PageableDefault(page = 0, size = 10, direction = DESC, sort = "likeTimes")
                                          Pageable pageable) {
        if (section == null) {
            section = sectionRepo.findByShowStatus(true).get(0);
        }
        return topicRepo.listByTime(section, pageable);
    }

    @RequestMapping(value = "/topics", method = POST, produces = APPLICATION_JSON_VALUE)
    public Result newTopic(@RequestParam String title,
                           @RequestParam Integer sectionId,
                           @RequestParam String content) {

        return Result.succeed(topicService.create(title, sectionId, content));
    }

    @RequestMapping(value = "/topics/{topicId}", method = GET, produces = APPLICATION_JSON_VALUE)
    public TopicDetail detail(@PathVariable("topicId") TopicEntity topic) {

        return topicService.detail(topic);
    }

    @RequestMapping(value = "/topics/{topicId}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public Result delete(@PathVariable("topicId") TopicEntity topic) {

        if (topic == null) {
            throw new BadRequestException("no topic found");
        }
        return Result.succeed(topicService.delete(topic));
    }

    @RequestMapping(value = "/topics/{topicId}", method = PUT, produces = APPLICATION_JSON_VALUE)
    public Result update(@PathVariable("topicId") TopicEntity topic,
                         @RequestParam String content) {
        if (topic == null) {
            throw new BadRequestException("no topic found");
        }
        return Result.succeed(topicService.update(topic, content));
    }

}
