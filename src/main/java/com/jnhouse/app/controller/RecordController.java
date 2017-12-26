package com.jnhouse.app.controller;


import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jnhouse.app.utils.FileRecord;




@Controller
public class RecordController extends BaseController {

	
	@Resource
	ObjectMapper objectMapper;
	
	/**
	 * App 上传录音
	 * @param request
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "uploadRecord",method = RequestMethod.POST)
	public @ResponseBody ObjectNode upload(HttpServletRequest request,MultipartFile file) {


		ObjectNode re = objectMapper.createObjectNode();
		
		String header_id = (String)request.getParameter("header_id");
/*		CommonsMultipartFile cf = (CommonsMultipartFile) file;
		DiskFileItem fi = (DiskFileItem) cf.getFileItem();
		File f2 = fi.getStoreLocation();*/

		String strFileSrc = "E:/WAV1/";
		File fileSrc = new File(strFileSrc);
		
		
		FileRecord obj = new FileRecord();
		System.out.println("开始");
        
        obj.copyFolder(fileSrc);
         
        System.out.println("结束");
        
        re.put("code", "0");
        re.put("message", "完成");
        return re;
	
	}
  
}
