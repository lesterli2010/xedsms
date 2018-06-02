package com.hxdq.xedsms.db.model;

import com.hxdq.xedsms.db.Mapper;
import com.hxdq.xedsms.db.model.Dkspecinfo;
import com.hxdq.xedsms.db.model.DkspecinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DkspecinfoMapper extends Mapper {
    int countByExample(DkspecinfoExample example);

    int deleteByExample(DkspecinfoExample example);

    int deleteByPrimaryKey(Integer dkspecId);

    int insert(Dkspecinfo record);

    int insertSelective(Dkspecinfo record);

    List<Dkspecinfo> selectByExampleWithRowbounds(DkspecinfoExample example, RowBounds rowBounds);

    List<Dkspecinfo> selectByExample(DkspecinfoExample example);

    Dkspecinfo selectByPrimaryKey(Integer dkspecId);

    int updateByExampleSelective(@Param("record") Dkspecinfo record, @Param("example") DkspecinfoExample example);

    int updateByExample(@Param("record") Dkspecinfo record, @Param("example") DkspecinfoExample example);

    int updateByPrimaryKeySelective(Dkspecinfo record);

    int updateByPrimaryKey(Dkspecinfo record);
}