package com.siniothk.comm.service.impl;

import com.siniothk.comm.domain.DictEntity;
import com.siniothk.comm.domain.VersionEntity;
import com.siniothk.comm.repository.DictMapper;
import com.siniothk.comm.service.DictService;
import com.sinothk.base.entity.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("dictService")
public class DictServiceImpl implements DictService {

    @Resource(name = "dictMapper")
    private DictMapper dictMapper;

    @Override
    public ResultData<Boolean> add(DictEntity dictEntity) {
        try {
            dictEntity.setCreateTime(new Date());
            dictEntity.setUpdateTime(dictEntity.getCreateTime());
            dictEntity.setDictStatus(VersionEntity.STATUS_ENABLE);

            dictMapper.insert(dictEntity);

            return ResultData.success(true);
        } catch (Exception e) {
            return ResultData.error(e.getMessage());
        }
    }

    @Override
    public ResultData<Boolean> del(String id) {
        try {
            dictMapper.deleteById(id);
            return ResultData.success(true);
        } catch (Exception e) {
            return ResultData.error(e.getMessage());
        }
    }
}
