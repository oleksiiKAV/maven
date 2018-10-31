package com.telesens.academy.automationpractice.adress;
import com.academy.automationpractice.ddt.framework.model.AddressData ;
public class ParserAdressDemo {
    public static void main(String[] args) {

        String rawLine = "Kolya,Ivanov,Petrovskogo st. 35,Kharkov,Alaska,61033,United States,+3809353613437,093234567,addressAddedRef";
        new AddressData();
        AddressData address = parsLine(rawLine);
        System.out.println(address);
    }

    public static AddressData parsLine(String rawLine) {
        String[] rawData = rawLine.split(",");
        AddressData adress = new AddressData()
                .withFirstName(rawData[0])
                .withLastName(rawData[1])
                .withAddress(rawData[2])
                .withCity(rawData[3])
                .withState(rawData[4])
                .withZipCode(rawData[5])
                .withCountry(rawData[6])
                .withHomePhone(rawData[7])
                .withMobilePhone(rawData[8])
                .withAddressAlias(rawData[9]);
        return adress;
    }
}
