package com.siniothk.comm.controller;

import com.siniothk.comm.domain.VersionEntity;
import com.siniothk.comm.service.VersionService;
import com.sinothk.base.entity.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * API：
 */
@Api(tags = "版本管理")
@RestController()
@RequestMapping("version")
public class VersionController {

    @Resource(name = "versionService")
    private VersionService versionService;

    @ApiOperation(value = "版本新增", notes = "版本新增")
    @PostMapping("/add")
    public ResultData<Boolean> add(@ApiParam(value = "版本信息") @RequestBody VersionEntity versionVo) {
        // http://localhost:11001/version/add
        return versionService.add(versionVo);
    }

    @ApiOperation(value = "版本删除", notes = "版本删除")
    @GetMapping("/del")
    public ResultData<Boolean> del(@ApiParam(value = "版本ID") @RequestParam("id") String id) {
        // http://localhost:11001/version/del
        return versionService.del(id);
    }

    @ApiOperation(value = "版本更新", notes = "版本更新")
    @GetMapping("/update")
    public ResultData<Boolean> update(@ApiParam(value = "版本信息") @RequestBody VersionEntity versionVo) {
        // http://localhost:11001/version/update
        return versionService.update(versionVo);
    }

    @ApiOperation(value = "获取最新版本", notes = "获取最新版本")
    @GetMapping("/getLastVersion")
    public ResultData<VersionEntity> getLastVersion() {
        // http://localhost:11001/version/getLastVersion
        return versionService.getLastVersion();
    }

    @ApiOperation(value = "获取版本列表", notes = "获取版本列表")
    @GetMapping("/getVersionList")
    public ResultData<List<VersionEntity>> getVersionList() {
        // http://localhost:11001/version/getLastVersion
        return versionService.getVersionList();
    }
}
