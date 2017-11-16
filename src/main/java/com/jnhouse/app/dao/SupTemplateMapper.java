package com.jnhouse.app.dao;

import com.jnhouse.app.bean.SupTemplate;
import com.jnhouse.app.bean.SupTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupTemplateMapper {
    long countByExample(SupTemplateExample example);

    int deleteByExample(SupTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupTemplate record);

    int insertSelective(SupTemplate record);

    List<SupTemplate> selectByExample(SupTemplateExample example);

    SupTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SupTemplate record, @Param("example") SupTemplateExample example);

    int updateByExample(@Param("record") SupTemplate record, @Param("example") SupTemplateExample example);

    int updateByPrimaryKeySelective(SupTemplate record);

    int updateByPrimaryKey(SupTemplate record);
}