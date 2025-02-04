package com.entity.vo;

import com.entity.JingquxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 景区信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-02 22:55:21
 */
public class JingquxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 景点标题
	 */
	
	private String jingdianbiaoti;
		
	/**
	 * 景点照片
	 */
	
	private String jingdianzhaopian;
		
	/**
	 * 景点位置
	 */
	
	private String jingdianweizhi;
		
	/**
	 * 景点简介
	 */
	
	private String jingdianjianjie;
		
	/**
	 * 景点详情
	 */
	
	private String jingdianxiangqing;
				
	
	/**
	 * 设置：景点标题
	 */
	 
	public void setJingdianbiaoti(String jingdianbiaoti) {
		this.jingdianbiaoti = jingdianbiaoti;
	}
	
	/**
	 * 获取：景点标题
	 */
	public String getJingdianbiaoti() {
		return jingdianbiaoti;
	}
				
	
	/**
	 * 设置：景点照片
	 */
	 
	public void setJingdianzhaopian(String jingdianzhaopian) {
		this.jingdianzhaopian = jingdianzhaopian;
	}
	
	/**
	 * 获取：景点照片
	 */
	public String getJingdianzhaopian() {
		return jingdianzhaopian;
	}
				
	
	/**
	 * 设置：景点位置
	 */
	 
	public void setJingdianweizhi(String jingdianweizhi) {
		this.jingdianweizhi = jingdianweizhi;
	}
	
	/**
	 * 获取：景点位置
	 */
	public String getJingdianweizhi() {
		return jingdianweizhi;
	}
				
	
	/**
	 * 设置：景点简介
	 */
	 
	public void setJingdianjianjie(String jingdianjianjie) {
		this.jingdianjianjie = jingdianjianjie;
	}
	
	/**
	 * 获取：景点简介
	 */
	public String getJingdianjianjie() {
		return jingdianjianjie;
	}
				
	
	/**
	 * 设置：景点详情
	 */
	 
	public void setJingdianxiangqing(String jingdianxiangqing) {
		this.jingdianxiangqing = jingdianxiangqing;
	}
	
	/**
	 * 获取：景点详情
	 */
	public String getJingdianxiangqing() {
		return jingdianxiangqing;
	}
			
}
