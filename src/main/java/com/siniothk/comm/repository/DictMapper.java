package com.siniothk.comm.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.siniothk.comm.domain.DictEntity;
import com.siniothk.comm.domain.VersionEntity;
import org.springframework.stereotype.Repository;

@Repository("dictMapper")
public interface DictMapper extends BaseMapper<DictEntity> {



//    void updatePublicTime(VersionEntity versionVo);
}
