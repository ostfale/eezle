package de.ostfale.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title
import spock.lang.Unroll

/**
 * Created by Uwe Sauerbrei on 22.04.2018
 */
@Title('Unit test for JsonIgnoreProperties annotation')
@Subject(JsonIgnorePropertiesDemoBean)
class JsonIgnorePropertiesDemoBeanTest extends Specification {

    private ObjectMapper objectMapper

    void setup() {
        objectMapper = new ObjectMapper()
    }

    void cleanup() {
        objectMapper = null
    }

    @Unroll('Test serializing with JsonIgnoreProperties annotation')
    def "testSerializingWithJsonIgnoreProperties"() {
        when: "Class JsonIgnorePropertiesDemoBean"
        String jsonString = objectMapper.writeValueAsString(new JsonIgnorePropertiesDemoBean())
        then: "Attribut personId is not serialized"
        jsonString.contains("James Clark")
        !jsonString.contains("userId")
    }

    @Unroll('Test deserializing with JsonIgnoreProperties annotation')
    def "testDeserializingWithJsonIgnoreProperties"() {
        given: "A json input string"
        String jsonString = '{"userId": 231, "name": "Mary Parker", "gender":"male"}'
        when: "Json is deserialized to class"
        JsonIgnorePropertiesDemoBean bean = objectMapper.readValue(jsonString, JsonIgnorePropertiesDemoBean.class)
        then: "Ignored attributes have not been deserialized"
        bean.getName() == "Mary Parker"
        bean.getUserId() != 231L
    }
}
