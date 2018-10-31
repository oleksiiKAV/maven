package com.telesens.academy.automationpractice;

import com.telesens.academy.automationpractice.model.EntityDress;

public class CartTest {

    private String browser;
    private String baseUrl;
    private  int countEntityInCart=0;//hometask
    private  int countEntity=0;//hometask
    private  double sumPriceInCart=0.00;//hometask
    private double constShipping = 2.00;//hometask

    public void init(String browser, String baseUrl) {
        this.browser = browser;
        this.baseUrl = baseUrl;
    }
/*
    public void testAddDressToCart() {
        beforeTest();
        /*
        System.out.println("Start 'testAddDressToCart'");
        System.out.println(String.format("Open browser '%s'", browser));
        System.out.println(String.format("Go to '%s'", baseUrl));
        System.out.println("Go to 'Dresses' category");

        System.out.println("Click more");
        EntityDress entityAdded = readCurrentEntityFromUI();

        int countEntityUI = readCountEntityFromUI();//считали добавляемое кол-во

        System.out.println(String.format("Add entity '%s' to cart", entityAdded));
        System.out.println("Go to cart");

        double sumPriceUI = entityAdded.getPrice() * countEntityUI;

        EntityDress entityFromCart = readEntityFromCart();
        int countEntityFromCart = readCountEntityFromCart();

        System.out.println(String.format("Read entity '%s' from cart", entityFromCart));

        System.out.println("Assert equals added entity and read entity");
        assert entityAdded.equals(entityFromCart);

        //assert count.equals(); - не получается
        if (countEntityFromCart == countEntityUI){ //
            System.out.println(String.format("Сount of entity in Cart is '%d' and correct", countEntityFromCart));
            System.out.println(String.format("You prise is '%.2f' and correct", countEntityFromCart * entityAdded.getPrice()));
            }
            else
            System.out.println(String.format("Сount of entity in Cart is '%d' and wrong", countEntityFromCart));
        System.out.println("Finish 'testAddDressToCart'");
    }
*/

public void testAddDressToCart(EntityDress addedDress, int amount) {
        beforeTest();
        System.out.println("Find and Click more by " + addedDress);
//        EntityDress entityAdded = readCurrentEntityFromUI();

        System.out.println(String.format("Add entity '%s', amount: %d to cart",
        addedDress, amount));
        System.out.println("Go to cart");

        EntityDress entityFromCart = readEntityFromCart();
        int  amountFromCart = readAmountFromCart();
        double totalFromCart = readTotalFromCart();
        double total = amountFromCart*addedDress.getPrice();
        System.out.println(String.format("Read entity '%s' from cart", entityFromCart));


        System.out.println("Assert equals added entity and read entity");
        assert addedDress.equals(entityFromCart);
        assert amount == amountFromCart;
        assert total == totalFromCart;
        System.out.println("Finish 'testAddDressToCart'");
        }

private double readTotalFromCart() {
        return 52.0;
        }

private int readAmountFromCart() {
        return 2;
        }
        /*
    private int readCountEntityFromUI() {
        CountEntity cntEntity = new CountEntity();
        return cntEntity.setCountEntity(2);
    }
    private int readCountEntityFromCart() {
        CountEntity cntEntity = new CountEntity();
        return cntEntity.setCountEntity(2);
    }
*/
    private EntityDress readEntityFromCart() {
        EntityDress entityFromCart = new EntityDress();
        entityFromCart.setName("Printed Dress");
        entityFromCart.setModel("demo_3");
        entityFromCart.setSize("S");
        entityFromCart.setColor("Orange");
        entityFromCart.setPrice(26.00);
        return entityFromCart;
    }

    private EntityDress readCurrentEntityFromUI() {
        EntityDress entityAdded = new EntityDress();
        entityAdded.setName("Printed Dress");
        entityAdded.setModel("demo_3");
        entityAdded.setSize("S");
        entityAdded.setColor("Orange");
        entityAdded.setPrice(26.00);
        return entityAdded;
    }

    public void beforeTest() {
        System.out.println("Start 'testAddDressToCart'");
        System.out.println(String.format("Open browser '%s'", browser));
        System.out.println(String.format("Go to '%s'", baseUrl));
        System.out.println("Go to 'Dresses' category");
    }

    //попробовать анализ колличества и общей суммы
}
