package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.OutstockProduct;
import com.hxdq.xedsms.db.model.OutstockProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OutstockProductMapper extends Mapper {
    int countByExample(OutstockProductExample example);

    int deleteByExample(OutstockProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OutstockProduct record);

    int insertSelective(OutstockProduct record);

    List<OutstockProduct> selectByExampleWithRowbounds(OutstockProductExample example, RowBounds rowBounds);

    List<OutstockProduct> selectByExample(OutstockProductExample example);

    OutstockProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OutstockProduct record, @Param("example") OutstockProductExample example);

    int updateByExample(@Param("record") OutstockProduct record, @Param("example") OutstockProductExample example);

    int updateByPrimaryKeySelective(OutstockProduct record);

    int updateByPrimaryKey(OutstockProduct record);
}