package com.jnhouse.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jnhouse.app.bean.SupTemplate;
import com.jnhouse.app.service.SupTemplateService;
import com.jnhouse.app.utils.ResultData;
import com.jnhouse.app.utils.SftpUtils;
import com.jnhouse.app.utils.StringUtils;

@Controller
public class SupTemplateController extends BaseController{

	@Resource
	ObjectMapper objectMapper;
	
	
	@Resource
	SupTemplateService supTemplateService;
	
	@Resource
	
	
	//private static final Logger LOG = LoggerFactory.getLogger(FtpsFileList.class);
	

	private Logger log = Logger.getLogger(SupTemplateController.class);

	/**
	 * 考核开始  -->点击考核开始按钮
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/jc_house/check_start",method = RequestMethod.POST)
	public @ResponseBody ObjectNode checkStart (HttpServletRequest request){
		ObjectNode re = objectMapper.createObjectNode();
		
		String store_id = (String) request.getParameter("store_id");// 门店的id
		String template_id = (String) request.getParameter("template_id");//模版的id
		String docking_man =(String) request.getParameter("docking_man");//对接人
		String start_time = (String)request.getParameter("start_time");//访问开始时间
		String store_around =(String) request.getParameter("store_around");//考核环境
		String broker_num = (String)request.getParameter("broker_num");//顾客的数量
		String customer_num = (String)request.getParameter("customer_num");//职业顾问的数量
		
		
		
		
		
		return null;
	}
	@RequestMapping(value = "/jc_house/findAllfirstTemplate", method = RequestMethod.GET)
	public @ResponseBody ObjectNode findAllfirstTemplate(HttpServletRequest reuqest) {
		
		ObjectNode re = objectMapper.createObjectNode();
		ArrayNode nodeList = objectMapper.createArrayNode();
		
		
		SupTemplate supTemplate = new SupTemplate();
		supTemplate.setMenu_level(0);
		try {
			List<SupTemplate> list = supTemplateService.findAllFirstTemplateTitle(supTemplate);
			

			if(list.size()>0){
				for (int i = 0; i < list.size(); i++) {
					ObjectNode re_node = objectMapper.createObjectNode();
					supTemplate = list.get(i);
					String template_id = supTemplate.getId() == null ? "" : supTemplate.getId().toString();
					String template_title = supTemplate.getMenu_title() ==null ? "" : supTemplate.getMenu_title().toString();
					
					re_node.put("template_id", template_id);
					re_node.put("template_title", template_title);
					
					nodeList.add(re_node);
				}
				re.put("template_list", nodeList);
				re.put("code", "0");
				re.put("message", "完成");
				
			}
			else{
				re.put("template_list", nodeList);
				re.put("code", "207");
				re.put("message", "暂无数据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			re.put("code", "-1");
			re.put("message", "异常");
		}
		return re;
	}
	 
/*	//**
	 * 二级,三级问题模版菜单列表
	 * @param id
	 * @return
	 //*
*/	@RequestMapping(value = "/jc_house/menu_problem_list", method = RequestMethod.GET)
	public @ResponseBody ObjectNode templateList(HttpServletRequest reuqest) {
	
		ObjectNode re = objectMapper.createObjectNode();
		ArrayNode nodeList = objectMapper.createArrayNode();
		// ArrayNode nodeList2 = objectMapper.createArrayNode();

		try {
			String template_id = (String) reuqest.getParameter("template_id");// 模版的id

			

			SupTemplate supTemplate = new SupTemplate();
			
			
			if(!StringUtils.isSpace(template_id)){
				supTemplate.setParent_id(Integer.parseInt(template_id));
			}
			else{
				supTemplate.setParent_id(0);
			}
			supTemplate.setIs_delete(1);
			
			
			List<SupTemplate> supTemplates =  supTemplateService.findTemplateTitle(supTemplate);

			
			SupTemplate subTemplate = null;
			String id = "";
			String template_title  = "";
			if (supTemplates.size() > 0) {
				//Map<String, SupTemplate> map = null;
				for (int i = 0; i < supTemplates.size(); i++) {
					ObjectNode re_node3 = objectMapper.createObjectNode();
					ArrayNode nodeList2 = objectMapper.createArrayNode();
					subTemplate = supTemplates.get(i);
					// String template_title = map.get("menu_tile") ==null ? "" :
					// map.get("menu_title").toString();
					id = subTemplate.getId() == null ? "" : subTemplate.getId().toString();
					template_title = subTemplate.getMenu_title() == null ? "" : subTemplate.getMenu_title().toString();


					SupTemplate supTemplate2 = new SupTemplate();
					if(!StringUtils.isSpace(id)){
						supTemplate2.setParent_id(Integer.parseInt(id));
					}
					else{
						supTemplate2.setParent_id(0);
					}
					supTemplate2.setIs_delete(1);
					List<SupTemplate> supTemplatesSec =  supTemplateService.findTemplateTitle(supTemplate2);
					
					Map<String, Map<String, Object>> templateSecTitleMap = new HashMap<String, Map<String, Object>>();
					Map<String, Object> templateIdMap = null;

					for (SupTemplate supTemplate3 : supTemplatesSec) {
						templateIdMap = new HashMap<String, Object>();
						String secId = supTemplate3.getId() == null ? "" : supTemplate3.getId().toString();
						String secTitle = supTemplate3.getMenu_title() == null ? "" : supTemplate3.getMenu_title().toString();
						
						System.err.println(secTitle+"***********");
						// 如果此映射包含对于指定键的映射关系，则返回 true
						if (templateSecTitleMap.containsKey(secId)) {

							System.out.println("在Map集合中包含键名" + secId);
						} else {
							// System.out.println(templateSecTitleMap);
							templateIdMap.put("sec_title", secTitle);
							templateSecTitleMap.put(secId, templateIdMap);
						}
					}
					


					for (String secKey : templateSecTitleMap.keySet()) {
						ObjectNode re_node2 = objectMapper.createObjectNode();
						re_node2.put("secId", secKey);
						re_node2.put("secTitle", templateSecTitleMap.get(secKey).get("sec_title") == null ? ""
								: templateSecTitleMap.get(secKey).get("sec_title").toString());

						nodeList2.add(re_node2);
					}

					re_node3.put("templateMenu_id", template_id);//模版二级问题id
					re_node3.put("templateMenu_title", template_title);//模版二级问题标题
					re_node3.put("sec_list", nodeList2);
					nodeList.add(re_node3);

				}
				//re.put("date_list", nodeList);
				re.put("date_list", nodeList);
				re.put("code", "0");
				re.put("message", "完成");
			}
			else{
				re.put("code", "207");
				re.put("message", "暂无数据");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			re.put("code", "-1");
			re.put("message", "完成");
			e.printStackTrace();
		}
		return re;
	}
	

	
	
	
}

