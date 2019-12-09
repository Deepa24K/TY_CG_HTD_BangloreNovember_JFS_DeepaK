package com.cg.map.hashmap;

import java.util.Collection;
import java.util.HashMap;

public class HashMap2a {
public static void main(String[] args) {
	HashMap <Integer, HashMap2> h2=new HashMap<Integer,HashMap2>();
	h2.put(6,new HashMap2("divya",5));
	h2.put(10,new HashMap2("ramesh",6));
	h2.put(7,new HashMap2("suresh",3));
	h2.put(56,new HashMap2("ganesh",4));
	h2.put(null,null);
	h2.put(null, null);
	h2.put(6,new HashMap2("divya",44));
	Collection<HashMap2> h1=h2.values();
	for (HashMap2 s1 : h1) {
		System.out.println(s1);
		
	}
	System.out.println(h2.containsKey(10));
	System.out.println(h2.containsValue(new HashMap2("suresh",3)));
	
	System.out.println(h2.isEmpty());
	System.out.println(h2.size());
	
}
}
