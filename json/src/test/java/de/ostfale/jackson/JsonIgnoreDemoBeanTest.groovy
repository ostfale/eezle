package de.ostfale.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title
import spock.lang.Unroll

/**
 * Test for JsonIgnore annotation
 * Created by Uwe Sauerbrei on 22.04.2018
 */
@Title('Unit test for JsonIgnore annotation')
@Subject(JsonIgnoreDemoBean)
class JsonIgnoreDemoBeanTest extends Specification {

    private ObjectMapper objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    void cleanup() {
        objectMapper = null
    }

    @Unroll
    def "testSerializingWithJsonIgnore"() {
        when: "Class JsonIgnoreDemoBean is serialized"
        String jsonString = objectMapper.writeValueAsString(new JsonIgnoreDemoBean())
        then: "Attribut personId is not serialized"
        jsonString.contains("James Clark")
        !jsonString.contains("personId")
    }

    @Unroll
    def "testDeserializingWithJsonIgnore"() {
        given: "A json input string"
        String jsonString = '{"personId": 231, "name": "Mary Parker"}'
        when: "Json is deserialized to class"
        JsonIgnoreDemoBean bean = objectMapper.readValue(jsonString, JsonIgnoreDemoBean.class)
        then: "Ignored attriutes have not been deserialized"
        bean.getName() == "Mary Parker"
        bean.getPersonId() != 231L
    }
}
