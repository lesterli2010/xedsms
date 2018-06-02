package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Stockstatus;
import com.hxdq.xedsms.db.model.StockstatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StockstatusMapper extends Mapper {
    int countByExample(StockstatusExample example);

    int deleteByExample(StockstatusExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(Stockstatus record);

    int insertSelective(Stockstatus record);

    List<Stockstatus> selectByExampleWithRowbounds(StockstatusExample example, RowBounds rowBounds);

    List<Stockstatus> selectByExample(StockstatusExample example);

    Stockstatus selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") Stockstatus record, @Param("example") StockstatusExample example);

    int updateByExample(@Param("record") Stockstatus record, @Param("example") StockstatusExample example);

    int updateByPrimaryKeySelective(Stockstatus record);

    int updateByPrimaryKey(Stockstatus record);
}