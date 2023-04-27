package com.multu.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemoController {
	
	@Autowired
	MemoDAO dao;
	
	@RequestMapping("list.memo")
	public void list(Model model) {
		List<MemoVO> list = dao.list();
		System.out.println(list.size());
		model.addAttribute("list", list);
	}
}
