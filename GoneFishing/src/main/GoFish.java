package main;

import java.beans.XMLEncoder;
import java.time.LocalDate;

import fish.Fish;
import fish.FishType;
import fishXML.EncodeXML;
import fishXML.StyleXSL;
import fishdb.FishDao;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GoFish {
	public static ApplicationContext ctx;
	public static FishDao dao;
	public static EncodeXML translator;
	public static StyleXSL styler;
	public static String newXmlFile = "xml/output.xml";
	public static String xslStyleSheet = "xml/schoolFish.xsl";
	public static String styleOutput ="xml/styleOutput.xml";
	public static LocalDate date;
	static Logger log = Logger.getLogger(GoFish.class.getName());
	
	
	public static void updateDB(Fish update){
		if(update != null){
			dao.savePoliseaHolders(update);
		}
	}
	
	public static void xmlConversion(Fish object){
		translator.createEncoder();
		translator.writeToXml(object);
	}
	
	public static void xmlStyling(){
		styler.writeToXml();
	}
	
	

	public static void main(String[] args) {
		
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		dao=(FishDao)ctx.getBean("fdao");
		
		date = LocalDate.of(1987, 3, 24);
		Fish dryRun = (Fish)ctx.getBean("fishObj");
		dryRun.loadFish("Walter", "Herbert", "Wallace", date , 
				FishType.Eel, "Atlantic", "Glover's Reef", 20, false);
		
		translator = (EncodeXML)ctx.getBean("xmlEnc");
		translator.loadFile(newXmlFile);
		
		xmlConversion(dryRun);
		
		styler = (StyleXSL)ctx.getBean("xslStyle");
		styler.loadFile(newXmlFile);
		styler.setStyle(xslStyleSheet, styleOutput);
		
		xmlStyling();
		
		Fish update = styler.readXml();
		
		updateDB(update);
		
		
	}

}
