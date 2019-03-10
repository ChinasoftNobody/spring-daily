package com.lgh.spring.boot.controller.record;

import com.lgh.spring.boot.exception.ServerException;
import com.lgh.spring.boot.mongo.model.record.MRecord;
import com.lgh.spring.boot.pojo.common.IdRequest;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.service.record.RecordService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/record", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ResponseBody
public class RecordController {
    @Resource
    private RecordService recordService;

    @PostMapping("/findByModuleId")
    public Response<List<MRecord>> findByModuleId(@RequestBody @Validated IdRequest request) {
        List<MRecord> records = recordService.findByModuleId(request.getId());
        return ResponseUtil.success(records);
    }

    @PostMapping("/update")
    public Response<MRecord> update(@RequestBody @Validated MRecord record)throws ServerException {
        return ResponseUtil.success(recordService.update(record));
    }
}
