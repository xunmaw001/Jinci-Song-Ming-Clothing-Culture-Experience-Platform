package com.dao;

import com.entity.DiscussjingquxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjingquxinxiVO;
import com.entity.view.DiscussjingquxinxiView;


/**
 * 景区信息评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-02 22:55:22
 */
public interface DiscussjingquxinxiDao extends BaseMapper<DiscussjingquxinxiEntity> {
	
	List<DiscussjingquxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussjingquxinxiEntity> wrapper);
	
	DiscussjingquxinxiVO selectVO(@Param("ew") Wrapper<DiscussjingquxinxiEntity> wrapper);
	
	List<DiscussjingquxinxiView> selectListView(@Param("ew") Wrapper<DiscussjingquxinxiEntity> wrapper);

	List<DiscussjingquxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjingquxinxiEntity> wrapper);
	
	DiscussjingquxinxiView selectView(@Param("ew") Wrapper<DiscussjingquxinxiEntity> wrapper);
	

}
