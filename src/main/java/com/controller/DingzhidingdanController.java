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

import com.entity.DingzhidingdanEntity;
import com.entity.view.DingzhidingdanView;

import com.service.DingzhidingdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 定制订单
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-02 22:55:21
 */
@RestController
@RequestMapping("/dingzhidingdan")
public class DingzhidingdanController {
    @Autowired
    private DingzhidingdanService dingzhidingdanService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingzhidingdanEntity dingzhidingdan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dingzhidingdan.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DingzhidingdanEntity> ew = new EntityWrapper<DingzhidingdanEntity>();


		PageUtils page = dingzhidingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingzhidingdan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingzhidingdanEntity dingzhidingdan, 
		HttpServletRequest request){
        EntityWrapper<DingzhidingdanEntity> ew = new EntityWrapper<DingzhidingdanEntity>();

		PageUtils page = dingzhidingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingzhidingdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingzhidingdanEntity dingzhidingdan){
       	EntityWrapper<DingzhidingdanEntity> ew = new EntityWrapper<DingzhidingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingzhidingdan, "dingzhidingdan")); 
        return R.ok().put("data", dingzhidingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingzhidingdanEntity dingzhidingdan){
        EntityWrapper< DingzhidingdanEntity> ew = new EntityWrapper< DingzhidingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingzhidingdan, "dingzhidingdan")); 
		DingzhidingdanView dingzhidingdanView =  dingzhidingdanService.selectView(ew);
		return R.ok("查询定制订单成功").put("data", dingzhidingdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingzhidingdanEntity dingzhidingdan = dingzhidingdanService.selectById(id);
        return R.ok().put("data", dingzhidingdan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingzhidingdanEntity dingzhidingdan = dingzhidingdanService.selectById(id);
        return R.ok().put("data", dingzhidingdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingzhidingdanEntity dingzhidingdan, HttpServletRequest request){
    	dingzhidingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingzhidingdan);

        dingzhidingdanService.insert(dingzhidingdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingzhidingdanEntity dingzhidingdan, HttpServletRequest request){
    	dingzhidingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dingzhidingdan);

        dingzhidingdanService.insert(dingzhidingdan);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingzhidingdanEntity dingzhidingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingzhidingdan);
        dingzhidingdanService.updateById(dingzhidingdan);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<DingzhidingdanEntity> list = new ArrayList<DingzhidingdanEntity>();
        for(Long id : ids) {
            DingzhidingdanEntity dingzhidingdan = dingzhidingdanService.selectById(id);
            dingzhidingdan.setSfsh(sfsh);
            dingzhidingdan.setShhf(shhf);
            list.add(dingzhidingdan);
        }
        dingzhidingdanService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingzhidingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
