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
	
	List<SupTemplate> fke_template();
	//根据fathername获取id
	int getParentidByfm(String fm);
	void updateTemplate(Map<String,Object> param);
	void insertNexteTemplate(Map<String,Object> param);
	void delete_template(int id);

}