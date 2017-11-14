/**
 * 
 */
package com.mo1451.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sun.misc.BASE64Encoder;

/**
 * @author 默1451
 *
 */
public class ImgStr {
	
	public static final int PRINCIPLE_IMG = 0;
	public static final int CAUL_IMG = 1;
	public static final int LIFE_IMG = 2;
	public static final int FUN_IMG = 3;
	public static final int OBJECT_IMG = 4;
	public static final int SUMMER_IMG = 5;
	
	public static String getImgStr(String path) {
		 InputStream in = null;
		 byte[] data = null;
		 try {
			 in = new FileInputStream(path);
			 data = new byte[in.available()];
			 in.read(data);
			 in.close();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 BASE64Encoder encoder = new BASE64Encoder();
		 return encoder.encode(data);
	}
}
