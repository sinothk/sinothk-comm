package com.siniothk.comm.service;

import com.siniothk.comm.domain.DictEntity;
import com.sinothk.base.entity.ResultData;

import java.util.List;

public interface DictService {
    ResultData<Boolean> add(DictEntity versionVo);

    ResultData<Boolean> del(String id);

    ResultData<List<DictEntity>> getNationList(String dictKey);

}
