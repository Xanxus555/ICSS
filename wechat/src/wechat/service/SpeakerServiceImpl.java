package wechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wechat.dao.TextDao;
import wechat.po.Text;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService{
	@Autowired
	private TextDao textDao;
	@Override
	public void sendtext(Text text) {
		textDao.sendtext(text);
	}
	@Override
	public List<Text> showtexture(int user_id){
		return textDao.showtexture(user_id);
	}
}
