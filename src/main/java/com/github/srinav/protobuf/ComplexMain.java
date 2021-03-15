package com.github.srinav.protobuf;

import example.complex.Complex.*;

import java.util.Arrays;

public class ComplexMain {

    public static void main(String[] args) {
        System.out.println("Complex Example");

        DummyMessage oneDummyMessage = createNewDummyMessage(55,"one dummt message");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();
        //singular message field
        builder.setOneDummy(oneDummyMessage);

        //repeated field
        builder.addMultipleDummy(createNewDummyMessage(65,"Second"));
        builder.addMultipleDummy(createNewDummyMessage(66,"Third"));
        builder.addAllMultipleDummy(Arrays.asList(createNewDummyMessage(67,"other"),
                createNewDummyMessage(68,"other other")));

        ComplexMessage message = builder.build();

                System.out.println(message.toString());

                //GET
        message.getOneDummy();
        message.getMultipleDummyList();
        message.getMultipleDummyCount();
        message.getMultipleDummy(2);


    }


    public static DummyMessage createNewDummyMessage(Integer id, String name){

        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();
        DummyMessage message = dummyMessageBuilder.setName(name).setId(id).build();
        return message;

    }
}
