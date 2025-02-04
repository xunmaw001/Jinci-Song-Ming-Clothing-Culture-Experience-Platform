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

import com.entity.JingquxinxiEntity;
import com.entity.view.JingquxinxiView;

import com.service.JingquxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 景区信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-02 22:55:21
 */
@RestController
@RequestMapping("/jingquxinxi")
public class JingquxinxiController {
    @Autowired
    private JingquxinxiService jingquxinxiService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingquxinxiEntity jingquxinxi, 
		HttpServletRequest request){

        EntityWrapper<JingquxinxiEntity> ew = new EntityWrapper<JingquxinxiEntity>();


		PageUtils page = jingquxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingquxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingquxinxiEntity jingquxinxi, 
		HttpServletRequest request){
        EntityWrapper<JingquxinxiEntity> ew = new EntityWrapper<JingquxinxiEntity>();

		PageUtils page = jingquxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingquxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingquxinxiEntity jingquxinxi){
       	EntityWrapper<JingquxinxiEntity> ew = new EntityWrapper<JingquxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingquxinxi, "jingquxinxi")); 
        return R.ok().put("data", jingquxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingquxinxiEntity jingquxinxi){
        EntityWrapper< JingquxinxiEntity> ew = new EntityWrapper< JingquxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingquxinxi, "jingquxinxi")); 
		JingquxinxiView jingquxinxiView =  jingquxinxiService.selectView(ew);
		return R.ok("查询景区信息成功").put("data", jingquxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingquxinxiEntity jingquxinxi = jingquxinxiService.selectById(id);
        return R.ok().put("data", jingquxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingquxinxiEntity jingquxinxi = jingquxinxiService.selectById(id);
        return R.ok().put("data", jingquxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingquxinxiEntity jingquxinxi, HttpServletRequest request){
    	jingquxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingquxinxi);

        jingquxinxiService.insert(jingquxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingquxinxiEntity jingquxinxi, HttpServletRequest request){
    	jingquxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingquxinxi);

        jingquxinxiService.insert(jingquxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingquxinxiEntity jingquxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingquxinxi);
        jingquxinxiService.updateById(jingquxinxi);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingquxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
