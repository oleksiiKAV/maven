package com.telesens.academy.lesson13;

import com.telesens.academy.automationpractice.CompareDresses;
import com.telesens.academy.automationpractice.model.EntityDress;

import java.util.*;

public class PsevdoClass {

    public static void main(String[] args) {
        EntityDress[] array = CompareDresses.getExpectedDresses();
        System.out.println(Arrays.toString(array));
        List<EntityDress> list = convertArrayToList(array);
        System.out.println(list);
        EntityDress[] arrayFromList = convertListToArray(list);

        System.out.println("Array from List:");
        System.out.println(Arrays.toString(arrayFromList));

        System.out.println("Array to map: ");
        Map<String, EntityDress> map = convertArrayToMap(array);
        System.out.println(map);

        System.out.println("Filter list by orange: ");
        List<EntityDress> filteredList = filterByColor(list, "Orange");
        System.out.println(filteredList);

        System.out.println("Are Two list equal?: ");
        EntityDress[] array1 = CompareDresses.getActualDresses();
        boolean compareList = checkEqualLists(list,convertArrayToList(array1));
        System.out.println(list);
        System.out.println(convertArrayToList(array1));
        System.out.println(compareList);

        System.out.println("MAP to List: ");
        System.out.println(convertMapToList(map));

        System.out.println("Array only Models from List: ");
        System.out.println(Arrays.toString(convertListToModelArray(list)));


    }
    //  - конвертировать List в массив
    public static EntityDress[] convertListToArray(List<EntityDress> list) {
        //return list.toArray(new EntityDress[]{});
        return (EntityDress[]) list.toArray();
    }
//- конвертировать массив в List
    public static List<EntityDress> convertArrayToList(EntityDress[] array) {
        return Arrays.asList(array);
    }

    // конвертировать массив в Map в качестве ключа взять поле model
    public static Map<String, EntityDress> convertArrayToMap(EntityDress[] array) {
        Map<String, EntityDress> map = new HashMap<>();
        //for (int i=0; i<array.length;i++) {
        //    map.put(array[i].getModel(), array[i]);
        //}
        for (EntityDress dress: array) {
            map.put(dress.getModel(),dress);
        }
        return map;
    }

    //  - проверить, равны ли два списка
    public static boolean checkEqualLists(List<EntityDress> list1, List<EntityDress> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }

    // - конвертировать Map в List
    public static List<EntityDress> convertMapToList(Map<String, EntityDress> map) {
        List<EntityDress> list = new ArrayList<EntityDress>(map.values());
        return list;
    }

    // TODO - конвертировать List в Массив (массив содержит только String - значения поля model)
    public static String[] convertListToModelArray(List<EntityDress> list) {
        String[] arrayModel = new String[list.size()];
        for (int i=0; i<list.size();i++) {
            arrayModel[i]=list.get(i).getModel();
        }
        return arrayModel;

    }

    //  - конвертировать отфильтровать List, оставив только позиции по заданному цвету
    public static List<EntityDress> filterByColor(List<EntityDress> list, String color) {
        List<EntityDress> filteredDresses = new ArrayList<>();
        for (EntityDress dress : list){
            if (dress.getColor().equals(color)){
                filteredDresses.add(dress);
            }
        }
        return filteredDresses;
    }
    }


