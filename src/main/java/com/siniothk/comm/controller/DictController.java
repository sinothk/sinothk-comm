package com.siniothk.comm.controller;

import com.siniothk.comm.domain.DictEntity;
import com.siniothk.comm.service.DictService;
import com.sinothk.base.entity.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "数据字典")
@RestController
@RequestMapping("dict")
public class DictController {

    @Resource(name = "dictService")
    private DictService dictService;

    @ApiOperation(value = "版本新增", notes = "版本新增")
    @PostMapping("/add")
    public ResultData<Boolean> add(@ApiParam(value = "版本信息") @RequestBody DictEntity versionVo) {
        // http://localhost:11001/version/add
        return dictService.add(versionVo);
    }

    @ApiOperation(value = "版本删除", notes = "版本删除")
    @GetMapping("/del")
    public ResultData<Boolean> del(@ApiParam(value = "版本ID") @RequestParam("id") String id) {
        // http://localhost:11001/version/del
        return dictService.del(id);
    }
}
