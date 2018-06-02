package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Usageinfo;
import com.hxdq.xedsms.db.model.UsageinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UsageinfoMapper extends Mapper {
    int countByExample(UsageinfoExample example);

    int deleteByExample(UsageinfoExample example);

    int deleteByPrimaryKey(Integer usageId);

    int insert(Usageinfo record);

    int insertSelective(Usageinfo record);

    List<Usageinfo> selectByExampleWithRowbounds(UsageinfoExample example, RowBounds rowBounds);

    List<Usageinfo> selectByExample(UsageinfoExample example);

    Usageinfo selectByPrimaryKey(Integer usageId);

    int updateByExampleSelective(@Param("record") Usageinfo record, @Param("example") UsageinfoExample example);

    int updateByExample(@Param("record") Usageinfo record, @Param("example") UsageinfoExample example);

    int updateByPrimaryKeySelective(Usageinfo record);

    int updateByPrimaryKey(Usageinfo record);
}