/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Keyword {
        @Id
    private ObjectId id;
    private String name;

    public Keyword(String name) {
        this.name = name;
    }

    public Keyword() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
