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

    //сравниваем по полу
    public static final Comparator<User> SEX_COMPARATOR = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.getSex().compareTo(o2.getSex());
        }
    };

    //сравниваем по номеру
    public static final Comparator<User> PHONE_NUMBER_COMPARATOR = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
        }
    };

    //сравниваем по имени
    public static final Comparator<User> NAME_COMPARATOR = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.getName().compareTo(o2.getName());
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
