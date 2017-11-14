package com.mo1451.mapper;

import com.mo1451.model.Ninescreen;
import com.mo1451.model.NinescreenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NinescreenMapper {
    long countByExample(NinescreenExample example);

    int deleteByExample(NinescreenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ninescreen record);

    int insertSelective(Ninescreen record);

    List<Ninescreen> selectByExample(NinescreenExample example);

    Ninescreen selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ninescreen record, @Param("example") NinescreenExample example);

    int updateByExample(@Param("record") Ninescreen record, @Param("example") NinescreenExample example);

    int updateByPrimaryKeySelective(Ninescreen record);

    int updateByPrimaryKey(Ninescreen record);
}