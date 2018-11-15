package com.telesens.academy.lesson16;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.Random;

// Наполнить таблицу абонентов excel(2000 строк) - и в текстовый файл:
//        - имена фамилии взять в соответстсвующих файлах (см. 'java-part.properties') со списком имен/фамилий (женских/мужских);
//        - возраст генерировать случайно от 5 до 90 (можно использовать Гауссово распределение для этого диапазона)
//        (диапазон брать из файла 'java-part.properties')

public class FilesIO {
    public  static Random rand = new Random();
    public  static XSSFWorkbook workbook = new XSSFWorkbook();
    public  static XSSFSheet sheet = workbook.createSheet("Complex Data");
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        // спросить как читать из папки ресурсов. Чтение ниже это файл должен лежать в корне проекта!!!!
        File file = new File("java-part.properties");
        try(FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);
            String dirPath = prop.getProperty("dir.path");
            String xlsFileName = prop.getProperty("subscriber.exc");
            String txtFileName = prop.getProperty("subscriber.txt");

            String maleFirstName = prop.getProperty("male.firstnames");
            String maleLastName = prop.getProperty("male.lastnames");
            String femaleFirstName = prop.getProperty("female.firstnames");
            String femaleLastName = prop.getProperty("female.lastnames");

            String ageFrom = prop.getProperty("age.from");
            String ageTo = prop.getProperty("age.to");
            String ageGaussian = prop.getProperty("age.gaussian");
//как избежать большого колличества try
            try(PrintWriter pw = new PrintWriter(dirPath+txtFileName);){
                List<String> listMFN = Files.readAllLines(Paths.get (dirPath + maleFirstName), Charset.defaultCharset());
                List<String> listMLN = Files.readAllLines(Paths.get (dirPath + maleLastName), Charset.defaultCharset());
                List<String> listFMFN = Files.readAllLines(Paths.get (dirPath + femaleFirstName), Charset.defaultCharset());
                List<String> listFMLN = Files.readAllLines(Paths.get (dirPath + femaleFirstName), Charset.defaultCharset());
                // посде прочтения в Лист файлы закрылись - освободились?
                String writeStr = "";

                for(int i=0;i<2000;i++){
                    //создание строки в листе и ячеек
                    Row row = sheet.createRow(i);
                    Cell cellID = row.createCell(0);
                    Cell cellFirstName = row.createCell(1);
                    Cell cellLastName = row.createCell(2);
                    Cell cellAge = row.createCell(3);
                    Cell cellPhoneNumber = row.createCell(4);
                    //подготовка строки для записи в файл и запись в память данных для ячеек
                    cellID.setCellValue(i);
                    int writeAge = rand.nextInt(Integer.parseInt(ageTo)-Integer.parseInt(ageFrom))+Integer.parseInt(ageFrom);
                    String strPhone = generatePhoneNumber();
                    cellAge.setCellValue(writeAge);
                    cellPhoneNumber.setCellValue(strPhone);

                    if (i % 2 == 0){
                        cellFirstName.setCellValue(listMFN.get(rand.nextInt(listMFN.size())));
                        cellLastName.setCellValue(listMLN.get(rand.nextInt(listMLN.size())));
                        writeStr = i + ","+listMFN.get(rand.nextInt(listMFN.size())) +","+
                                listMLN.get(rand.nextInt(listMLN.size()))+","+
                                writeAge +","+ strPhone;
                    }
                    else{
                        cellFirstName.setCellValue(listFMFN.get(rand.nextInt(listFMFN.size())));
                        cellLastName.setCellValue(listFMLN.get(rand.nextInt(listFMLN.size())));
                        writeStr = i + "," + listFMFN.get(rand.nextInt(listFMFN.size())) +","+
                                listFMLN.get(rand.nextInt(listFMLN.size()))+","+
                                writeAge +","+
                                strPhone;
                    }
                    pw.println(writeStr);//запись строки - почему не работало в этом месте зw.write(writeStr + "\n");
                }
                try(FileOutputStream out = new FileOutputStream(new File(dirPath+xlsFileName))) {
                    workbook.write(out); //подготовленные данные непосредственно в файл
                }
                catch (Exception e) {            e.printStackTrace();        }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generatePhoneNumber() {
        int firstThreeNumbers = 999;
        int middleDigits = rand.nextInt(1_000_000);

        // 1 способ
        int lastDigit = rand.nextBoolean() ? 0 : 5;

        // 2 способ
//        if (rand.nextBoolean())
//            last = 0;
//        else
//            last = 5;

        long phoneNumber =
                firstThreeNumbers*1_000_0000L + // двигаем влево на 7 разрядов
                        middleDigits*10 + // умножаем на 10, чтобы сдвинуть влево на один разряд
                        lastDigit; // 0 или 5

        return Long.toString(phoneNumber);
    }
}
