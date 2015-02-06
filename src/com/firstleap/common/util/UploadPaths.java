package com.firstleap.common.util;

/**
 * @author 张世超
 * 文档上传路径
 */
public class UploadPaths {
	
	/**
	 * @return
	 * 文档共享上传路径
	 */
	public static String getSharePath(){
		return "/upload/share";
	}
	

	/**
	 * @return
	 * 工作总结上传路径
	 */
	public static String getSummaryPath(){
		return "/upload/summary";
	}
	

	/**
	 * @return
	 * 会议管理上传路径
	 */
	public static String getMeetingPath(){
		return "/upload/meeting";
	}
	
	/**
	 * @return
	 * 中期检查上传路径
	 */
	public static String getMidProPath(){
		return "/upload/midPro";
	}
}
