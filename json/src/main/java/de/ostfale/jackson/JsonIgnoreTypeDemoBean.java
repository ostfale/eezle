package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

/**
 * The @JsonIgnoreType annotation is used to mark a class to be ignored during serialization and deserialization.
 * It marks all the properties of the class to be ignored while generating JSON and reading JSON.
 * Created by Uwe Sauerbrei on 22.04.2018
 */
public class JsonIgnoreTypeDemoBean {

    @JsonIgnoreType
    public static class Address {
        public String doorNumber = null;
        public String streetName = null;
        public String pinCode = null;
        public String city = null;

        @Override
        public String toString() {
            return "Address{" +
                    "doorNumber='" + doorNumber + '\'' +
                    ", streetName='" + streetName + '\'' +
                    ", pinCode='" + pinCode + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    private long personId = 0;
    private String name = "James Clark";
    private Address address = new Address();

    @Override
    public String toString() {
        return "JsonIgnoreTypeDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';

    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
