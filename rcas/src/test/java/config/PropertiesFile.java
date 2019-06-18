package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Test.GoogleSearchPageTest_TestNG;

public class PropertiesFile {
	static Properties prop = new Properties();

	public static void main(String[] args) {
		getProperties();
		SetProperty();
		getProperties(); 
	}
	public static void getProperties (){

		try {
			InputStream input = new FileInputStream("E:\\Santu\\eclipse-workspace\\rcas\\src\\test\\java\\config\\Config.properties");
			prop.load(input);
			String bro = prop.getProperty("browser");
			System.out.println(bro);
			GoogleSearchPageTest_TestNG.browsername=bro;

		} catch (Exception e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
	}
	public static void SetProperty() {
		try {
			OutputStream output = new FileOutputStream("E:\\Santu\\eclipse-workspace\\rcas\\src\\test\\java\\config\\Config.properties");
			prop.setProperty("test run ", "Successful");
			prop.store(output, "output data");
		} 
		catch(Exception e) {

			e.printStackTrace();




		}




	}



}
