package com.jnhouse.app.dao;

import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.SupAnswerHeaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupAnswerHeaderMapper {
    long countByExample(SupAnswerHeaderExample example);

    int deleteByExample(SupAnswerHeaderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupAnswerHeader record);

    int insertSelective(SupAnswerHeader record);

    List<SupAnswerHeader> selectByExample(SupAnswerHeaderExample example);

    SupAnswerHeader selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SupAnswerHeader record, @Param("example") SupAnswerHeaderExample example);

    int updateByExample(@Param("record") SupAnswerHeader record, @Param("example") SupAnswerHeaderExample example);

    int updateByPrimaryKeySelective(SupAnswerHeader record);

    int updateByPrimaryKey(SupAnswerHeader record);
}