package de.ostfale.security.json;

/**
 * Pojo for JSon conversion
 * Created by Uwe Sauerbrei on 02.01.2018
 */
public class Player {
    private String name;
    private String sport;
    private int age;
    private long id;
    private int[] lastScores;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int[] getLastScores() {
        return lastScores;
    }

    public void setLastScores(int[] lastScores) {
        this.lastScores = lastScores;
    }
}
