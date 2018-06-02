package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Province;
import com.hxdq.xedsms.db.model.ProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProvinceMapper extends Mapper {
    int countByExample(ProvinceExample example);

    int deleteByExample(ProvinceExample example);

    int deleteByPrimaryKey(Integer provId);

    int insert(Province record);

    int insertSelective(Province record);

    List<Province> selectByExampleWithRowbounds(ProvinceExample example, RowBounds rowBounds);

    List<Province> selectByExample(ProvinceExample example);

    Province selectByPrimaryKey(Integer provId);

    int updateByExampleSelective(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByExample(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}