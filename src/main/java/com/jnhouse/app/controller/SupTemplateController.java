package com.jnhouse.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jnhouse.app.bean.SupTemplate;
import com.jnhouse.app.service.SupTemplateService;
import com.jnhouse.app.utils.DateTimeUtils;
import com.jnhouse.app.utils.FileUploadFtpUtils;
import com.jnhouse.app.utils.FileUploadUtils;
import com.jnhouse.app.utils.StringUtils;

@Controller
public class SupTemplateController extends BaseController{

	@Resource
	ObjectMapper objectMapper;
	
	
	@Resource
	SupTemplateService supTemplateService;
	
	
	//private static final Logger LOG = LoggerFactory.getLogger(FtpsFileList.class);
	

	//private Logger log = Logger.getAnonymousLogger(this.getClass());

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
	
	/**
	 * App 上传稽查门店图片接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/jc_house/upload_picture", method = RequestMethod.POST)
	public @ResponseBody ObjectNode uploadPicture(HttpServletRequest request,MultipartHttpServletRequest multiRequest) {

		//System.out.println("===============");
		ObjectNode re = objectMapper.createObjectNode();
		String store_id = (String) request.getParameter("store_id");// 门店的id
		String template_id = (String) request.getParameter("template_id");//模版的id

		String lead_person = (String) request.getParameter("lead_person");//上传人

		String jc_store_picture = (String)request.getParameter("jc_store_picture");
		String jc_picture="";
		


		/*try {

			//运算符是用来在运行时指出对象是否是特定类的一个实例
			if (request instanceof MultipartHttpServletRequest) {
			
				
				MultipartFile jc_pictureFile = ((MultipartHttpServletRequest) request).getFile("jc_store_picture");//稽查门店图片
				System.out.println(jc_pictureFile+"==============");
				if (jc_pictureFile.getSize() > 0) {
					String documentWay = "/store_img"
							+ DateTimeUtils.getNowTimeStr("yyyy-MM-dd") + "/";
					String fileName = jc_pictureFile.getOriginalFilename();
					// 把文件名字换成系统时间
					
					System.out.println("获得文件路径"+documentWay);
					fileName = System.currentTimeMillis()
							+ fileName.substring(fileName.lastIndexOf("."));
					FileUploadFtpUtils ftp = new FileUploadFtpUtils();
					
					System.out.println(fileName+"_-------------------");
					ftp.connect(documentWay);
					ftp.upload(fileName, jc_pictureFile.getInputStream());
					jc_picture =  documentWay + fileName;
					
					System.out.println(jc_picture+"==============");
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			
		re.put("code", "0");
		return re;
	
	}
}

