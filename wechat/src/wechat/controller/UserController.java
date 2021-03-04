package wechat.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wechat.controller.BaseController;
import wechat.po.User;
import wechat.service.UserService;
@Controller("userController")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String Login(User user,HttpSession session,Model model){	
		User muser=userService.login(user);
		if(muser!=null){
			session.setAttribute("user", muser);
			return "redirect:/index.jsp"; //�ض�����ҳ
		}else{
			model.addAttribute("message", "�û������������");
			return "login";
		}	
	}
	
	@RequestMapping("/regist")
	public String regist(User user,String valistr,HttpSession session,Model model){
	/*if(!valistr.equalsIgnoreCase(session.getAttribute("code").toString())) {
		model.addAttribute("msg","�û�������Ϊ�գ�");
		return "regist";
	}*/
	if(userService.regist(user)>0) {
		model.addAttribute("msg","ע��ɹ�");
		return "regist";
	}else {
		model.addAttribute("msg","ע��ʧ��");
		return "regist";
	}
	}

	@RequestMapping(value="/checkUser",method=RequestMethod.POST)
	public void check(HttpServletRequest request,HttpServletResponse response)
			throws IOException{
		response.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		if(userService.checkUsername(username))
			response.getWriter().print("�û���"+username+"�ѱ�ע��!");
		else
			response.getWriter().print("��ϲ��,"+username+"����ʹ��!");		
	}	
}
