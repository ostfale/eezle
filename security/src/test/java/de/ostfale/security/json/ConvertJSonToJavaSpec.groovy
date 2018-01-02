package de.ostfale.security.json

import org.json.simple.JSONObject
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

/**
 * Test JSon to Java conversion
 * Created by Uwe Sauerbrei on 02.01.2018
 */

@Title('Test JSon conversion')
@Subject(ConvertJSonToJava)
class ConvertJSonToJavaSpec extends Specification {

    def "convertWithGSon"() {
        given: "A JSon string"
        String jsonString = ConvertJSonToJava.createJsonObject().toString()
        when: "Json is converted into Java"
        Player player = new ConvertJSonToJava().convertWithGSon(jsonString)
        then: "All attributes are mapped"
        player.name == "Ronaldo"
        player.sport == "soccer"
        player.age == 25
        player.id == 125
        player.lastScores == [2, 1, 3, 5, 0]
    }

    def "ConvertWithJackson"() {
        given: "A JSon string"
        String jsonString = ConvertJSonToJava.createJsonObject().toString()
        when: "Json is converted into Java"
        Player player = new ConvertJSonToJava().convertWithJackson(jsonString)
        then: "All attributes are mapped"
        player.name == "Ronaldo"
        player.sport == "soccer"
        player.age == 25
        player.id == 125
        player.lastScores == [2, 1, 3, 5, 0]
    }

    def "Convert with json-simple"() {
        given: "a json string"
        String jsonString = ConvertJSonToJava.createJsonObject().toString()
        when: "Json is converted into Java"
        JSONObject player = new ConvertJSonToJava().convertWithJSonSimple(jsonString)
        then: "All attributes are mapped"
        player.get("name") == "Ronaldo"
        player.get("age") == 25
        player.get("id") == 125
    }
}
