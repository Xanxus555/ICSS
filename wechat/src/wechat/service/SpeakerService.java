package wechat.service;

import java.util.List;

import wechat.po.Text;

public interface SpeakerService {
	public void sendtext(Text text);
	public List<Text> showtexture(int user_id);
	
}
