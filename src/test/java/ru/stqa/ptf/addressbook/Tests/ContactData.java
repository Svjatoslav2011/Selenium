package ru.stqa.ptf.addressbook.Tests;

public class ContactData {
    private final String name;
    private final String lastName;
    private final String address;

    public ContactData(String name, String lastName, String address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}
