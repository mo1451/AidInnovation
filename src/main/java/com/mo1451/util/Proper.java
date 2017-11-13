/**
 * 
 */
package com.mo1451.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 默1451
 *
 */
public class Proper {
	public static String getRealPath() {
		String path = "";
		Properties prop = new Properties();
			try {
				InputStream in = Proper.class.getClassLoader().getResourceAsStream("gobal.properties");
				prop.load(in);
				path = prop.getProperty("RealPath");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return path;
	}
	
	public static int getPageSize() {
		int pageSize = 10;
		Properties prop = new Properties();
			try {
				InputStream in = Proper.class.getClassLoader().getResourceAsStream("gobal.properties");
				prop.load(in);
				pageSize = Integer.parseInt(prop.getProperty("PageSize"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		return pageSize;
	}
}
