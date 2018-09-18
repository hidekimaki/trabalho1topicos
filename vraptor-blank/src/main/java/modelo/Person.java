package modelo;

import java.util.List;

public class Person {
    private int id;
    private String name;
    private String user;
    private String pass;
    private int Rank;
    private List<Document> documentos;

    public int getRank() {
        return Rank;
    }

    public void setRank(int Rank) {
        this.Rank = Rank;
    }
    
    public Person() {
    }

    public Person(String name, String user, String pass) {
        this.name = name;
        this.user = user;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
            
}
