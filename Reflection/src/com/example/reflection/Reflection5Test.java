package com.example.reflection;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;


public class Reflection5Test {
	public static void main(String[] args) throws Exception {

		Class clz = Class.forName("com.example.reflection.priavate4.MemberVO");
		// System.out.println(clz);
		
		Object obj = clz.newInstance();
		BeanInfo info = Introspector.getBeanInfo(clz);
		PropertyDescriptor[] props = info.getPropertyDescriptors();
		for(PropertyDescriptor p : props) {
			System.out.println(p.getDisplayName());
			System.out.println(p.getPropertyType());
			
			// set 메소드의 정체
			Method setMethod = p.getWriteMethod();
			// get 메소드의 정체
			Method getMethod = p.getReadMethod();
			
			if(setMethod == null) {
				continue;
			}
			// setMethod의 set을 어떻게 할 수 있을까? -> invoke를 활용하면 된다
			setMethod.invoke(obj, args); //메서드를 호출하는 메서드인 invoke
			
		}
		

	}
}
