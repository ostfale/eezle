package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The @JsonIgnore annotation marks a field of a POJO to be ignored by Jackson during serialization and deserialization.
 * Jackson ignores the field both JSON serialization and deserialization.
 * Created by Uwe Sauerbrei on 22.04.2018
 */
public class IgnoreDemoBean {

    @JsonIgnore
    private long personId = 0;

    private String name = "James Clark";

    @Override
    public String toString() {
        return "IgnoreDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
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
}
