package com.siniothk.comm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.siniothk.comm.domain.Constance;
import com.siniothk.comm.domain.DictEntity;
import com.siniothk.comm.domain.VersionEntity;
import com.siniothk.comm.repository.DictMapper;
import com.siniothk.comm.service.DictService;
import com.sinothk.base.entity.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("dictService")
public class DictServiceImpl implements DictService {

    @Resource(name = "dictMapper")
    private DictMapper dictMapper;

    @Override
    public ResultData<Boolean> add(DictEntity dictEntity) {
        try {
            dictEntity.setCreateTime(new Date());
            dictEntity.setUpdateTime(dictEntity.getCreateTime());
            dictEntity.setDictStatus(Constance.STATUS_ENABLE);

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

    @Override
    public ResultData<List<DictEntity>> getNationList(String dictKey) {
        try {
            QueryWrapper<DictEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda()
                    .eq(DictEntity::getParentKey, dictKey)
                    .eq(DictEntity::getDictStatus, Constance.STATUS_ENABLE) //
                    .orderByAsc(DictEntity::getDictOrder);

            List<DictEntity> vsList = dictMapper.selectList(queryWrapper);
            if (vsList != null && vsList.size() > 0) {
                return ResultData.success(vsList);
            } else {
                return ResultData.error("没有子分类数据");
            }
        } catch (Exception e) {
            return ResultData.error(e.getMessage());
        }
    }
}
