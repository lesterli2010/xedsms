package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Instockproduct;
import com.hxdq.xedsms.db.model.InstockproductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InstockproductMapper extends Mapper {
    int countByExample(InstockproductExample example);

    int deleteByExample(InstockproductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Instockproduct record);

    int insertSelective(Instockproduct record);

    List<Instockproduct> selectByExampleWithRowbounds(InstockproductExample example, RowBounds rowBounds);

    List<Instockproduct> selectByExample(InstockproductExample example);

    Instockproduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Instockproduct record, @Param("example") InstockproductExample example);

    int updateByExample(@Param("record") Instockproduct record, @Param("example") InstockproductExample example);

    int updateByPrimaryKeySelective(Instockproduct record);

    int updateByPrimaryKey(Instockproduct record);
}