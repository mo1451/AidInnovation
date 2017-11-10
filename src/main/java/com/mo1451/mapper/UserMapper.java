package com.mo1451.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mo1451.model.Page;
import com.mo1451.model.User;
import com.mo1451.model.UserExample;
import com.mo1451.model.UserSearch;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithBLOBs(UserExample example);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExampleWithBLOBs(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectByPage(Page Page);

	int countAllUser();

	List<User> selectByUserSearch(UserSearch userSearch);

	int countSearch(User user);
}