package com.telesens.academy.lesson18.hometask;

import com.telesens.academy.lesson17.PropertyDemo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
2) Сгенерировать массив 100 абонентов:
		- id возрастает для каждого следующего абонента (необязательно последовательно)
		- со случайными именами и фамилиями (брать из подготовленного массива данных)
		- возраст от 18 до 60 лет
		- телефонный номер заполнить по следующему правилу (задача была на предыдущих занятиях):
			- 10 цифр
			- первый три цифры 999,
			- последняя 0 или 5
			- остальные цифры - любые
 */
public class SubscriberDemo {
    private static String [] firstNames = {"Maша", "Петя", "Вася", "Миша", "Даша", "Катя", "Саша", "Паша"};
    private static String [] lastNames = {"Корженко", "Михайленко", "Кузьменко", "Клопотенко", "Половик"};
    private static Random rand =  new Random();
    private static long id = 1L;

    // TODO
    private static String txt = "subscribers.txt";
    private static String xls = "subscribers.xlsx";

    private static String PROP_NAME = "java-part.properties";

    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream resourceStream = SubscriberDemo.class.getClassLoader().getResourceAsStream(PROP_NAME);
        try {
            prop.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String subscriberFile = prop.getProperty("subscriber.txt");
        try (FileWriter fw = new FileWriter(subscriberFile)){
            System.out.println("***Generate***");
            Subscriber[] array =
                    Stream
                            .generate(SubscriberDemo::nextSubscriber)
//                .generate(()->SubscriberDemo.nextSubscriber()) // можно так
//                .generate(()->{
//                    return SubscriberDemo.nextSubscriber();
//                }) // можно и так
                            .limit(100)
                            .filter(SubscriberDemo.distinctBy(Subscriber::getPhoneNumber))
                            .peek(System.out::println)
// это тоже работает        .peek(ConsumerExceptional.wrap(s->fw.write(s.toString())))

                            .peek(s->{
                                try {
                                    //fw.write(s.toString()+"\n");
                                    fw.write(prepareSubscriber(s)+"\n");

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            })
                            .peek(SubscriberDemo::InsertConnection)
                            .toArray(Subscriber[]::new);
            System.out.println("***Finish***");

            List<Subscriber> list = new ArrayList<>(Arrays.asList(array));

            Arrays.sort(array);
            System.out.println(Arrays.toString(array));

            list.sort(Comparator.comparingInt(Subscriber::getAge));
//        list.sort((s1, s2)-> Integer.compare(s1.getAge(), s2.getAge()));
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void InsertConnection(Subscriber subscriber) {
        try(Connection conn = DriverManager.getConnection(
                PropertyDemo.readProperty("jdbc.url"));) {
            Class.forName("com.mysql.cj.jdbc.Driver"); // подключаем драйвер

            Statement statement = conn.createStatement();
            //PreparedStatement statement_predefine = conn.prepareStatement(
            //      "INSERT INTO abonent VALUES(?, ?, ?, ?, ?)");
            //String str = subscriber.getId() +
            statement.executeUpdate(
                    "INSERT INTO subscriber VALUES("+
                    subscriber.getId()+", " + Integer.toString(subscriber.getAge())+", '"+
                            subscriber.getLastName()+"', + 'm', '" +subscriber.getFirstName()+"')");

            //"INSERT INTO subscriber VALUES( 423, 40, 'Наливайченко', 'm', 'Петр')");
            //statement.executeUpdate(
             //       "UPDATE subscriber SET first_name='112Петр', last_name='112Наливайченко' WHERE id=27");

            /*
            ResultSet rs = statement.executeQuery("SELECT * FROM subscriber");
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                System.out.println(String.format("%d| %-15s| %-15s| %s| %d",
                        id, firstName, lastName, gender, age));
            }
            statement.executeUpdate("DELETE FROM abonent WHERE abonent_id=7");
            */
            //rs.close(); // закрываем рессурсы
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Subscriber nextSubscriber() {
        long nextId = id;
//        id = id + rand.nextInt(100);
        id++;
        String firstName = generateFirstName();
        String lastName = generateLastName();
        int age = generateAge();
        String phoneNumber = generatePhoneNumber();
        String gender ="";
        if (age % 2 == 0) gender = "m";
            else gender = "f";
        return new Subscriber(nextId, firstName, lastName, age, phoneNumber,gender);
    }

    public static String generateFirstName(){
        int randomNumber = rand.nextInt(firstNames.length);
        return firstNames [randomNumber];
    }

    public static String generateLastName(){
        int randomNumber = rand.nextInt(lastNames.length);
        return lastNames[randomNumber];
    }

    public static int generateAge(){
        int lowerLimit = 18;
        int upperLimit = 60;
        return rand.nextInt(upperLimit-lowerLimit)+lowerLimit;
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

    private static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        final Set<Object> set = new HashSet<>();

        return t -> set.add(keyExtractor.apply(t));
    }
    private static String prepareSubscriber(Subscriber subscriber) {
        return subscriber.getId()+","+subscriber.getFirstName()+","+
                subscriber.getLastName()+","+subscriber.getAge()+","+subscriber.getPhoneNumber() +"," +subscriber.getGender();
    }
}
