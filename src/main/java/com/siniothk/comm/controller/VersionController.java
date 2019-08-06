package com.siniothk.comm.controller;

import com.siniothk.comm.domain.VersionEntity;
import com.siniothk.comm.service.VersionService;
import com.sinothk.base.entity.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController()
@RequestMapping("version")
public class VersionController {

    @Resource(name = "versionService")
    private VersionService versionService;

    @GetMapping("/add")
    public ResultData<Boolean> add(@RequestBody VersionEntity versionVo) {
        // http://localhost:11001/version/add
        return versionService.add(versionVo);
    }

    @GetMapping("/del")
    public ResultData<Boolean> del(@RequestParam("id") String id) {
        // http://localhost:11001/version/del
        return versionService.del(id);
    }

    @GetMapping("/update")
    public ResultData<Boolean> update(@RequestBody VersionEntity versionVo) {
        // http://localhost:11001/version/update
        return versionService.update(versionVo);
    }

    @GetMapping("/getLastVersion")
    public ResultData<VersionEntity> getLastVersion() {
        // http://localhost:11001/version/getLastVersion
        return versionService.getLastVersion();
    }

    @GetMapping("/getVersionList")
    public ResultData<ArrayList<VersionEntity>> getVersionList() {
        // http://localhost:11001/version/getLastVersion
        return versionService.getVersionList();
    }
}
