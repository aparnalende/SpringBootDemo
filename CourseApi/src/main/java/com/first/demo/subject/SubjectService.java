package com.first.demo.subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SubjectService {
	private List<Subject>list=new ArrayList<>(
			Arrays.asList(new Subject(201,"Java","Programming Language"),new Subject(302,"Javascript","Scripting Language"),new Subject(501,"Maths","Numerical Subject"),new Subject(402,"English","Literature Subject")));

	public List<Subject> getAllSubjects(){
		return list;
	}

	public Subject getSubject(int code) {
		Subject s=null;
		for(Subject sub:list) {
			if(sub.getCode()==code) {
				s=sub;
				return s;
			}
		}
		return s;
	}

	public void addSubject(Subject subject) {
		list.add(subject);
	}
	public void updateSubject(Subject subject,int code) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCode()==code) {
				list.set(i, subject);
				return;
			}
		}
	}

	public void deleteSubject(int code) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCode()==code) {
				list.remove(i);
				return;
			}
		}
	}
}
