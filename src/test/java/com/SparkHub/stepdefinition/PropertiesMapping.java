package com.SparkHub.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesMapping {
	public Properties envProp , objProp ;
	
	
	public PropertiesMapping () throws IOException {
		objProp = new Properties();
		envProp = new Properties ();
		
		// Load environment.properties file
		
		File envFilePath = new File("./src/test/resource/Config/environment.properties");		
		FileInputStream fisEnv = new FileInputStream(envFilePath);
		envProp.load(fisEnv);
		objProp.putAll(envProp);
		
		// Load object.properties file
		
		File objFilePath = new File("./src/test/resource/Config/object.properties");
		FileInputStream fisObj = new FileInputStream(objFilePath);
		objProp.load(fisObj);
		
		// Load createOpportunity.properties
		
		File createOppFilepath = new File ("./src/test/resource/Config/createOpportunity.properties");
		FileInputStream createopp = new FileInputStream(createOppFilepath);
		objProp.load(createopp);
			
		
		
		
}
	
	public String getObjData (String testParam)  {
		try {
			
			String objData = objProp.getProperty(testParam);		
			return objData;
		} catch (Exception e) {
			
			return null;
		}
	
	}
	
public String getEnvData (String testParam)  {
		
		try {
			
			String envData = objProp.getProperty(testParam);
			return envData;
		} catch (Exception e) {
			
			return null;
		}
		
}
}