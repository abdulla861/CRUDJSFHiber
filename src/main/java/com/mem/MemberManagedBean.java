package com.mem;

import java.util.List;

import javax.faces.bean.ManagedBean;

import com.mem.dao.MemberDao;
import com.mem.model.Member;

@ManagedBean(name = "memberManagedBean")
public class MemberManagedBean {
	
	private String message;
	private Member member;
	
	
	
	public MemberManagedBean() {
		member = new Member();
	}

	public MemberManagedBean(String message, Member member) {
		this.message = message;
		this.member = member;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	

	public String addMember() {
		
		MemberDao dao = new MemberDao();
		dao.addMember(this.member);
		return "success?faces-redirect=true";
		
	}
	
	public List<Member> allRecords(){
		MemberDao dao = new MemberDao();
		return dao.getAllRecords();
	}
	
	
	

}