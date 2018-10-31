package com.telesens.academy.automationpractice;



import com.academy.automationpractice.ddt.framework.model.AddressData;
import com.telesens.academy.automationpractice.adress.ParserAdressDemo;
import com.telesens.academy.automationpractice.model.EntityDress;

public class TestRunner {
    public static void main(String[] args) {
        EntityDress entityDress1 = new EntityDress();
        entityDress1.setName("Printed Dress");
        entityDress1.setModel("demo_3");
        entityDress1.setSize("S");
        entityDress1.setColor("Orange");
        entityDress1.setPrice(26.00);

        EntityDress entityDress2 = new EntityDress();
        entityDress2.setName("Printed Dress");
        entityDress2.setModel("demo_3");
        entityDress2.setSize("S");
        entityDress2.setColor("Orange");
        entityDress2.setPrice(26.00);

        Object[][] testData = {
                {entityDress1, 2},
                {entityDress2, 2}
        };
        //String rawData = "";
        String rawLine="Kolya,Ivanov,Petrovskogo st. 35,Kharkov,Alaska,61033,United States,+3809353613437,093234567,addressAddedRef";
        AddressData address = ParserAdressDemo.parsLine(rawLine);
                //ParserAddressDemo.parseAddress(rawData);
        Object[][] addressData = {
                {address},
        };

        // TODO

        // TODO
        CartTest cartTest = new CartTest();
        cartTest.testAddDressToCart(entityDress1, 2);
        cartTest.testAddDressToCart(entityDress1, 2);

      //  for (int i = 0; i < testData.length; i++) {
        //    cartTest.testAddDressToCart((EntityDress) testData[i][0], (int)testData[i][1]);
       // }

        //cartTest.testAddDressToCart(entityDress1, 2);
        //cartTest.testAddDressToCart(entityDress2, 2);

    }
}
