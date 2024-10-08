package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	//create
	void add(Member m);
	
	
	
	//read
	List<Member> selectAll();
	List<Member> selectByMemberid(int memberid);	
	List<Member> selectMember(String username,String password);
	List<Member> selectByUsername(String username);
	//update
	void update(Member m);
	
	
	//delete
	void delete(Member m);
	

}
