package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Saler;
import com.hxdq.xedsms.db.model.SalerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SalerMapper extends Mapper {
    int countByExample(SalerExample example);

    int deleteByExample(SalerExample example);

    int deleteByPrimaryKey(Integer salerId);

    int insert(Saler record);

    int insertSelective(Saler record);

    List<Saler> selectByExampleWithRowbounds(SalerExample example, RowBounds rowBounds);

    List<Saler> selectByExample(SalerExample example);

    Saler selectByPrimaryKey(Integer salerId);

    int updateByExampleSelective(@Param("record") Saler record, @Param("example") SalerExample example);

    int updateByExample(@Param("record") Saler record, @Param("example") SalerExample example);

    int updateByPrimaryKeySelective(Saler record);

    int updateByPrimaryKey(Saler record);
}