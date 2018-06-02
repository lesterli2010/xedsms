package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Productbatch;
import com.hxdq.xedsms.db.model.ProductbatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProductbatchMapper extends Mapper {
    int countByExample(ProductbatchExample example);

    int deleteByExample(ProductbatchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Productbatch record);

    int insertSelective(Productbatch record);

    List<Productbatch> selectByExampleWithRowbounds(ProductbatchExample example, RowBounds rowBounds);

    List<Productbatch> selectByExample(ProductbatchExample example);

    Productbatch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Productbatch record, @Param("example") ProductbatchExample example);

    int updateByExample(@Param("record") Productbatch record, @Param("example") ProductbatchExample example);

    int updateByPrimaryKeySelective(Productbatch record);

    int updateByPrimaryKey(Productbatch record);
}