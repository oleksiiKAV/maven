package com.telesens.academy.lesson17;

import java.io.*;
import java.util.Properties;

public class PropertyDemo {
    public static void main(String[] args) {

        Properties prop = new Properties();
        File file = new File("demo.properties");
        try(FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);
            String url = prop.getProperty("url");
            String login = prop.getProperty("login");
            String password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Чтение  из файла ресурса!!!!!
    public static  String readProperty(String key){
        Properties prop = new Properties();
        InputStream is=PropertyDemo.class.getClassLoader().getResourceAsStream("java-part.properties");
        File file = new File("java-part.properties");
        try(InputStreamReader fis = new InputStreamReader(is, "UTF-8")) {
            prop.load(fis);
            return  prop.getProperty(key);
           // String url = prop.getProperty("url");
           // String login = prop.getProperty("login");
           // String password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
