package com.wemakeprice.app.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
	
	public static String number(String str) {
		if(str == null) return "";
		return str.replaceAll("[^0-9]+", " "); 
	}
	
	public static String english(String str) {
		if(str == null) return "";
		return str.replaceAll("[^a-zA-Z]+", " "); 
	}
	
	public static String removeTag(String str) {
		if(str == null) return "";
		return str.replaceAll("<[^>]*>", "");
	}
	
	public static String trimAll(String str) {
		if(str == null) return "";
		return str.replaceAll("\\s", "");
	}
	
	public static String sort(String str) {
		if(str == null) return "";
		String[] stringArray = Arrays.stream(str.split("")).map(String::trim).toArray(String[]::new);
		Arrays.sort(stringArray, String.CASE_INSENSITIVE_ORDER);
		return String.join("", stringArray);
	}
	
	
	public static String mix(String str1, String str2) {
		
		if(str1 == null) str1 = ""; 
		if(str2 == null) str2 = "";
		List<String> sa1 = Arrays.stream(str1.split("")).map(String::trim).collect(Collectors.toList());
		List<String> sa2 = Arrays.stream(str2.split("")).map(String::trim).collect(Collectors.toList());
		
		int max = Math.max(sa1.size(), sa2.size());
		StringBuffer sb = new StringBuffer();
		for(int i=0; i < max; i++) {
			if(i < sa1.size()) sb.append(sa1.get(i));
			if(i < sa2.size()) sb.append(sa2.get(i));
		}
		return sb.toString();
	}
	
	
}
