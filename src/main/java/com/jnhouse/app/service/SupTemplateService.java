package com.jnhouse.app.service;

import java.util.List;
import java.util.Map;

import com.jnhouse.app.bean.SupTemplate;




public interface SupTemplateService extends BaseService<SupTemplate> {


	List<SupTemplate> findTemplateTitle(SupTemplate supTemplate);
	List<SupTemplate> findAllFirstTemplateTitle(SupTemplate supTemplate);
	List<SupTemplate> fke_template(Map<String,Object> map);	
	void updateTemplate(Map<String,Object> param);
	void insertNexteTemplate(Map<String,Object> param);
	void delete_template(int id);
}
