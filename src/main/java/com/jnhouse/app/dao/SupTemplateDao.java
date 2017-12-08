package com.jnhouse.app.dao;

import java.util.List;

import com.jnhouse.app.bean.SupTemplate;
import com.jnhouse.app.bean.Template;

public interface SupTemplateDao extends BaseDao<SupTemplate>{
	
	/**
	 * 查询模版标题
	 * @Return
	 */
	List<SupTemplate> findTemplateTitle(SupTemplate supTemplate);
	
	List<SupTemplate> findAllFirstTemplateTitle(SupTemplate supTemplate);
	
	List<Template> fke_template();
}