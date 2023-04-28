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
	
	@RequestMapping("insert.memo")
	public void insert(MemoVO vo) {
		dao.insert(vo);
	}
	
	@RequestMapping("one.memo")
	public void one(String _id, Model model) {
		MemoVO vo = dao.one(_id);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping("update.memo")
	public String update(String _id, String content) {
		MemoVO vo = new MemoVO();
		vo.set_id(_id);
		vo.setContent(content);
		dao.update(vo);
		return "redirect:/mongo_memo.jsp";
	}
	
	@RequestMapping("delete.memo")
	public String delete(String _id) {
		dao.delete(_id);
		return "redirect:/mongo_memo.jsp";
	}
	
}
