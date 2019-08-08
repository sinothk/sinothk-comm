package com.siniothk.comm.controller;

import com.siniothk.comm.domain.DictEntity;
import com.siniothk.comm.service.DictService;
import com.sinothk.base.entity.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "数据字典")
@RestController
@RequestMapping("dict")
public class DictController {

    @Resource(name = "dictService")
    private DictService dictService;

    @ApiOperation(value = "字典新增", notes = "字典新增")
    @PostMapping("/add")
    public ResultData<Boolean> add(@ApiParam(value = "字典信息") @RequestBody DictEntity versionVo) {
        // http://localhost:11001/dict/add
        return dictService.add(versionVo);
    }

    @ApiOperation(value = "字典删除", notes = "字典删除")
    @GetMapping("/del")
    public ResultData<Boolean> del(@ApiParam(value = "字典ID") @RequestParam("id") String id) {
        // http://localhost:11001/dict/del
        return dictService.del(id);
    }

    @ApiOperation(value = "获取字典列表", notes = "获取字典列表")
    @GetMapping("/getVersionList")
    public ResultData<List<DictEntity>> getNationList(@ApiParam(value = "字典Key") @RequestParam("dictKey") String dictKey) {
        // http://localhost:11001/dict/getNationList
        return dictService.getNationList(dictKey);
    }
}
