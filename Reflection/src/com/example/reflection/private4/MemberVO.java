package com.example.reflection.private4;

//getter, setter없으면서 private 접근제한자에 접근할 수 있을까? -> getDeclaredField()로 가능

public class MemberVO {
	private String name;
	private String id;
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", id=" + id + "]";
	}
}
