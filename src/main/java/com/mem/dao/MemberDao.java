package com.mem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mem.model.Member;
import com.mem.util.HibernateUtil;

@Transactional
public class MemberDao {
	
	private static Transaction transaction;
	private static Session session = HibernateUtil.getSessionFactory().openSession();
	
	public void addMember(Member member) {
		transaction = session.beginTransaction();
		session.save(member);
		transaction.commit();
	}
	
	public List<Member> getAllRecords(){
		//Member member;
		List<Member> listOfMember = new ArrayList<>();
		//transaction = session.beginTransaction();
		
		listOfMember = session.createQuery("from Member").list();
		
		return listOfMember;
		
	}

}
