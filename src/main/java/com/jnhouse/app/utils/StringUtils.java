package com.jnhouse.app.utils;

import java.io.File;

public class StringUtils {

	
	public static boolean isNull(String s) {
		if (s == null) {
			return true;
		}
		return false;
	}

	public static boolean isSpace(String s) {
		if ((isNull(s)) || ("".equals(s.trim()))) {
			return true;
		}

		return false;
	}
	
	public static String mergeStringWithSeparator(String...args){  
	    StringBuilder sb=new StringBuilder();  
	    for (String arg : args) {  
	        sb.append(arg);  
	        sb.append(File.separator);  
	    }  
	          
	    return sb.substring(0, sb.length()-1).toString();  
	}  
}
