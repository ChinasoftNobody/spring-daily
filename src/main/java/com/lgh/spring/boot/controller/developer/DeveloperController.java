package com.lgh.spring.boot.controller.developer;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.model.MRepository;
import com.lgh.spring.boot.pojo.developer.RepositoryRequest;
import com.lgh.spring.boot.service.developer.RepositoryService;
import com.lgh.spring.boot.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */
@Api(tags = "developer")
@RestController
@RequestMapping("/developer")
public class DeveloperController {

    @Resource
    private RepositoryService repositoryService;

    @PostMapping(value = "/repository/list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "repository",notes = "repository")
    public Response repositoryList(@RequestBody RepositoryRequest request){
        return ResponseUtil.ok(repositoryService.list(request));
    }

    @PostMapping(value = "/repository/update",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "update a repository",notes = "update a repository")
    public Response updateRepository(@RequestBody MRepository repository){
        return ResponseUtil.ok(repositoryService.createOrUpdateRepository(repository));
    }

    @PostMapping(value = "/repository/delete",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "delete repository",notes = "delete repository")
    public Response deleteRepository(@RequestBody List<String> ids){
        return ResponseUtil.ok(repositoryService.deleteRepositories(ids));
    }
}
