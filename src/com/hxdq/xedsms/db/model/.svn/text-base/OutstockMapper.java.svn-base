package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Outstock;
import com.hxdq.xedsms.db.model.OutstockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OutstockMapper extends Mapper {
    int countByExample(OutstockExample example);

    int deleteByExample(OutstockExample example);

    int deleteByPrimaryKey(Integer outId);

    int insert(Outstock record);

    int insertSelective(Outstock record);

    List<Outstock> selectByExampleWithRowbounds(OutstockExample example, RowBounds rowBounds);

    List<Outstock> selectByExample(OutstockExample example);

    Outstock selectByPrimaryKey(Integer outId);

    int updateByExampleSelective(@Param("record") Outstock record, @Param("example") OutstockExample example);

    int updateByExample(@Param("record") Outstock record, @Param("example") OutstockExample example);

    int updateByPrimaryKeySelective(Outstock record);

    int updateByPrimaryKey(Outstock record);
}