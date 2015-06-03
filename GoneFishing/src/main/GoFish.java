package main;

import fish.Fish;
import fishdb.FishDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GoFish {
	public static ApplicationContext ctx;
	public static FishDao dao;
	
	public void openDB(Fish update){
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		dao=(FishDao)ctx.getBean("fdao");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
