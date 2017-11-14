package com.mo1451.mapper;

import com.mo1451.model.ObjField;
import com.mo1451.model.ObjFieldExample;
import com.mo1451.model.ObjFieldWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjFieldMapper {
    long countByExample(ObjFieldExample example);

    int deleteByExample(ObjFieldExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ObjFieldWithBLOBs record);

    int insertSelective(ObjFieldWithBLOBs record);

    List<ObjFieldWithBLOBs> selectByExampleWithBLOBs(ObjFieldExample example);

    List<ObjField> selectByExample(ObjFieldExample example);

    ObjFieldWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ObjFieldWithBLOBs record, @Param("example") ObjFieldExample example);

    int updateByExampleWithBLOBs(@Param("record") ObjFieldWithBLOBs record, @Param("example") ObjFieldExample example);

    int updateByExample(@Param("record") ObjField record, @Param("example") ObjFieldExample example);

    int updateByPrimaryKeySelective(ObjFieldWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ObjFieldWithBLOBs record);

    int updateByPrimaryKey(ObjField record);
}