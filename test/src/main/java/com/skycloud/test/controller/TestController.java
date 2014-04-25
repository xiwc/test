/**
 * TestController.java
 */
package com.skycloud.test.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skycloud.test.base.BaseController;
import com.skycloud.test.base.ResultMsg;
import com.skycloud.test.util.StringUtil;

/**
 * 【测试】请求控制层.
 * 
 * @creation 2014年03月19日 02:07:25
 * @modification 2014年03月19日 02:07:25
 * @company Skycloud
 * @author xiweicheng
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "test")
public class TestController extends BaseController {

	private static Logger logger = Logger.getLogger(TestController.class);

	/**
	 * 添加【测试】.
	 * 
	 * @author xiweicheng
	 * @creation 2014年03月19日 02:07:25
	 * @modification 2014年03月19日 02:07:25
	 * @return
	 */
	// @RequestMapping("add")
	@ResponseBody
	public ResultMsg add(Locale locale) {

		logger.debug("添加【测试】");

		// TODO

		// 参数验证
		// Assert.notNull(test.get);

		return new ResultMsg();
	}

	/**
	 * 删除【测试】.
	 * 
	 * @author xiweicheng
	 * @creation 2014年03月19日 02:07:25
	 * @modification 2014年03月19日 02:07:25
	 * @return
	 */
	// @RequestMapping("delete")
	@ResponseBody
	public ResultMsg delete(Locale locale) {

		logger.debug("删除【测试】");

		// TODO

		// 参数验证
		// Assert.notNull(test.get);

		return new ResultMsg();
	}

	/**
	 * 获取【测试】.
	 * 
	 * @author xiweicheng
	 * @creation 2014年03月19日 02:07:25
	 * @modification 2014年03月19日 02:07:25
	 * @return
	 */
	// @RequestMapping("get")
	@ResponseBody
	public ResultMsg get(Locale locale) {

		logger.debug("获取【测试】");

		// TODO

		// 参数验证
		// Assert.notNull(test.get);

		return new ResultMsg();
	}

	/**
	 * 更新【测试】.
	 * 
	 * @author xiweicheng
	 * @creation 2014年03月19日 02:07:25
	 * @modification 2014年03月19日 02:07:25
	 * @return
	 */
	// @RequestMapping("update")
	@ResponseBody
	public ResultMsg update(Locale locale) {

		logger.debug("更新【测试】");

		// TODO

		// 参数验证
		// Assert.notNull(test.get);

		return new ResultMsg();
	}

	/**
	 * 列举【测试】.
	 * 
	 * @author xiweicheng
	 * @creation 2014年03月19日 02:07:25
	 * @modification 2014年03月19日 02:07:25
	 * @return
	 */
	// @RequestMapping("list")
	@ResponseBody
	public ResultMsg list(Locale locale) {

		logger.debug("列举【测试】");

		// TODO

		// Test test = getParam(reqBody, Test.class);

		// 参数验证
		// Assert.notNull(test.get);

		return new ResultMsg();
	}

	/**
	 * 查询【测试】(不分页).
	 * 
	 * @author xiweicheng
	 * @creation 2014年03月19日 02:07:25
	 * @modification 2014年03月19日 02:07:25
	 * @return
	 */
	// @RequestMapping("query")
	@ResponseBody
	public ResultMsg query(Locale locale) {

		logger.debug("查询【测试】");

		// TODO

		// 参数验证
		// Assert.notNull(test.get);

		return new ResultMsg();
	}

	/**
	 * 查询【测试】(分页).
	 * 
	 * @author xiweicheng
	 * @creation 2014年03月19日 02:07:25
	 * @modification 2014年03月19日 02:07:25
	 * @return
	 */
	// @RequestMapping("paging")
	@ResponseBody
	public ResultMsg paging(Locale locale) {

		logger.debug("查询【测试】");

		// TODO

		// 参数验证

		// Assert.notNull(test.get);

		return new ResultMsg();
	}

	@RequestMapping(value = "form", consumes = "application/x-www-form-urlencoded")
	@ResponseBody
	public ResultMsg form(Locale locale) {

		logger.debug("查询【测试】");

		// TODO

		// 参数验证

		return new ResultMsg();
	}

	@RequestMapping("test")
	public String test(HttpServletRequest request, Locale locale, Model model) {
		logger.debug(request.getScheme());
		logger.debug(request.getServerName());
		logger.debug(request.getServerPort());
		logger.debug(request.getServletPath());
		logger.debug(request.getContextPath());

		String serverBaseUrl = StringUtil.replace("{?1}://{?2}:{?3}/{?4}", request.getScheme(),
				request.getServerName(), request.getServerPort(), request.getContextPath());

		logger.debug(serverBaseUrl);

		return "";
	}

	@RequestMapping("test1")
	@ResponseBody
	public String test1(HttpServletRequest request, Locale locale, Model model) {
		logger.debug(request.getScheme());
		logger.debug(request.getServerName());
		logger.debug(request.getServerPort());
		logger.debug(request.getServletPath());
		logger.debug(request.getContextPath());

		String serverBaseUrl = StringUtil.replace("{?1}://{?2}:{?3}/{?4}", request.getScheme(),
				request.getServerName(), request.getServerPort(), request.getContextPath());

		logger.debug(serverBaseUrl);

		return serverBaseUrl;
	}

}
