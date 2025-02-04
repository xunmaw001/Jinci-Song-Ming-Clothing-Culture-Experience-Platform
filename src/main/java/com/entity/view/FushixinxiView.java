package com.entity.view;

import com.entity.FushixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 服饰信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-02 22:55:21
 */
@TableName("fushixinxi")
public class FushixinxiView  extends FushixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FushixinxiView(){
	}
 
 	public FushixinxiView(FushixinxiEntity fushixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, fushixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
