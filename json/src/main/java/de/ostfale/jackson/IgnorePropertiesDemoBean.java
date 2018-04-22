package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The @{@link com.fasterxml.jackson.annotation.JsonIgnoreProperties} annotation is used at the class level to
 * ignore fields during serialization and deserialization.  The properties that are declared in this
 * annotation will not be mapped to the JSON content.
 * Created by Uwe Sauerbrei on 22.04.2018
 */
@JsonIgnoreProperties({"userId", "gender"})
public class IgnorePropertiesDemoBean {

    private long userId = 0;
    private String name = "James Clark";
    private String gender = null;

    @Override
    public String toString() {
        return "IgnorePropertiesDemoBean{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
