package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussfushixinxiEntity;
import com.entity.view.DiscussfushixinxiView;

import com.service.DiscussfushixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 服饰信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-02 22:55:22
 */
@RestController
@RequestMapping("/discussfushixinxi")
public class DiscussfushixinxiController {
    @Autowired
    private DiscussfushixinxiService discussfushixinxiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussfushixinxiEntity discussfushixinxi, 
		HttpServletRequest request){

        EntityWrapper<DiscussfushixinxiEntity> ew = new EntityWrapper<DiscussfushixinxiEntity>();


		PageUtils page = discussfushixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfushixinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussfushixinxiEntity discussfushixinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussfushixinxiEntity> ew = new EntityWrapper<DiscussfushixinxiEntity>();

		PageUtils page = discussfushixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfushixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussfushixinxiEntity discussfushixinxi){
       	EntityWrapper<DiscussfushixinxiEntity> ew = new EntityWrapper<DiscussfushixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussfushixinxi, "discussfushixinxi")); 
        return R.ok().put("data", discussfushixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussfushixinxiEntity discussfushixinxi){
        EntityWrapper< DiscussfushixinxiEntity> ew = new EntityWrapper< DiscussfushixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussfushixinxi, "discussfushixinxi")); 
		DiscussfushixinxiView discussfushixinxiView =  discussfushixinxiService.selectView(ew);
		return R.ok("查询服饰信息评论表成功").put("data", discussfushixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussfushixinxiEntity discussfushixinxi = discussfushixinxiService.selectById(id);
        return R.ok().put("data", discussfushixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussfushixinxiEntity discussfushixinxi = discussfushixinxiService.selectById(id);
        return R.ok().put("data", discussfushixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussfushixinxiEntity discussfushixinxi, HttpServletRequest request){
    	discussfushixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussfushixinxi);

        discussfushixinxiService.insert(discussfushixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussfushixinxiEntity discussfushixinxi, HttpServletRequest request){
    	discussfushixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussfushixinxi);

        discussfushixinxiService.insert(discussfushixinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussfushixinxiEntity discussfushixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussfushixinxi);
        discussfushixinxiService.updateById(discussfushixinxi);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussfushixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
