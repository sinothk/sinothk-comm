package com.siniothk.comm.service;

import com.siniothk.comm.domain.VersionEntity;
import com.sinothk.base.entity.ResultData;

import java.util.ArrayList;

public interface VersionService {

    ResultData<Boolean> add(VersionEntity versionVo);

    ResultData<Boolean> del(String id);

    ResultData<Boolean> update(VersionEntity versionVo);

    ResultData<VersionEntity> getLastVersion();

    ResultData<ArrayList<VersionEntity>> getVersionList();

}
