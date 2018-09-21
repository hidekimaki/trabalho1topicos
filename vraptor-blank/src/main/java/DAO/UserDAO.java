/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClient;
import modelo.Person;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author utfpr
 */
public class UserDAO extends BasicDAO<Person, ObjectId>{
    
    public UserDAO(Class<Person> entityClass, MongoClient mongoClient, Morphia morphia, String dbName) {
        super(Person.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
}
