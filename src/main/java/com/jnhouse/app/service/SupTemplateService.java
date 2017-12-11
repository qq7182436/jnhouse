package com.jnhouse.app.service;

import java.util.List;
import java.util.Map;

import com.jnhouse.app.bean.SupTemplate;
import com.jnhouse.app.bean.Template;



public interface SupTemplateService extends BaseService<SupTemplate> {


	List<SupTemplate> findTemplateTitle(SupTemplate supTemplate);
	List<SupTemplate> findAllFirstTemplateTitle(SupTemplate supTemplate);
	List<Template> fke_template();
	//根据fathername获取id
	int getParentidByfm(String fm);
	
	void updateTemplate(Map<String,Object> param);
	void insertNexteTemplate(Map<String,Object> param);
	void delete_template(int id);
}
