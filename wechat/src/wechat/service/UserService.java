package wechat.service;

import wechat.po.User;
public interface UserService {
	//�û���¼���ܣ�����User����� 
	public User login(User user);
	//����û��Ƿ��ѱ�ע�� 
	public Boolean checkUsername(String username);
	//ע���û�
	public int regist(User user);
}

