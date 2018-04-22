package de.ostfale.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

/**
 * Created by Uwe Sauerbrei on 22.04.2018
 */
@Title('Unit test for JsonIgnore annotation')
@Subject(IgnoreDemoBean)
class IgnoreDemoBeanTest extends Specification {

    private ObjectMapper objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    void cleanup() {
        objectMapper = null
    }

    def "testSerializingWithJsonIgnore"() {
        when: "Class IgnoreDemoBean is serialized"
        String jsonString = objectMapper.writeValueAsString(new IgnoreDemoBean())
        then: "Attribut personId is not serialized"
        jsonString.contains("James Clark")
        !jsonString.contains("personId")
    }

    def "testDeserializingWithJsonIgnore"() {
        given: "A json input string"
        String jsonString = '{"personId": 231, "name": "Mary Parker"}'
        when: "Json is deserialized to class"
        IgnoreDemoBean bean = objectMapper.readValue(jsonString, IgnoreDemoBean.class)
        then: "Ignored attriutes have not been deserialized"
        bean.getName() == "Mary Parker"
        bean.getPersonId() != 231L
    }
}
