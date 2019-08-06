package com.siniothk.comm.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.siniothk.comm.domain.VersionEntity;
import org.springframework.stereotype.Repository;

@Repository("versionMapper")
public interface VersionMapper extends BaseMapper<VersionEntity> {
}
