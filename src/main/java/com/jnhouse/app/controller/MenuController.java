package com.jnhouse.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jnhouse.app.bean.Menu;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class MenuController extends BaseController{

	/**
	 * 菜单页面
	 * @param request
	 * @author lou
	 * @return
	 */
	@RequestMapping(value="menu/menu_views")
	public ModelAndView menu_views(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sys/menu");
		return modelAndView;
	}
	
	/**
	 * 通过ajax获取菜单列表
	 * @param request
	 * @author lou
	 * @return
	 */
	@RequestMapping(value="/menu/aJsonMenu",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject aJsonObject(HttpServletRequest request) {
		List<Menu> Menus = menuService.findAll(); //取得所有菜单
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonobj = new JSONObject(); 
		Map<String,Object> map = new HashMap<String,Object>(); 
		 //循环建立菜单树
		for (int i = 0; i < Menus.size(); i++) {
			jsonobj.put("id",Menus.get(i).getId());
			jsonobj.put("pId", Menus.get(i).getFather_id());
			jsonobj.put("name", Menus.get(i).getMenu_name());
			jsonobj.put("sort", Menus.get(i).getSort());
			jsonobj.put("menu_level", Menus.get(i).getMenu_level());
			jsonobj.put("menu_url", Menus.get(i).getUrl());
			if (Menus.get(i).getMenu_level() == 1) {
				jsonobj.put("open", true);
				jsonobj.put("iconSkin", "pIcon01");
			}else if (Menus.get(i).getMenu_level() == 2) {
				jsonobj.put("iconSkin", "icon03");
			}else {
				jsonobj.put("iconSkin", "icon03");
			}
			
			jsonArray.add(jsonobj);
		}
		map.put("zNodes", jsonArray);
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject;
	}
	
	/**
	 * 添加同级菜单
	 * @param request
	 * @author lou
	 * @return
	 */
	@RequestMapping(value="/menu/add_level",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject add_same_level(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			Integer menu_level = Integer.valueOf(request.getParameter("menu_level")); //菜单等级
			Integer father_id = Integer.valueOf(request.getParameter("father_id")); //父菜单
			System.err.println(menu_level + "-----" + father_id);
			Menu menu = new Menu();
			menu.setMenu_level(menu_level);
			menu.setFather_id(father_id);
			Integer maxSort = menuService.findMaxValue(menu);//取得最大排序号
			//最大排序号为空时，设置排序号从0开始
			if (maxSort == null) {
				maxSort = 0;
			}
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("maxSort", maxSort);
			jsonObject = JSONObject.fromObject(map);
			System.err.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	/**
	 * 删除菜单
	 * @param request
	 * @author lou
	 * @return
	 */
	@RequestMapping(value="/menu/delete_menu",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject delete_dept(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			Integer id = Integer.valueOf(request.getParameter("menu_id"));
			menuService.delete(id);
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("msg", "删除成功");
			jsonObject = JSONObject.fromObject(map);
			System.err.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	@RequestMapping(value="/menu/save_menu",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject save_dept(HttpServletRequest request) {
		JSONObject jsonObject = null;
		try {
			Integer menu_level = Integer.valueOf(request.getParameter("menu_level"));
			Integer father_id = Integer.valueOf(request.getParameter("father_id"));
			String name = request.getParameter("name");
			Integer sort = Integer.valueOf(request.getParameter("sort"));
			String menu_url = request.getParameter("menu_url");
			Menu menu = new Menu();
			menu.setFather_id(father_id);
			menu.setMenu_name(name);
			menu.setSort(sort);
			menu.setMenu_level(menu_level);
			menu.setUrl(menu_url);
			menu.setIs_delete(1);
			menu.setCreated_by(1);
			menu.setUpdated_by(1);
			menuService.save(menu);
			System.err.println(menu.getId() + "###########");
			Menu menu2 = menuService.getById(menu.getId());
			JSONObject jsonobj = new JSONObject(); 
			jsonobj.put("id",menu2.getId());
			jsonobj.put("pId", menu2.getFather_id());
			jsonobj.put("name", menu2.getMenu_name());
			jsonobj.put("sort", menu2.getSort());
			jsonobj.put("menu_level", menu2.getMenu_level());
			jsonobj.put("menu_url", menu2.getUrl());
			if (menu2.getMenu_level() == 1) {
				jsonobj.put("open", true);
				jsonobj.put("iconSkin", "pIcon01");
			}else if (menu2.getMenu_level() == 2) {
				jsonobj.put("iconSkin", "icon03");
			}else {
				jsonobj.put("iconSkin", "icon03");
			}
			
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("treeNode", jsonobj);
			jsonObject = JSONObject.fromObject(map);
			System.err.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	/**
	 * 角色添加管理的菜单
	 * @param request
	 * @return lou
	 */
	@RequestMapping(value="/menu/save_role_menus",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject save_role_menus(HttpServletRequest request,@RequestParam(value="menus",required=false) String menus,
			@RequestParam(value="role",required=false) String role) {
		JSONObject jsonObject = null;
		System.err.println(menus +"--------" + role);
		try {
			Integer role_id = Integer.valueOf(role);
			String [] menu = menus.trim().split(",");
			roleMenuService.deleteByRoleId(role_id);
			List<String> menuList = new ArrayList<>();
			for (int i = 0; i < menu.length; i++) {
					menuList.add(menu[i]);
			}
			System.err.println(menuList.size() + "---@@@@");
			if (menuList.size() > 0) {
				roleMenuService.insertBatchMenus(role_id, menuList);
			}
			
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("msg", "成功");
			jsonObject = JSONObject.fromObject(map);
			System.err.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	/**
	 * 查询该角色下的已有的菜单
	 * @param request
	 * @return lou
	 */
	@RequestMapping(value="/menu/query_role_menus",method = RequestMethod.POST)
	@ResponseBody
	public  JSONObject query_role_menus(HttpServletRequest request,@RequestParam(value="role",required=false) String role) {
		JSONObject jsonObject = null;
		System.err.println("role--------" + role);
		try {
			Integer role_id = Integer.valueOf(role);
			List<Integer> roleMenuList = roleMenuService.findByRoleId(role_id);
			System.err.println("roleMenuList==========" + roleMenuList.size());
			
			Map<String,Object> map = new HashMap<String,Object>();  
			map.put("msg", roleMenuList);
			jsonObject = JSONObject.fromObject(map);
			System.err.println(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
}
