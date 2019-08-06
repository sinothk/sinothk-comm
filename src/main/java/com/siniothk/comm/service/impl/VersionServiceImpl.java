package com.siniothk.comm.service.impl;

import com.siniothk.comm.domain.VersionEntity;
import com.siniothk.comm.repository.VersionMapper;
import com.siniothk.comm.service.VersionService;
import com.sinothk.base.entity.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("versionService")
public class VersionServiceImpl implements VersionService {

    @Resource(name = "versionMapper")
    private VersionMapper versionMapper;

    @Override
    public ResultData<Boolean> add(VersionEntity versionVo) {
        return null;
    }

    @Override
    public ResultData<Boolean> del(String id) {
        return null;
    }

    @Override
    public ResultData<Boolean> update(VersionEntity versionVo) {
        return null;
    }

    @Override
    public ResultData<VersionEntity> getLastVersion() {
        return null;
    }

    @Override
    public ResultData<ArrayList<VersionEntity>> getVersionList() {
        return null;
    }
}
