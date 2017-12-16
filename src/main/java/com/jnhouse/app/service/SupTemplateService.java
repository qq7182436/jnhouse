package com.jnhouse.app.service;

import java.util.List;

import com.jnhouse.app.bean.SupTemplate;



public interface SupTemplateService extends BaseService<SupTemplate> {


	List<SupTemplate> findTemplateTitle(SupTemplate supTemplate);
	List<SupTemplate> findAllFirstTemplateTitle(SupTemplate supTemplate);
}
