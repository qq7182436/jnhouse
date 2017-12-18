package com.jnhouse.app.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jnhouse.app.bean.FkeFile;
import com.jnhouse.app.bean.SupAnswerLine;
import com.jnhouse.app.utils.DateTimeUtils;

import com.jnhouse.app.utils.SftpUtils;
import com.jnhouse.app.utils.StringUtils;


@Controller
public class FileController extends BaseController{

	@Resource
	ObjectMapper objectMapper;
	

	private Logger Log = Logger.getLogger(FileController.class);
	/**
	 * App 上传照片接口
	 * @param file 照片
	 * @param header_id 稽查订单的id
	 * @param line_id   考核明细的id
	 * @param secProblemId   二级问题的id
	 * @param created_by  创建人
	 * @return ObjectNode
	 */
	@ResponseBody
	@RequestMapping(value = "/jc_house/photoUpload", method = RequestMethod.POST)
	public ObjectNode photoUpload(MultipartFile file, HttpServletRequest request) {
		
		
		ObjectNode re = objectMapper.createObjectNode();

		String  line_id = (String)request.getParameter("line_id");
		String  created_by = (String)request.getParameter("created_by");//创建人

		
		try {
			System.out.println(file+"!!!!!!!!!!!!!!!!!!!!!");
			
			if (file != null) {// 判断上传的文件是否为空
				String path = null;// 文件路径
				String type = null;// 文件类型
				String fileName = file.getOriginalFilename();// 文件原名称
				System.out.println("上传的文件原名称:" + fileName);
				// 判断文件类型
				type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
						: null;
				/*System.out.println("文件类型"+type);
				System.out.println("文件类型"+type.toUpperCase());*/
				if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase())
						|| "JPG".equals(type.toUpperCase())) {
					// 项目在容器中实际发布运行的根路径
					// // 自定义的文件名称
					//				path = "/usr/java/img/";
					path = "E:/123/";
							//+ DateTimeUtils.getNowTimeStr("yyyy-MM-dd") + fileName;
					String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
					// 设置存放图片文件的路径
					/*path = realPath
							+  System.getProperty("file.separator")+ trueFileName;*/

					System.out.println("存放图片文件的路径:" + path);

					
					/*SftpUtils sftpUtils = new SftpUtils("192.168.7.136", 22, "root", "root");
					sftpUtils.connect();

					CommonsMultipartFile cf = (CommonsMultipartFile) file;
					DiskFileItem fi = (DiskFileItem) cf.getFileItem();
					fi.getStoreLocation();*/
					File newfile = DateTimeUtils.getYearAndMonthAndToday(path);
					
					System.out.println("新========"+newfile.getAbsolutePath()+System.getProperty("file.separator")+ trueFileName);
					try {
						//文件上传
						file.transferTo(new File(newfile.getAbsolutePath()+System.getProperty("file.separator")+ trueFileName));
						
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					SupAnswerLine supAnswerLine = new SupAnswerLine();
					if(StringUtils.isSpace(line_id)){
						line_id = "0";
					}
					
					supAnswerLine.setId(Integer.parseInt(line_id));
					
					
					FkeFile fkeFile = new FkeFile();
					//生成的文件的名称
					fkeFile.setFile_name(trueFileName);
					
					//文件的路径
					fkeFile.setFile_url(newfile.getAbsolutePath()+System.getProperty("file.separator"));
					
					//文件的类型
					fkeFile.setFile_type(1);
					
					//创建人
					fkeFile.setCreated_by(created_by);
					
					
					fkeFile.setUpdated_by(created_by);
					
					int c = fileService.saveFile(supAnswerLine, fkeFile);
					if(c == 1){
						re.put("code", "0");
						re.put("message", "完成");
					}

				} else {
					re.put("code", "206");
					re.put("message", "不是我们想要的文件类型,请按要求重新上传");
				}
			} else {
				//不上传照片   只保存考核明细信息
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			re.put("code", "-1");
			re.put("message", "异常");
			Log.info("上传图片出异常");
		}
		return re;

	}


	/**
	 * 后台测试
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "photoUpload", method = RequestMethod.POST)
	public ObjectNode uploadPhotoUpload(MultipartFile file,HttpServletRequest request,HttpServletResponse response) {
		
		ObjectNode re = objectMapper.createObjectNode();

		String  header_id = (String)request.getParameter("header_id");
		String  line_id = (String)request.getParameter("line_id");
		String secProblemId = (String)request.getParameter("secProblemId");
		String  created_by = (String)request.getParameter("created_by");//创建人


		try {
			System.out.println(file+"!!!!!!!!!!!!!!!!!!!!!");
			SupAnswerLine supAnswerLine = new SupAnswerLine();
			Timestamp scurrtest = new Timestamp(System.currentTimeMillis());
			if(StringUtils.isSpace(line_id)){
				line_id = "0";
			}
			if(StringUtils.isSpace(header_id)){
				header_id = "0";
			}
			if(StringUtils.isSpace(secProblemId)){
				secProblemId="0";
			}
			
			supAnswerLine.setId(Integer.parseInt(line_id));
			supAnswerLine.setHeader_id(Integer.parseInt(header_id));
			supAnswerLine.setProblem_id(Integer.parseInt(secProblemId));
			if (file != null) {// 判断上传的文件是否为空
				String path = null;// 文件路径
				String type = null;// 文件类型
				String fileName = file.getOriginalFilename();// 文件原名称
				System.out.println("上传的文件原名称:" + fileName);
				// 判断文件类型
				type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
						: null;
				/*System.out.println("文件类型"+type);
				System.out.println("文件类型"+type.toUpperCase());*/
				if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase())
						|| "JPG".equals(type.toUpperCase())) {
					// 项目在容器中实际发布运行的根路径
					// // 自定义的文件名称
//				path = "/usr/java/img/";
					path = "E:/123/";
							//+ DateTimeUtils.getNowTimeStr("yyyy-MM-dd") + fileName;
					String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
					// 设置存放图片文件的路径
					/*path = realPath
							+  System.getProperty("file.separator")+ trueFileName;*/

					System.out.println("存放图片文件的路径:" + path);

					
					SftpUtils sftpUtils = new SftpUtils("192.168.7.136", 22, "root", "root");
					sftpUtils.connect();

					CommonsMultipartFile cf = (CommonsMultipartFile) file;
					DiskFileItem fi = (DiskFileItem) cf.getFileItem();
					fi.getStoreLocation();
					File newfile = DateTimeUtils.getYearAndMonthAndToday(path);
					
					System.out.println("新========"+newfile.getAbsolutePath()+System.getProperty("file.separator")+ trueFileName);
					try {
						//文件上传
						file.transferTo(new File(newfile.getAbsolutePath()+System.getProperty("file.separator")+ trueFileName));
						
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
					FkeFile fkeFile = new FkeFile();
					//生成的文件的名称
					fkeFile.setFile_name(trueFileName);
					
					//文件的路径
					fkeFile.setFile_url(newfile.getAbsolutePath()+System.getProperty("file.separator"));
					
					//文件的类型
					fkeFile.setFile_type(1);
					
					//创建人
					fkeFile.setCreated_by(created_by);
					
					
					fkeFile.setUpdated_by(created_by);
					
					int c = fileService.saveFile(supAnswerLine, fkeFile);
					if(c == 1){
						re.put("code", "0");
						re.put("message", "完成");
					}

				} else {
					re.put("code", "206");
					re.put("message", "不是我们想要的文件类型,请按要求重新上传");
				}
			} else {
				//不上传照片   只保存考核明细信息

				System.out.println("已经进入这里面");
				supAnswerLine.setAnswer_num(0);
				supAnswerLine.setAnswer("0");
				supAnswerLine.setIs_delete(1);
				supAnswerLine.setScore(0.0f);
				supAnswerLine.setCreated_time(scurrtest);
				supAnswerLine.setUpdated_time(scurrtest);
				supAnswerLineService.update(supAnswerLine);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			re.put("code", "-1");
			re.put("message", "异常");
			e.printStackTrace();
		}
		return re;
	}
}
