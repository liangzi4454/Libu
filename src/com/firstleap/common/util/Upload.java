package com.firstleap.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author 张世超
 * 上传 下载附件
 *
 */
public class Upload {
	

	/**
	 * 单一文件上传
	 * @param fromFile 文件来源 
	 * @param savePath 文件保存目录
	 */
	public static void uploadFile(File fromFile,String savePath) {
			//File fromFile = new File(fromFileStr);
			String fromPath = fromFile.getPath();
			
		   //String fromPath="G:"+File.separator+"1.jpg";//文件来源  
		   String fileName=fromPath.substring(fromPath.lastIndexOf(File.separator)+1);//通过路径取得文件名
		   //String savePath="G:"+File.separator+"test";//文件保存目录		  
		   try{
		    File file=new File(savePath);
		    if(!file.exists()){
		     file.mkdirs();
		    }
		    //文件输入流
		    FileInputStream fis=new FileInputStream(fromPath);
		    BufferedInputStream bis=new BufferedInputStream(fis);
		    byte [] content=new byte[255];
		   
		    //文件输出流
		    File j=new File(savePath+File.separator+fileName); 
		    FileOutputStream fos=new FileOutputStream(j);
		    BufferedOutputStream bos=new BufferedOutputStream(fos);
		    while(bis.read(content)!=-1){//写入文件
		     bos.write(content);
		     bos.flush();
		    }
		    bis.close();
		    bos.close();
		   }catch(Exception e){
		    e.printStackTrace();
		   }
		}
	
	/**
	 * 删除文件
	 * @param uploadPath 文件的路径
	 * @param fileName  文件名
	 */
	public static void deleteFile(String uploadPath,String fileName){
		File file = new File(uploadPath+fileName);
		if(file.exists()){
		     file.delete();
		}else{
//			System.out.println(uploadPath+fileName+"文件不存在");
		}
	}


	/**
	 * 下载文件
	 * @param urlStr	是需要下载的链接
	 * @param filePath 是需要存放文件的地方
	 */
/*	public void downloadFile(String urlStr,String filePath) {
	    try {
	     URL url = null;
	     try {
	       url = new URL(urlStr);
	     } catch(Exception e) {
	       System.out.println("this url is error");
	     }
	     FileInputStream in=(FileInputStream) url.openStream();
	     File fileOut=new File(filePath);
	     FileOutputStream out=new FileOutputStream(fileOut);
	     byte[] bytes=new byte[1024];
	     int c;
	     while((c=in.read(bytes))!=-1) {
	      out.write(bytes,0,c);
	     }
	     in.close();
	     out.close();
	    } catch(Exception e) { 
	     System.out.println("Error!");
	    }
	}  */

	// webwork上传文件
	public static int uploadAttach(File file,String fileFileName,String savePath) {//上传文件，上传文件名,文件保存路径
		if (file != null) {
			FileOutputStream outputStream;
			try {
				// ResourceBundle rb = ResourceBundle.getBundle("config");
				//String fileDir = "C:\\uploadfiles\\";
				// rb.getString("saveDir")+user.getId()+File.separator;
				String fileDir = savePath;
				String filePath = fileDir +"//"+ fileFileName;
				try {
					// 创建目录
					File f = new File(fileDir);
					f.mkdirs();
				} catch (Exception e) {
					//e.printStackTrace();
					return 0;
				}
				outputStream = new FileOutputStream(filePath);
				FileInputStream fileIn = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = fileIn.read(buffer)) > 0) {
					outputStream.write(buffer, 0, len);
				}
				fileIn.close();
				outputStream.close();
				return 1;
			} catch (FileNotFoundException e) {
				return 0;
				//e.printStackTrace();
			} catch (IOException e) {
				//e.printStackTrace();
				return 0;
			}
			//System.out.println("uploadfile name=" + fileFileName);
		} else {
			return 0;
			//System.out.println("file is null!");
		}
	}
	/*取得文件的扩展名*/
	public static String getExtension(String fileName) {

	       int newEnd = fileName.length();
	       int i = fileName.lastIndexOf('.', newEnd);
	       if (i != -1) {
	           return fileName.substring(i + 1, newEnd);
	       } else {
	           return null;
	       }
	    }
	/*拷贝文件*/
	public static void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
//			String fileName = oldfile.getName();
//			String temp = fileName.substring(fileName.lastIndexOf("."));//得到文件扩展名
//			String fileNametemp = 
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					//System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错 ");
			e.printStackTrace();

		}

	}
}