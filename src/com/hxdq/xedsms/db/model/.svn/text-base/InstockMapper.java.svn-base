package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Instock;
import com.hxdq.xedsms.db.model.InstockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InstockMapper extends Mapper {
    int countByExample(InstockExample example);

    int deleteByExample(InstockExample example);

    int deleteByPrimaryKey(Integer inId);

    int insert(Instock record);

    int insertSelective(Instock record);

    List<Instock> selectByExampleWithRowbounds(InstockExample example, RowBounds rowBounds);

    List<Instock> selectByExample(InstockExample example);

    Instock selectByPrimaryKey(Integer inId);

    int updateByExampleSelective(@Param("record") Instock record, @Param("example") InstockExample example);

    int updateByExample(@Param("record") Instock record, @Param("example") InstockExample example);

    int updateByPrimaryKeySelective(Instock record);

    int updateByPrimaryKey(Instock record);
}