package com.jnhouse.app.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.util.StringUtil;
import com.jnhouse.app.bean.SupTemplate;
import com.jnhouse.app.service.FileService;
import com.jnhouse.app.utils.ResultData;
import com.jnhouse.app.utils.SftpUtils;
import com.jnhouse.app.utils.StringUtils;

@Controller
public class FileController extends BaseController{

	@Resource
	ObjectMapper objectMapper;
	
	
	@Resource
	FileService fileService;
	
	
	@ResponseBody
	@RequestMapping(value = "/jc_house/photoUpload", method = RequestMethod.POST)
	public ResultData<Object> photoUpload(MultipartFile file,HttpServletRequest request,HttpServletResponse response) {
		ResultData<Object> resultData = new ResultData<>();

		System.out.println("==================");
		ObjectNode re = objectMapper.createObjectNode();
		

		
		
		//MultipartFile file = ((MultipartHttpServletRequest) request).getFile("jc_store_picture");接口专用
		
		if (file != null) {// 判断上传的文件是否为空
			String path = null;// 文件路径
			String type = null;// 文件类型
			String fileName = file.getOriginalFilename();// 文件原名称
			System.out.println("上传的文件原名称:" + fileName);
			// 判断文件类型
			type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
					: null;
			if (type != null) {// 判断文件类型是否为空
				if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase())
						|| "JPG".equals(type.toUpperCase())) {
					// 项目在容器中实际发布运行的根路径
					// String realPath =
					// request.getSession().getServletContext().getRealPath("/");
					// // 自定义的文件名称
					//String realPath = "/usr/java/img/";
					String realPath = "E:\\123";
					String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
					
					
					// 设置存放图片文件的路径
					path = realPath
							+  System.getProperty("file.separator")+ trueFileName;
			/*		
					String documentWay = "house/sell/"
							+ DateTimeUtils.getNowTimeStr("yyyy-MM-dd") + "/";*/
					
					System.out.println("存放图片文件的路径:" + path);

					//SftpUtils sftpUtils = new SftpUtils("192.168.7.136", 22, "root", "root");
					/*SftpUtils sftpUtils = new SftpUtils("", 0, "root", "root");
					sftpUtils.connect();*/

					CommonsMultipartFile cf = (CommonsMultipartFile) file;
					DiskFileItem fi = (DiskFileItem) cf.getFileItem();

					File f = fi.getStoreLocation();
					

					//sftpUtils.upload(path, f);
					// 转存文件到指定的路径
					try {
						file.transferTo(new File(path));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					re.put("code", "0");
					re.put("message", "完成");
					
					
					//开始保存信息
					SupTemplate supTemplate = new SupTemplate();
					

				
					System.out.println("文件成功上传到指定目录下");
				} else {
					System.out.println("不是我们想要的文件类型,请按要求重新上传");
					re.put("code", "206");
					re.put("message", "不是我们想要的文件类型,请按要求重新上传");
				}
			} else {
				re.put("code", "204");
				re.put("message", "文件类型为空");

			}
		} else {
			System.out.println("没有找到相对应的文件");
			
			re.put("code", "205");
			re.put("message", "没有找到相对应的文件");
		}
		return resultData;
	}
}
