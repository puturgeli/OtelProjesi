package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigarationReader {

   public static Properties properties;


   static{
       String path="src/Configuration.properties";

       try {
           FileInputStream fileInputStream=new FileInputStream(path);
           properties=new Properties();
           properties.load(fileInputStream);
           fileInputStream.close();
       } catch (IOException e) {
           e.printStackTrace();
       }


   }

   public static String getProperty(String key){
       return properties.getProperty(key);
   }


}
