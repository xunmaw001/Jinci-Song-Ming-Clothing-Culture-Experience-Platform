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

import com.entity.TaocanleibieEntity;
import com.entity.view.TaocanleibieView;

import com.service.TaocanleibieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 套餐类别
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-02 22:55:21
 */
@RestController
@RequestMapping("/taocanleibie")
public class TaocanleibieController {
    @Autowired
    private TaocanleibieService taocanleibieService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TaocanleibieEntity taocanleibie, 
		HttpServletRequest request){

        EntityWrapper<TaocanleibieEntity> ew = new EntityWrapper<TaocanleibieEntity>();


		PageUtils page = taocanleibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, taocanleibie), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TaocanleibieEntity taocanleibie, 
		HttpServletRequest request){
        EntityWrapper<TaocanleibieEntity> ew = new EntityWrapper<TaocanleibieEntity>();

		PageUtils page = taocanleibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, taocanleibie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TaocanleibieEntity taocanleibie){
       	EntityWrapper<TaocanleibieEntity> ew = new EntityWrapper<TaocanleibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( taocanleibie, "taocanleibie")); 
        return R.ok().put("data", taocanleibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TaocanleibieEntity taocanleibie){
        EntityWrapper< TaocanleibieEntity> ew = new EntityWrapper< TaocanleibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( taocanleibie, "taocanleibie")); 
		TaocanleibieView taocanleibieView =  taocanleibieService.selectView(ew);
		return R.ok("查询套餐类别成功").put("data", taocanleibieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TaocanleibieEntity taocanleibie = taocanleibieService.selectById(id);
        return R.ok().put("data", taocanleibie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TaocanleibieEntity taocanleibie = taocanleibieService.selectById(id);
        return R.ok().put("data", taocanleibie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TaocanleibieEntity taocanleibie, HttpServletRequest request){
    	taocanleibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(taocanleibie);

        taocanleibieService.insert(taocanleibie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TaocanleibieEntity taocanleibie, HttpServletRequest request){
    	taocanleibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(taocanleibie);

        taocanleibieService.insert(taocanleibie);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TaocanleibieEntity taocanleibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(taocanleibie);
        taocanleibieService.updateById(taocanleibie);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        taocanleibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
