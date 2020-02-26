package com.swmfizl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@CrossOrigin(value = "http://localhost", maxAge = 3600, allowCredentials = "true")
public class CookieController {
	@RequestMapping(value = "setCookie", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public Map<String, Object> setCookie(HttpServletResponse response) {
		Map<String, Object> res = new HashMap<String, Object>();
		Cookie cookie = new Cookie("token", "cdb85c2f-2695-4982-a3e8-95754f8b50e0");
		cookie.setPath("/");
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
		res.put("cookie", cookie );
		res.put("code", 0);
		res.put("msg", "添加cookie成功");
		return res;
	}

	@RequestMapping(value = "getCookie", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public Map<String, Object> getCookie(HttpServletRequest request) {
		Map<String, Object> res = new HashMap<String, Object>();
		Cookie[] cookies = request.getCookies();
		res.put("cookies", cookies);
		res.put("code", 0);
		res.put("msg", "获取cookies成功");
		return res;
	}
}
