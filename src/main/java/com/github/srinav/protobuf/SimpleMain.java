package com.github.srinav.protobuf;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {
        System.out.println("Hello World");

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();
        builder.setId(42).
                setIsSimple(true).
                setName("My Simple Message Name");
        // repeated field
        builder.addSimpleList(1)
                .addSimpleList(2)
                .addSimpleList(3)
                .addAllSimpleList(Arrays.asList(4,5,6));


        System.out.println(builder.toString());

        SimpleMessage message = builder.build();
        try {
            FileOutputStream fileout = new FileOutputStream("simple_message.bin");

            message.writeTo(fileout);
            fileout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //send as byte array for network
       byte[] bytes =  message.toByteArray();

        try {
            System.out.println("Reading from filw");
            FileInputStream fileinput = new FileInputStream("simple_message.bin");

           SimpleMessage messageFromFile =  SimpleMessage.parseFrom(fileinput);
           System.out.println(messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
