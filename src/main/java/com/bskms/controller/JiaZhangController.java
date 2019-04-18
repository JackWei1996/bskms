package com.bskms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bskms.bean.Notice;

@Controller
@RequestMapping(value = "/jz")
@ResponseBody
public class JiaZhangController {
	@RequestMapping(value = "/notices")
	public Object notices() {
		
		List<Notice> notices = new ArrayList<>();
		Notice n = new Notice();
		n.setContent("内容1");
		n.setCreatTime(new Date());
		n.setTitle("标题1");
		notices.add(n);
		Notice n1 = new Notice();
		n1.setContent("内容2");
		n1.setCreatTime(new Date());
		n1.setTitle("标题2");
		notices.add(n1);
		Notice n2 = new Notice();
		n2.setContent("内容3");
		n2.setCreatTime(new Date());
		n2.setTitle("标题3");
		notices.add(n2);
		System.out.println(JSON.toJSONString(notices));
		return JSON.toJSONString(notices);
	}
	
	@RequestMapping(value = "/xy")
	public Object xy() {
		
		List<Notice> notices = new ArrayList<>();
		Notice n = new Notice();
		n.setContent("内容1");
		n.setCreatTime(new Date());
		n.setTitle("标题1");
		notices.add(n);
		Notice n1 = new Notice();
		n1.setContent("内容2");
		n1.setCreatTime(new Date());
		n1.setTitle("标题2");
		notices.add(n1);
		Notice n2 = new Notice();
		n2.setContent("内容3");
		n2.setCreatTime(new Date());
		n2.setTitle("标题3");
		notices.add(n2);
		System.out.println(JSON.toJSONString(notices));
		return JSON.toJSONString(notices);
	}
}
