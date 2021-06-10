package com.first.demo.subject;

public class Subject {
	private int code;
	private String name;
	private String info;
	public Subject() {

	}
	public Subject(int code, String name, String info) {
		super();
		this.code = code;
		this.name = name;
		this.info = info;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Subject [code=" + code + ", name=" + name + ", info=" + info + "]";
	}


}
