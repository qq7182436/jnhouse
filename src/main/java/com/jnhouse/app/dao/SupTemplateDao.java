package com.jnhouse.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jnhouse.app.bean.SupTemplate;
import com.jnhouse.app.dto.SupTemplateDTO;

public interface SupTemplateDao extends BaseDao<SupTemplate>{
	
	/**
	 * 查询模版标题
	 * @Return 
	 */
	List<SupTemplate> findTemplateTitle(SupTemplate supTemplate);
	
	List<SupTemplate> findAllFirstTemplateTitle(SupTemplate supTemplate);
	
	 List<SupTemplate> orderVerdict(@Param("aList") List<Integer> aList);
	 
	 /**
	  * App 查询三级的问题的标题
	  * @param supTemplate
	  * @return
	  */
	 List<SupTemplate> findThreeProlem(SupTemplate supTemplate);

}