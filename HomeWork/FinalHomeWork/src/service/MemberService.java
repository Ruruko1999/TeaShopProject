package service;

import model.Member;

public interface MemberService {
	Member Login(String username,String password);
	
	boolean findByUsername(String username);
	
	void addMember(Member m);
}
