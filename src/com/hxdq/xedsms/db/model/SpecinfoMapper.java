package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Specinfo;
import com.hxdq.xedsms.db.model.SpecinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SpecinfoMapper extends Mapper {
    int countByExample(SpecinfoExample example);

    int deleteByExample(SpecinfoExample example);

    int deleteByPrimaryKey(Integer specId);

    int insert(Specinfo record);

    int insertSelective(Specinfo record);

    List<Specinfo> selectByExampleWithRowbounds(SpecinfoExample example, RowBounds rowBounds);

    List<Specinfo> selectByExample(SpecinfoExample example);

    Specinfo selectByPrimaryKey(Integer specId);

    int updateByExampleSelective(@Param("record") Specinfo record, @Param("example") SpecinfoExample example);

    int updateByExample(@Param("record") Specinfo record, @Param("example") SpecinfoExample example);

    int updateByPrimaryKeySelective(Specinfo record);

    int updateByPrimaryKey(Specinfo record);
}