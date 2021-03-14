package com.github.srinav.protobuf;


import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;
import example.enumerations.EnumExample.DayOfWeek;

public class EnumMain {

    public static void main(String[] args) {

        EnumMessage.Builder builder = EnumMessage.newBuilder();
        builder.setId(123).setDayOfTheWeek(DayOfWeek.FRIDAY);

        EnumMessage enumMessage = builder.build();

        System.out.println(enumMessage);

    }
}
