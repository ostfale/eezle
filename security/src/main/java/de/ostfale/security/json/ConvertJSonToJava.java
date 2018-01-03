package de.ostfale.security.json;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz52o0pe9Z8
 * <p>
 * Shows the use of three different libraries to convert JSon to Java
 * Created by Uwe Sauerbrei on 02.01.2018
 */
public class ConvertJSonToJava {

    public Player convertWithGSon(String jasonToConvert) {
        Gson gson = new Gson();
        return gson.fromJson(jasonToConvert, Player.class);
    }

    public Player convertWithJackson(String jasonString) throws IOException {
        return new ObjectMapper().readValue(jasonString, Player.class);
    }

    /**
     * The JSON-Simple is another open source library which supports JSON parsing and formatting. The good thing about this library is its small size,
     * which is perfect for memory constraint environments like J2ME and Android. (JDK 1.2 compatible)
     *
     * @param jasonString json input
     * @return mapped pojo
     */
    public JSONObject convertWithJSonSimple(String jasonString) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(jasonString);

    }

    public static JsonObject createJsonObject() {
        Map<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonBuilderFactory jsonBuilderFactory = Json.createBuilderFactory(config);
        JsonObject jsonObject = jsonBuilderFactory.createObjectBuilder()
                .add("name", "Ronaldo")
                .add("sport", "soccer")
                .add("age", 25)
                .add("id", 125)
                .add("lastScores", jsonBuilderFactory.createArrayBuilder().add(2).add(1).add(3).add(5).add(0))
                .build();
        System.out.println(jsonObject);
        return jsonObject;
    }
}
