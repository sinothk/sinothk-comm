package com.siniothk.comm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.siniothk.comm.domain.VersionEntity;
import com.siniothk.comm.repository.VersionMapper;
import com.siniothk.comm.service.VersionService;
import com.sinothk.base.entity.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("versionService")
public class VersionServiceImpl implements VersionService {

    @Resource(name = "versionMapper")
    private VersionMapper versionMapper;

    @Override
    public ResultData<Boolean> add(VersionEntity versionVo) {

        versionMapper.insert(versionVo);

        return null;
    }

    @Override
    public ResultData<Boolean> del(String id) {
        try {
            versionMapper.deleteById(id);
            return ResultData.success(true);
        } catch (Exception e) {
            return ResultData.error(e.getMessage());
        }
    }

    @Override
    public ResultData<Boolean> update(VersionEntity versionVo) {
        try {
            QueryWrapper<VersionEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(VersionEntity::getId, versionVo.getId());
            versionMapper.update(versionVo, queryWrapper);
            return ResultData.success(true);
        } catch (Exception e) {
            return ResultData.error(e.getMessage());
        }
    }

    @Override
    public ResultData<VersionEntity> getLastVersion() {
        try {
            QueryWrapper<VersionEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda()
                    .eq(VersionEntity::getVersionStatus, VersionEntity.STATUS_ENABLE)
                    .orderByDesc(VersionEntity::getVerPublicTime);

            List<VersionEntity> vsList = versionMapper.selectList(queryWrapper);
            if (vsList != null && vsList.size() > 0) {
                return ResultData.success(vsList.get(0));
            } else {
                return ResultData.error("没有可用版本");
            }
        } catch (Exception e) {
            return ResultData.error(e.getMessage());
        }
    }

    @Override
    public ResultData<List<VersionEntity>> getVersionList() {
        try {
            QueryWrapper<VersionEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().orderByDesc(VersionEntity::getVerPublicTime);

            List<VersionEntity> vsList = versionMapper.selectList(queryWrapper);
            if (vsList != null && vsList.size() > 0) {
                return ResultData.success(vsList);
            } else {
                return ResultData.error("没有可用版本");
            }
        } catch (Exception e) {
            return ResultData.error(e.getMessage());
        }
    }
}
