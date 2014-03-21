package com.skycloud.test.mybatis;

import java.io.IOException;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MybatisTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test01() throws IOException {

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources
				.getResourceAsStream("mybatis-config.xml"));

		SqlSession session = sqlSessionFactory.openSession();
		try {
			Blog blog = (Blog) session.selectOne("com.skycloud.test.mybatis.BlogMapper.selectBlog", 1);
			System.out.println(blog);
		} finally {
			session.close();
		}
	}

	@Test
	public void test02() throws IOException {

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources
				.getResourceAsStream("mybatis-config.xml"));

		SqlSession session = sqlSessionFactory.openSession();
		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			Blog blog = mapper.selectBlog(1);

			System.out.println(blog);
		} finally {
			session.close();
		}
	}

	@Test
	public void test03() throws IOException {

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources
				.getResourceAsStream("mybatis-config.xml"));

		SqlSession session = sqlSessionFactory.openSession();
		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			Map<String, Object> blog = mapper.selectMapedBlog(1);

			System.out.println(blog);
		} finally {
			session.close();
		}
	}

}
