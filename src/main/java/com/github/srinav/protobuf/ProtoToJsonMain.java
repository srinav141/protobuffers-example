package com.github.srinav.protobuf;


import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple.SimpleMessage;

import java.util.Arrays;

public class ProtoToJsonMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();
        builder.setId(42).
                setIsSimple(true).
                setName("My Simple Message Name");
        // repeated field
        builder.addSimpleList(1)
                .addSimpleList(2)
                .addSimpleList(3)
                .addAllSimpleList(Arrays.asList(4,5,6));

        //Convert proto-buff to json
        String jsonString = JsonFormat.printer().print(builder);

        System.out.println(jsonString);

        SimpleMessage.Builder builder2 = SimpleMessage.newBuilder();
        //Json to protobuf
        JsonFormat.parser().ignoringUnknownFields().merge(jsonString,builder2);

        System.out.println(builder2);


    }
}
