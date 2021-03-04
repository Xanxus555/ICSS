package wechat.service;

import java.util.List;

import wechat.po.Text;

public interface IndexService {
	public List<Text> showtexture(int user_id);
	public void sendtext(Text text);
}
