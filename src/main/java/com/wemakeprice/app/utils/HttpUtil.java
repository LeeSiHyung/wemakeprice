package com.wemakeprice.app.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	
	public static String getContext(String url) {
		try {
			StringBuffer sb = new StringBuffer();
			HttpURLConnection myURLConnection = (HttpURLConnection) new URL(url).openConnection();
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()))) {
				reader.lines().forEach(s -> sb.append(s));
			}
			return sb.toString();
		}
		catch(IOException ex) {
			return "";
		}
	}
	
}
