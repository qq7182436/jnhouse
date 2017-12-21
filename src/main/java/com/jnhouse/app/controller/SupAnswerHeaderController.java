package com.jnhouse.app.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jnhouse.app.bean.FkeEast;
import com.jnhouse.app.bean.SupAnswerHeader;
import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.bean.SupTemplate;
import com.jnhouse.app.dto.SupAnswerHeaderDTO;
import com.jnhouse.app.dto.SupAnswerHeaderLineDTO;
import com.jnhouse.app.utils.DateTimeUtils;
import com.jnhouse.app.utils.StringUtils;

@Controller
public class SupAnswerHeaderController extends BaseController{

	
	@Resource
	ObjectMapper objectMapper;
	
	private Logger Log = Logger.getLogger(SupAnswerHeaderController.class);
	
	/** 
	 * App
	 * @param method    考核开始接口
	 * @param store_id 门店的id
	 * @param template_id  模版的id
	 * @param check_date 进店日期
	 * @param docking_man  对接人
	 * @param start_time  访问开始时间
	 * @param store_around 门店环境
	 * @param broker_num 职业顾问数量
	 * @param customer_num  顾客数量
	 * @param method 点击考核开始按钮
	 * @return re
	 */
	@SuppressWarnings("all")
	@RequestMapping(value = "/jc_house/check_start",method = RequestMethod.POST)
	public @ResponseBody ObjectNode checkStart (HttpServletRequest request){
		ObjectNode re = objectMapper.createObjectNode();
	
		String store_id = (String) request.getParameter("store_id");
		String template_id = (String) request.getParameter("template_id");
		String problem_ids = (String)request.getParameter("problem_ids");//问题的id,问题的id2,问题的id3
		String check_date = (String)request.getParameter("check_date");
		String start_time = (String)request.getParameter("start_time");
		String store_around = (String)request.getParameter("store_around");
		String broker_num =(String)request.getParameter("broker_num");
		String customer_num = (String)request.getParameter("customer_num");
		
		try {
			store_around=new String(store_around.getBytes("ISO-8859-1"),"UTF-8");
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		try {
			Date date= null;
			SupAnswerHeader supAnswerHeader  = new SupAnswerHeader();
			if(StringUtils.isSpace(store_id)){
				store_id = "0";
			}
			if(StringUtils.isSpace(template_id)){
				template_id = "0";
			}
			if(StringUtils.isSpace(start_time)){
				start_time = "0";
			}
			if(!StringUtils.isSpace(check_date)){
				
				date = DateTimeUtils.stringToDate(check_date);
			}
			else if (StringUtils.isSpace(check_date)){
				date = new Date();
			}
			if(StringUtils.isSpace(broker_num)){
				broker_num ="0";
			}
			if(StringUtils.isSpace(customer_num)){
				customer_num = "0";
			}
			if(StringUtils.isSpace(store_around)){
				store_around = "0";
			}
			
			supAnswerHeader.setStore_id(Integer.valueOf(store_id));
			supAnswerHeader.setTemplate_id(Integer.valueOf(template_id));
			supAnswerHeader.setCheck_date(date);
			supAnswerHeader.setStore_around(store_around);
			supAnswerHeader.setEnd_time("0");
			supAnswerHeader.setBroker_num(Integer.valueOf(broker_num));
			supAnswerHeader.setCustomer_num(Integer.valueOf(customer_num));
			supAnswerHeader.setRecording("0");
			supAnswerHeader.setIs_delete(1);
			supAnswerHeader.setStart_time(start_time);
			

			System.out.println("获得的问题的id是"+problem_ids);
		
			//JSONArray jsonArray = JSONArray.fromObject(sTotalString);
			String  [] problemIdss= problem_ids.split(",");
			
			List<SupAnswerHeaderLineDTO> supAnswerHeaderLineDTOList =  new ArrayList<SupAnswerHeaderLineDTO>();

			for (int i = 0; i < problemIdss.length; i++) {
				SupAnswerHeaderLineDTO supAnswerHeaderDTO = new SupAnswerHeaderLineDTO();
				supAnswerHeaderDTO.setProblem_id(Integer.valueOf(problemIdss[i]));
				supAnswerHeaderDTO.setScore(0.0f);
				supAnswerHeaderDTO.setAnswer("0");
				supAnswerHeaderLineDTOList.add(supAnswerHeaderDTO);
				
			}
			List<SupAnswerLine> handIdAndLineIdlist = supAnswerHeaderService.saveAndBackLineIds(supAnswerHeader,supAnswerHeaderLineDTOList);


			if (handIdAndLineIdlist.size() > 0) {
			
				String header_id = handIdAndLineIdlist.get(0).getHeader_id() == null ? "" : handIdAndLineIdlist.get(0).getHeader_id().toString();
				System.out.println(handIdAndLineIdlist.get(0).getHeader_id() == null ? "" : handIdAndLineIdlist.get(0).getHeader_id().toString()+"___________________________");
				ArrayNode node_list = objectMapper.createArrayNode();
				for (SupAnswerLine supAnswerLine2 : handIdAndLineIdlist) {

					ObjectNode re_node = objectMapper.createObjectNode();
					
				
					re_node.put("problem_id", supAnswerLine2.getProblem_id() == null ? "" : supAnswerLine2.getProblem_id().toString());
					re_node.put("line_id", supAnswerLine2.getId()==null ? "" :supAnswerLine2.getId().toString());
					
					node_list.add(re_node);

				}
				re.put("header_id", header_id);
				re.put("data_list", node_list);
				re.put("code", "0");
				re.put("message", "完成");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			re.put("code", "-1");
			re.put("message", "异常");
			e.printStackTrace();
			Log.info("考核开始出异常");
		}
		return re;

	}
	
	/**
	 * App 
	 * @param method   督察考核结束接口
	 * @param line_id  考核明细的id
	 * @param secProblemId  二级问题的id
	 * @param answer_num  答案类型
	 * @param answer 答案内容
	 * @return
	 */
	@RequestMapping(value = "/jc_house/check_stop", method = RequestMethod.GET)
	public @ResponseBody ObjectNode checkStop(HttpServletRequest request) {

		ObjectNode re = objectMapper.createObjectNode();

		String docking_man =  (String)request.getParameter("docking_man");
		String end_time = (String)request.getParameter("end_time");
		String line_ids = (String)request.getParameter("line_ids");
		
		try {
			docking_man=new String(docking_man.getBytes("ISO-8859-1"),"UTF-8");
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*
		 * String line_id = (String)request.getParameter("line_id"); String
		 * secProblemId = (String)request.getParameter("secProblemId"); String
		 * answer_num = (String)request.getParameter("answer_num"); String
		 * answer = (String)request.getParameter("answer");
		 */
		//String sTotalString = (String)request.getParameter("sTotalString"); 
		
		
		try {
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(line_ids);
			JsonArray jsonArray = jsonObject.get("data_list").getAsJsonArray();

			String line_id = "";
			String answer_num = "";
			String answer = "";

			List<SupAnswerLine> supAnswerLinelists = new ArrayList<SupAnswerLine>();
			Timestamp surrces = new Timestamp(System.currentTimeMillis());
			SupAnswerLine supAnswerLine = null;
			float f = 0;
			for (int i = 0; i < jsonArray.size(); i++) {
				JsonObject subObject = jsonArray.get(i).getAsJsonObject();
				
				 supAnswerLine = new SupAnswerLine();

				line_id = subObject.get("line_id").getAsString();
				answer_num = subObject.get("answer_num").getAsString();
				answer = subObject.get("answer").getAsString();
				
				if("1".equals(answer_num)){
					f=1.0f;
				}
				else if("2".equals(answer_num)){
					f=0.0f;
				}
				else if("3".equals(answer_num)){
					f=0.5f;
				}
				supAnswerLine.setScore(f);
				supAnswerLine.setId(Integer.valueOf(line_id));
				
				supAnswerLine.setAnswer_num(Integer.valueOf(answer_num));

				
				supAnswerLine.setAnswer(answer);
				
				supAnswerLine.setCreated_time(surrces);
				
				supAnswerLine.setUpdated_time(surrces);
				
				supAnswerLinelists.add(supAnswerLine);
				
			}
			SupAnswerHeader supAnswerHeader = new SupAnswerHeader();
			supAnswerHeader.setDocking_man(docking_man);
			supAnswerHeader.setEnd_time(end_time);
			int c = supAnswerLineService.updateBatchLineAndSaveHeaderInfo(supAnswerLinelists,supAnswerHeader);
			if (c == 1) {
				re.put("code", "0");
				re.put("message", "完成");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			re.put("code", "-1");
			re.put("message", "异常");
			e.printStackTrace();
			Log.info("考核结束接口出异常");
		} 

		return re;
	}
	/**
	 * App 督察订单展示列表
	 * @param header_id  订单的id(考核主表的id)
	 * @return
	 */
	@SuppressWarnings("all")
	@RequestMapping(value = "/jc_house/order_list", method = RequestMethod.GET)
	public @ResponseBody ObjectNode headerList(HttpServletRequest request) {

		ObjectNode re = objectMapper.createObjectNode();
		ArrayNode node_list = objectMapper.createArrayNode();

		try {
			SupAnswerHeader supAnswerHeader = new SupAnswerHeader();
			supAnswerHeader.setIs_delete(1);
			List<FkeEast> fkeEastList = supAnswerHeaderService.findStoreInfoList(supAnswerHeader);
			
			if (fkeEastList.size() > 0) {
				for (int i = 0; i < fkeEastList.size(); i++) {
					ObjectNode re_node = objectMapper.createObjectNode();
					String store_name = fkeEastList.get(i).getName() == null ? ""
							: fkeEastList.get(i).getName().toString();
					
					String header_id = fkeEastList.get(i).getId() == null ? "" : fkeEastList.get(i).getId().toString();
					for (SupAnswerHeader supAnswerHeader2 : fkeEastList.get(i).getSupAnswerHeaders()) {
						String docking_man = supAnswerHeader2.getDocking_man() == null ? ""
								: supAnswerHeader2.getDocking_man().toString();
						Date date = supAnswerHeader2.getCheck_date();
						
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String check_date = sdf.format(date);
						re_node.put("order_id", header_id);
						re_node.put("store_name", store_name);
						re_node.put("docking_man", docking_man);
						re_node.put("check_date", check_date);
						node_list.add(re_node);
					}
				}

				re.put("data_list", node_list);
				re.put("code", "0");
				re.put("message", "完成");
			} else {
				re.put("code", "207");
				re.put("message", "无订单信息");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			re.put("code", "-1");
			re.put("message", "异常");
			Log.info("督察订单展示列表出异常");
		}
		return re;
	}
	

	/**
	 * @param 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("all")
	@ResponseBody
	@RequestMapping(value = "/jc_house/order_detail", method = RequestMethod.GET)
	public ObjectNode orderDetail(HttpServletRequest request) {

		ObjectNode re = objectMapper.createObjectNode();
		ArrayNode node_list = objectMapper.createArrayNode();
		String order_id = (String) request.getParameter("order_id");
		try {
			SupAnswerHeader supAnswerHeader = new SupAnswerHeader();
			//设置订单的id
			supAnswerHeader.setId(Integer.valueOf(order_id));

			//查询详情
			SupAnswerHeaderDTO supAnswerHeader1 = supAnswerHeaderService.supAnswerHeader(supAnswerHeader);
			String parent_id = "";
			String header_id = "";
			String docking_man = "";
			String store_name = "";
			String menu_title = "";
			String start_time = "";
			String end_time = "";
			String store_around = "";
			String customer_num = "";
			String broker_num = "";
			String  check_date = null;
			if (supAnswerHeader1 != null) {
				parent_id = supAnswerHeader1.getTemplate_id().toString();
				header_id = supAnswerHeader1.getId().toString();
				docking_man = supAnswerHeader1.getDocking_man();
				store_name = supAnswerHeader1.getFkeEast().getName();
				Date date = supAnswerHeader1.getCheck_date();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				check_date = sdf.format(date);
				menu_title = supAnswerHeader1.getSupTemplate().getMenu_title();
				
				
				start_time = supAnswerHeader1.getStart_time();
				end_time = supAnswerHeader1.getEnd_time();
				
//				System.out.println(start_time+"====="+end_time);
				store_around = supAnswerHeader1.getStore_around() == null ? ""
						: supAnswerHeader1.getStore_around().toString();
				customer_num = supAnswerHeader1.getCustomer_num()==null ? "" : supAnswerHeader1.getCustomer_num().toString();
				broker_num = supAnswerHeader1.getBroker_num() == null ? "" :supAnswerHeader1.getBroker_num().toString();
				
				SupTemplate supTemplate = new SupTemplate();
				supTemplate.setParent_id(Integer.valueOf(parent_id));
				
				//查询一级问题
				List<SupTemplate> supTemplates = supTemplateService.findTemplateTitle(supTemplate);
				
				SupAnswerHeaderDTO supAnswerHeaderDTO1 = new SupAnswerHeaderDTO();
				supAnswerHeaderDTO1.setParent_id(Integer.valueOf(parent_id));
				supAnswerHeaderDTO1.setHeader_id(Integer.valueOf(header_id));
					
				ObjectNode re_node3 = null;
				ArrayNode nodeList2 = null;

				String  get_score = "";
				Map<String, Object> secProblemMap = null;
				Map<String, Map<String, Object>> secProblemTitleMap = null;
				SupAnswerLine supTemplate2 = null;
				int score=0;
				for (int i = 0; i < supTemplates.size(); i++) {
					re_node3 = objectMapper.createObjectNode();
					nodeList2 = objectMapper.createArrayNode();
					
					String id = supTemplates.get(i).getId() ==null ? "" :supTemplates.get(i).getId().toString();
					String menu_title2 = supTemplates.get(i).getMenu_title() ==null ? "" :supTemplates.get(i).getMenu_title().toString();
					
					
					List<SupTemplate> supTemplatesSec = null;
					secProblemTitleMap = new HashMap<String, Map<String, Object>>();
					supAnswerHeaderDTO1.setParent_id(supTemplates.get(i).getId());
					List<SupAnswerHeaderDTO> supAnswerHeaderDTOs2 = supAnswerHeaderService
							.findAnswerHeaderAndLine(supAnswerHeaderDTO1);
					
					//如果取不到二级标题
					if(supAnswerHeaderDTOs2.size()<1){
						supAnswerHeaderDTO1.setParent_id(Integer.valueOf(id));
						supAnswerHeaderDTOs2 = supAnswerHeaderService.findSecondHeader(supAnswerHeaderDTO1);
					}
					for (SupAnswerHeaderDTO supAnswerHeaderDTO : supAnswerHeaderDTOs2) {
						secProblemMap = new HashMap<String,Object>();
						String secProblem_id = supAnswerHeaderDTO.getSupTemplateDTO().getId().toString();
						
						String three_menu_title3 = supAnswerHeaderDTO.getSupTemplateDTO().getMenu_title3();
						
						
						String answer2 = supAnswerHeaderDTO.getSupAnswerLine().getAnswer();
						get_score = supAnswerHeaderDTO.getGet_score()==null ? "" :supAnswerHeaderDTO.getGet_score().toString();

						if(!StringUtils.isSpace(get_score)){
							score = Integer.valueOf(get_score);
						}
						String file_name = supAnswerHeaderDTO.getFkeFile().getFile_name()==null ? "" :supAnswerHeaderDTO.getFkeFile().getFile_name().toString();
						String file_url = supAnswerHeaderDTO.getFkeFile().getFile_url()==null ? "" : supAnswerHeaderDTO.getFkeFile().getFile_url().toString();
						
						file_url=file_url+file_name;
						

						Integer answer_num2 = supAnswerHeaderDTO.getSupAnswerLine().getAnswer_num();

						
						if (secProblemTitleMap.containsKey(secProblem_id)) {
						
						} else {
							secProblemMap.put("sec_menu_title", three_menu_title3);
							secProblemMap.put("answer", answer2);
							secProblemMap.put("answer_num", answer_num2);
							secProblemMap.put("file_url", file_url);
							secProblemTitleMap.put(secProblem_id, secProblemMap);
						}
						score++;
					}
					for (String secKey : secProblemTitleMap.keySet()) {
						ObjectNode re_node2 = objectMapper.createObjectNode();
						re_node2.put("secId", secKey);

						re_node2.put("sec_menu_title", secProblemTitleMap.get(secKey).get("sec_menu_title") == null ? ""
								: secProblemTitleMap.get(secKey).get("sec_menu_title").toString());

						re_node2.put("answer", secProblemTitleMap.get(secKey).get("answer") == null ? ""
								: secProblemTitleMap.get(secKey).get("answer").toString());
						re_node2.put("answer_num", secProblemTitleMap.get(secKey).get("answer_num") == null ? ""
								: secProblemTitleMap.get(secKey).get("answer_num").toString());
						
						re_node2.put("file_url", secProblemTitleMap.get(secKey).get("file_url") == null ? ""
								: secProblemTitleMap.get(secKey).get("file_url").toString());

						nodeList2.add(re_node2);
					}

					re_node3.put("menu_title", menu_title2);
					System.err.println( nodeList2);
					re_node3.put("sec_list", nodeList2);

					node_list.add(re_node3);
				}
				re.put("template_title", menu_title);
				re.put("check_date", check_date);
				re.put("store_name", store_name);
				re.put("docking_man", docking_man);
				re.put("start_time", start_time);
				re.put("end_time", end_time);
				re.put("get_score", String.valueOf(score));
				re.put("store_around", store_around);
				re.put("customer_num", customer_num);
				re.put("broker_num", broker_num);
				re.put("data_list", node_list);
				re.put("code", "0");
				re.put("message", "完成");		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			re.put("code", "-1");
			re.put("message", "异常");
			//e.printStackTrace();
		}
		return re;
	}

	
}
