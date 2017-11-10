package com.mo1451.mapper;

import com.mo1451.model.Cause;
import com.mo1451.model.CauseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CauseMapper {
    long countByExample(CauseExample example);

    int deleteByExample(CauseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cause record);

    int insertSelective(Cause record);

    List<Cause> selectByExample(CauseExample example);

    Cause selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cause record, @Param("example") CauseExample example);

    int updateByExample(@Param("record") Cause record, @Param("example") CauseExample example);

    int updateByPrimaryKeySelective(Cause record);

    int updateByPrimaryKey(Cause record);
}