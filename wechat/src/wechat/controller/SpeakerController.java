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

import wechat.po.Text;
import wechat.po.User;
import wechat.service.SpeakerService;

@Controller("speakerController")
@RequestMapping("/speaker")
public class SpeakerController {
	@Autowired
	private SpeakerService speakerService;
	@RequestMapping("/showtexture")
	public String showcart(HttpSession session,Model model) {
		User user=(User)session.getAttribute("user");
		List<Text> texts=speakerService.showtexture(user.getId());
		for(Text s:texts) {
			System.out.println(""+s.getUser_id()+s.getTexttime()+s.getText());
		}

		
		model.addAttribute("msg",texts);

		return "speaker";
	}
	@RequestMapping("/tospeaker")
	public String speaker() {
		return "speaker";
	}
	@RequestMapping("/sendtext")
	public String sendtexture(HttpSession session,String texture) {
		//System.out.println(texture);
		
		User user=(User)session.getAttribute("user");
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=df.format(new Date());
		Timestamp timeStamp=Timestamp.valueOf(time);

		Text text=new Text(user.getId(),1,timeStamp,texture);

		speakerService.sendtext(text);
		
		Date now=new Date();
		now.setTime(now.getTime()+1000);
		String time2=df.format(now);
		Timestamp timeStamp2=Timestamp.valueOf(time2);
		
		Text text2=new Text(1,user.getId(),timeStamp2,answer(texture));
		speakerService.sendtext(text2);
		return "forward:/speaker/showtexture";
	}
	public String answer(String texture) {
		
		String answer="answer";
		return answer;
	}
}
