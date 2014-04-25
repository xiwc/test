/**
 * BaseController.java
 */
package com.skycloud.test.base;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 请求控制层基类.
 * 
 * @creation 2013年12月24日 上午11:09:22
 * @modification 2013年12月24日 上午11:09:22
 * @company Skycloud
 * @author xiweicheng
 * @version 1.0
 * 
 */
public class BaseController {

	private static Logger logger = Logger.getLogger(BaseController.class);

	protected BaseController() {
	}

	/**
	 * 创建新的数据行版本号.
	 * 
	 * @return
	 */
	protected static Long version() {
		return new Date().getTime();
	}

	@ModelAttribute
	public void responseHandle(HttpServletResponse response) {

		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");

			// Set standard HTTP/1.1 no-cache headers.
			response.setHeader("Cache-Control", "no-store, max-age=0, no-cache, must-revalidate");
			// Set IE extended HTTP/1.1 no-cache headers.
			response.addHeader("Cache-Control", "post-check=0, pre-check=0");
			// Set standard HTTP/1.0 no-cache header.
			response.setHeader("Pragma", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}

	@ModelAttribute
	public void requestHandle(HttpServletRequest request) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ResultMsg handleThrowable(Throwable throwable, Locale locale) {

		logger.error(throwable.getMessage(), throwable);

		return new ResultMsg(false, new Msg(false, throwable.getMessage()));
	}
}
