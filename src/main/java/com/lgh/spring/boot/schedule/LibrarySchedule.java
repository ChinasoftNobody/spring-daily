package com.lgh.spring.boot.schedule;

import com.lgh.spring.boot.mongo.model.library.MResource;
import com.lgh.spring.boot.service.library.ResourceService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class LibrarySchedule {
    @Resource
    private ResourceService resourceService;

    @Scheduled(cron = "0 0 0 * * *")
    public void refreshResource() {
        List<MResource> resources = resourceService.queryExternalResource();
        if (resources != null && !resources.isEmpty()){
            resourceService.dropAll();
            resourceService.save(resources);
        }
    }
}
