package com.siniothk.comm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siniothk.comm.domain.VersionEntity;
import com.siniothk.comm.repository.VersionMapper;
import com.siniothk.comm.service.VersionService;
import com.sinothk.base.entity.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("versionService")
public class VersionServiceImpl  extends ServiceImpl<VersionMapper, VersionEntity> implements VersionService {

    @Resource(name = "versionMapper")
    private VersionMapper versionMapper;

    @Override
    public ResultData<Boolean> add(VersionEntity versionVo) {
        try {
            versionVo.setVerCreateTime(new Date());
            versionVo.setVersionStatus(VersionEntity.STATUS_INIT);

            versionMapper.insert(versionVo);
            return ResultData.success(true);
        } catch (Exception e) {
            return ResultData.error(e.getMessage());
        }
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
            versionMapper.updateById(versionVo);
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
