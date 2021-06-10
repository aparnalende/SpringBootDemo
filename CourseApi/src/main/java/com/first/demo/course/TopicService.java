package com.first.demo.course;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> list=new ArrayList<>(
			Arrays.asList(new Topic("spring","SpringFrameWork","Spring describption"),
					new Topic("SpringBoot","SpringBoot","SpringBoot Description"),
					new Topic("Core Java","Core Java Course","Core Java description")));

	public List<Topic> getAllTopics(){
		return list;
	}
	public Topic getTopic(String id) {
		//		Topic t=list.stream().filter(e->e.getId().equals(id)).findFirst().get();
		Iterator<Topic> itr=list.iterator();
		Topic t=null;
		while(itr.hasNext()) {
			t=itr.next();
			if(t.id.equals(id)) {
				return t;
			}

		}
		return t;
	}
	
	public void addTopic(Topic t) {
		list.add(t);
	}
	
	public void updateTopic(Topic topic,String id) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId().equals(id)) {
				list.set(i, topic);
				return;
			}
		}
	}
	
	public void deleteTopic(String id) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
				return;
			}
		}
		list.removeIf(e->e.getId().equals(id));
	}
}
