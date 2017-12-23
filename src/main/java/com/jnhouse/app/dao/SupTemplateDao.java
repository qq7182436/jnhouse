package com.jnhouse.app.dao;

import java.util.List;
import java.util.Map;

import com.jnhouse.app.bean.SupTemplate;


public interface SupTemplateDao extends BaseDao<SupTemplate>{
	
	/**
	 * 查询模版标题
	 * @Return
	 */
	List<SupTemplate> findTemplateTitle(SupTemplate supTemplate);
	
	List<SupTemplate> findAllFirstTemplateTitle(SupTemplate supTemplate);
	
	List<SupTemplate> fke_template(Map<String,Object> map);
	void updateTemplate(Map<String,Object> param);
	void insertNexteTemplate(Map<String,Object> param);
	void delete_template(Map<String,Object> map);
	List<SupTemplate> isHaveLevelCount(String param);
	SupTemplate getMaxTemplate();
	SupTemplate selectByPrimaryKey(Integer id);
}