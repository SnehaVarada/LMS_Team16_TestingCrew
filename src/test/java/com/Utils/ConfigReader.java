package com.Utils;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader 
{
	public static String browser_key;
	public static Properties prop=new Properties();
	public static FileReader fr;
	public static String config_path="src/test/resources/ConfigFiles/Config.properties";
	
	public static String init_Reader()
	{
		try 
		{
		    fr=new FileReader(config_path);
			prop.load(fr);
			browser_key=prop.getProperty("browser");
			return browser_key;
			 } 
	catch (IOException e) 
		{
				e.printStackTrace();
			return "chrome";
		}
	}
		public static String launch_Web(String url)
		{
		 return prop.getProperty(url);
		 
		}
		
		public static String getexcelfilepath() {
			String excelfilelpath = prop.getProperty("excelfilepath");
			if (excelfilelpath != null)
				return excelfilelpath;
			else
				throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
		}
		

		public static String getDashboardHeader() {
			String url = prop.getProperty("dashboardHeader");
			if (url != null)
				return url;
			else
				throw new RuntimeException("url not specified in the Configuration.properties file.");
		}
		public static String getHomePageTitle() {
			String url = prop.getProperty("homePageTitle");
			if (url != null)
				return url;
			else
				throw new RuntimeException("homeURL"	+ " not specified in the Configuration.properties file.");
		}
		
		
	

}

