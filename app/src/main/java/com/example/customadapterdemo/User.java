package com.example.customadapterdemo;

import java.util.Comparator;

public class User {
    String name, phoneNumber;
    Sex sex;

    public User(String name, String phoneNumber, Sex sex) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public static final Comparator<User> SEX_NAME_PHONE_NUMBER_COMPARATOR = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            //сравниваем полы
            int result = o1.getSex().compareTo(o2.getSex());
            if(result != 0){
                return result;
            }
            //сравниваем по имени
            result = o1.getName().compareTo(o2.getName());
            if(result != 0){
                return result;
            }
            //сравниваем по номеру
            return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
        }
    };

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Sex getSex() {
        return sex;
    }
}
