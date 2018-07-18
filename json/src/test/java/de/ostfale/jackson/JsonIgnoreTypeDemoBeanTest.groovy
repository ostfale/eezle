package de.ostfale.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title
import spock.lang.Unroll
/**
 * Test JsonIgnoreType annotation settings with a pojo
 * Created by Uwe Sauerbrei on 22.04.2018
 */
@Title('Unit test for JsonIgnoreProperties annotation')
@Subject(JsonIgnorePropertiesDemoBean)
@Unroll
class JsonIgnoreTypeDemoBeanTest extends Specification {

    private ObjectMapper objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    void cleanup() {
        objectMapper = null
    }

    def "testSerializingWithJsonIgnoreType"() {
        when: "Class JsonIgnoreType"
        String jsonString = objectMapper.writeValueAsString(new JsonIgnoreTypeDemoBean())
        then: "Attribut doorNumber is not serialized"
        jsonString.contains("James Clark")
        !jsonString.contains("doorNumber")
    }

    def "testDeserializingWithJsonIgnoreType"() {
        given: "A json input string"
        String jsonString = '{"personId": 123,"name": "Mary Parker","address": {"doorNumber": "123","streetName": "Phase 1","pincode": "123456","city": "New York"}}'
        when: "Json is deserialized to class"
        JsonIgnoreTypeDemoBean bean = objectMapper.readValue(jsonString, JsonIgnoreTypeDemoBean.class)
        then: "Ignored attributes have not been deserialized"
        bean.getName() == "Mary Parker"
        bean.getAddress().doorNumber != "123"
    }
}
