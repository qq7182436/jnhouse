package com.jnhouse.app.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jnhouse.app.bean.SupTemplate;
import com.jnhouse.app.service.SupTemplateService;
import com.jnhouse.app.utils.StringUtils;
import java.util.Date;
import java.text.SimpleDateFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class SupTemplateController extends BaseController{

	
	ObjectMapper objectMapper = new ObjectMapper();
	
	
	@Resource
	SupTemplateService supTemplateService;

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
	@SuppressWarnings("deprecation")
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
	 
	/**
	 * 二级,三级问题模版菜单列表
	 * @param id
	 * @return
	 */
	@SuppressWarnings("all")
	@RequestMapping(value = "/jc_house/menu_problem_list", method = RequestMethod.GET)
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

	@RequestMapping(value = "/jc_house/template")
	public ModelAndView template_views(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inspection/template");
		return modelAndView;
	}
	
	//获取模板列表
	@RequestMapping(value = "/jc_house/fke_template",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject fke_template(HttpServletRequest request) {
		String id = request.getParameter("template_id");
		Map<String,Object> par = new HashMap<>();
		par.put("id", id);
		List<SupTemplate> template = supTemplateService.fke_template(par);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonobj = new JSONObject(); 
		Map<String,Object> map = new HashMap<String,Object>(); 
		 //循环建立菜单树
		for (int i = 0; i < template.size(); i++) {
			jsonobj.put("id",template.get(i).getId());
			jsonobj.put("pId", template.get(i).getParent_id());
			jsonobj.put("name", template.get(i).getMenu_title());
			jsonobj.put("sort", template.get(i).getSort());
			jsonobj.put("menu_level", template.get(i).getMenu_level());
			jsonobj.put("score", template.get(i).getScore());
			if (template.get(i).getMenu_level() == 0) {
				jsonobj.put("open", false);
				jsonobj.put("iconSkin", "pIcon01");
			}else if (template.get(i).getMenu_level() == 1) {
				jsonobj.put("iconSkin", "icon02");
			}else {
				jsonobj.put("iconSkin", "icon03");
			}
			
			jsonArray.add(jsonobj);
		}
		map.put("zNodes", jsonArray);
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject;
	}
	
	//更改模板
	@RequestMapping(value = "/jc_house/save_template",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject save_template(HttpServletRequest request) {
		JSONObject jsonObject = null;
		String menu_level = request.getParameter("menu_level");//
		String score = request.getParameter("score");
		String name = request.getParameter("name");//menu_title
		String id = request.getParameter("id");
		String fathername = request.getParameter("father_name");
		Map<String,Object> param = new HashMap<>();
		param.put("menu_level",menu_level );
		param.put("score", score);
		param.put("menu_title", name);
		param.put("id", id);
		try {
			//更改模板
			supTemplateService.updateTemplate(param);
			JSONObject jsonobj = new JSONObject(); 
			SupTemplate te = supTemplateService.selectByPrimaryKey(Integer.parseInt(id));
			jsonobj.put("id",te.getId());
			jsonobj.put("pId", te.getParent_id());
			jsonobj.put("name", te.getMenu_title());
			jsonobj.put("sort", te.getSort());
			jsonobj.put("menu_level", te.getMenu_level());
			jsonobj.put("score", te.getScore());
			if (te.getMenu_level() == 0) {
				jsonobj.put("open", false);
				jsonobj.put("iconSkin", "pIcon01");
			}else if (te.getMenu_level() == 1) {
				jsonobj.put("iconSkin", "icon02");
			}else {
				jsonobj.put("iconSkin", "icon03");
			}
			jsonobj.put("success", true);
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("treeNode", jsonobj);
			jsonObject = JSONObject.fromObject(map);			
		}catch(Exception e) {
			e.printStackTrace();			
		}
		
		return jsonObject;
	}
	
	//保存模板
	@RequestMapping(value = "/jc_house/save_next_template",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject save_next_template(HttpServletRequest request) {
		JSONObject jsonObject = null;
		String menu_level = request.getParameter("menu_level");//
		String score = request.getParameter("score");
		String name = request.getParameter("name");//menu_title
		String fathername = request.getParameter("father_name");
		String father_id = request.getParameter("father_id");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Map<String,Object> param = new HashMap<>();
		param.put("menu_level",menu_level );
		param.put("score", score);
		param.put("menu_title", name);
		param.put("updated_time", df.format(new Date()));
		param.put("created_time", df.format(new Date()));
		if(Integer.parseInt(menu_level) == 0) {
			param.put("parent_id", 0);
		}else {			
			param.put("parent_id", father_id);
		}
		try {
			supTemplateService.insertNexteTemplate(param);
			JSONObject jsonobj = new JSONObject(); 
			SupTemplate te = supTemplateService.getMaxTemplate();
			jsonobj.put("id",te.getId());
			jsonobj.put("pId", te.getParent_id());
			jsonobj.put("name", te.getMenu_title());
			jsonobj.put("sort", te.getSort());
			jsonobj.put("menu_level", te.getMenu_level());
			jsonobj.put("score", te.getScore());
			if (te.getMenu_level() == 0) {
				jsonobj.put("open", false);
				jsonobj.put("iconSkin", "pIcon01");
			}else if (te.getMenu_level() == 1) {
				jsonobj.put("iconSkin", "icon02");
			}else {
				jsonobj.put("iconSkin", "icon03");
			}
			jsonobj.put("success", true);
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("treeNode", jsonobj);
			jsonObject = JSONObject.fromObject(map);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return jsonObject;
	}
	//删除模板
	@RequestMapping(value="/jc_house/delete_template",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject delete_dept(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		JSONObject jsonObject = new JSONObject();
		String template_id = request.getParameter("template_id");
		String menu_level = request.getParameter("menu_level");
		map.put("template_id", template_id);
		map.put("menu_level", menu_level);
		try {			
			int id = Integer.parseInt(template_id);
			supTemplateService.delete_template(map);			  
			jsonObject.put("msg", "删除成功");			
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("msg", "删除失败");
		}

		return jsonObject;
	}

}

