package com.example.demo.ServicePackage;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass implements ServiceInterface{

	public int result() {
		int a=5,b=5;
		return a*b;
	}
	

}