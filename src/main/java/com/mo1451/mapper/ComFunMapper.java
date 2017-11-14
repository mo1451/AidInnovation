package com.mo1451.mapper;

import com.mo1451.model.ComFun;
import com.mo1451.model.ComFunExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComFunMapper {
    long countByExample(ComFunExample example);

    int deleteByExample(ComFunExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ComFun record);

    int insertSelective(ComFun record);

    List<ComFun> selectByExample(ComFunExample example);

    ComFun selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ComFun record, @Param("example") ComFunExample example);

    int updateByExample(@Param("record") ComFun record, @Param("example") ComFunExample example);

    int updateByPrimaryKeySelective(ComFun record);

    int updateByPrimaryKey(ComFun record);
}