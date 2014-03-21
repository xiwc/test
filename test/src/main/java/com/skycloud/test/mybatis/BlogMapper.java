package com.skycloud.test.mybatis;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface BlogMapper {
	// @Select("SELECT * FROM blog WHERE id = #{id}")
	Blog selectBlog(int id);
	
	@Select("SELECT * FROM blog WHERE id = #{id}")
	Map<String, Object> selectMapedBlog(int id);
}