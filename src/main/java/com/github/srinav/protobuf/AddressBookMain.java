package com.github.srinav.protobuf;

import com.example.tutorial.AddressBookProtos.AddressBook;
import com.example.tutorial.AddressBookProtos.Person;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Address Book Main");
        AddressBook.Builder builder = AddressBook.newBuilder();

        builder.addPeople(createPerson("Person-1",1))
                .addPeople(createPerson("Person-2",2));

        AddressBook addressBook = builder.build();

        System.out.println(addressBook.toString());



    }

    public static Person createPerson(String name, int id){
        Person.Builder personBuilder = Person.newBuilder();
        Person john =
                Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .addPhones(
                                Person.PhoneNumber.newBuilder()
                                        .setNumber("555-4321")
                                        .setType(Person.PhoneType.HOME))
                        .build();

        personBuilder.setName(name).setId(id).setEmail(String.format("%s@example.com",name))
                .addPhones(Person.PhoneNumber.newBuilder().setNumber(String.format("%s%s%s-%s%s%s",id,id,id,id,id,id )).setType(Person.PhoneType.HOME))
                .addPhones(Person.PhoneNumber.newBuilder().setNumber(String.format("%s%s-%s%s-%s%s", id,id,id,id,id,id )).setType(Person.PhoneType.WORK));
        Person person_1 = personBuilder.build();

        return person_1;

    }
}
