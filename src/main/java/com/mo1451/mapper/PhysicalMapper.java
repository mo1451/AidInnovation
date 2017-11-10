package com.mo1451.mapper;

import com.mo1451.model.Physical;
import com.mo1451.model.PhysicalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhysicalMapper {
    long countByExample(PhysicalExample example);

    int deleteByExample(PhysicalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Physical record);

    int insertSelective(Physical record);

    List<Physical> selectByExample(PhysicalExample example);

    Physical selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Physical record, @Param("example") PhysicalExample example);

    int updateByExample(@Param("record") Physical record, @Param("example") PhysicalExample example);

    int updateByPrimaryKeySelective(Physical record);

    int updateByPrimaryKey(Physical record);
}