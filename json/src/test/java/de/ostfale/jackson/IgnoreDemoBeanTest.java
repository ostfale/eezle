package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

/**
 * Tests {@link com.fasterxml.jackson.annotation.JsonIgnore} annotation in a pojo
 * Created by Uwe Sauerbrei on 22.04.2018
 */
class IgnoreDemoBeanTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @AfterEach
    void tearDown() {
        objectMapper = null;
    }

    @Test
    void testSerializationWithJsonIgnore() throws JsonProcessingException {

        String jsonString = objectMapper.writeValueAsString(new IgnoreDemoBean());
        System.out.println(jsonString);
        assertThat(jsonString, containsString("James Clark"));
        assertThat(jsonString, not(containsString("personId")));
    }

    @Test
    void testDeSerializationWithJsonIgnore() throws IOException {
        String jsonString = "{\"personId\":231, \"name\":\"Mary Parker\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        IgnoreDemoBean ignoreDemoBean = objectMapper.readValue(jsonString, IgnoreDemoBean.class);
        System.out.println(ignoreDemoBean);
        assertThat(ignoreDemoBean.name, is(equalTo("Mary Parker")));
        assertThat(ignoreDemoBean.personId, is(not(equalTo(231L))));
    }
}