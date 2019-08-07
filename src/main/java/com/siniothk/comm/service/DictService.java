package com.siniothk.comm.service;

import com.siniothk.comm.domain.DictEntity;
import com.sinothk.base.entity.ResultData;

public interface DictService {
    ResultData<Boolean> add(DictEntity versionVo);

    ResultData<Boolean> del(String id);
}
