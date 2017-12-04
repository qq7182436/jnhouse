package com.jnhouse.app.controller;

import org.springframework.stereotype.Controller;

@Controller
public class SupAnswerHeaderController extends BaseController{
	

	
	
/*	@Autowired
	private JdbcTemplate jdbcTemplateJnHouse;
	
	
	@Autowired
	private ObjectMapper objectMapper;

	
	
	//private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	//模版列表
		@RequestMapping(value = "/jc_house/template_list", method = RequestMethod.GET)
		public @ResponseBody ObjectNode templateList(HttpServletRequest reuqest) {

			ObjectNode re = objectMapper.createObjectNode();
			ArrayNode nodeList = objectMapper.createArrayNode();
		//	ArrayNode nodeList2 = objectMapper.createArrayNode();

		
			
			String id = (String) reuqest.getParameter("id");// 模版的id

			String sql = " select id,menu_title from jnhouseweb_ceshi.fke_supervision_template where parent_id='" + id
					+ "' and menu_level=1 ";

			List<Map<String, Object>> templateList = jdbcTemplateJnHouse.queryForList(sql);
			if (templateList.size() > 0) {
				Map<String, Object> map = null;
				for (int i = 0; i < templateList.size(); i++) {
					ObjectNode re_node3 = objectMapper.createObjectNode();
					ArrayNode nodeList2= objectMapper.createArrayNode();
					map = templateList.get(i);

					// String template_title = map.get("menu_tile") ==null ? "" :
					// map.get("menu_title").toString();
					String template_id = map.get("id") == null ? "" : map.get("id").toString();
					String template_title = map.get("menu_title") == null ? "" : map.get("menu_title").toString();
					
					
					System.out.println(template_id+"-------------------");
					String secSql = "select id,menu_title from jnhouseweb_ceshi.fke_supervision_template where parent_id = '"
							+ template_id + "' ";

					List<Map<String, Object>> secList = jdbcTemplateJnHouse.queryForList(secSql);

					System.err.println(secSql);

			
					Map<String, Map<String, Object>> templateSecTitleMap = new HashMap<String, Map<String, Object>>();
					Map<String, Object> templateIdMap = null;

					for (Map<String, Object> map2 : secList) {

						
						templateIdMap = new HashMap<String, Object>();
						String secId = map2.get("id") == null ? "" : map2.get("id").toString();
						String secTitle = map2.get("menu_title") == null ? "" : map2.get("menu_title").toString();

						// 如果此映射包含对于指定键的映射关系，则返回 true
						if (templateSecTitleMap.containsKey(secId)) {

							System.out.println("在Map集合中包含键名" + secId);  
						} else {
							//System.out.println(templateSecTitleMap);
							templateIdMap.put("sec_title", secTitle);
							templateSecTitleMap.put(secId, templateIdMap);
						
						}
					}
					
					
					for (String secKey : templateSecTitleMap.keySet()) {
						ObjectNode re_node2 = objectMapper.createObjectNode();
						re_node2.put("secId", secKey);
						re_node2.put("secTitle", templateSecTitleMap.get(secKey).get("sec_title") ==null ? "" : templateSecTitleMap.get(secKey).get("sec_title").toString());

						nodeList2.add(re_node2);
					}

					re_node3.put("template_id", template_id);
					re_node3.put("template_title", template_title);
					re_node3.put("sec_list", nodeList2);
					nodeList.add(re_node3);

					
				}
				re.put("date_list", nodeList);
			}
			return re;
		}*/
	
}
