package com.asimov.teacherservice.client;

import com.asimov.teacherservice.model.Director;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "director-service")
@RequestMapping("api/v1/directors")
public interface DirectorClient {

    @GetMapping("{directorId}")
    Director getDirectorById(@PathVariable("directorId") Long directorId);
}
