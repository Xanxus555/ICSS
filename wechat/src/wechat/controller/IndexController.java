package wechat.controller;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import wechat.controller.BaseController;
import wechat.po.Text;
import wechat.po.User;
import wechat.service.IndexService;


@Controller("indexController")
@RequestMapping("/index")
public class IndexController{
	@Autowired
	private IndexService indexService;
	@RequestMapping("/login")
	public String login() {
		return "login"; //跳转到“/WEB-INF/jsp/login.jsp”
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/index.jsp";//跳转到主页
	}
	
	@RequestMapping("/regist")
	public String register() {
		return "regist";
	}


}
