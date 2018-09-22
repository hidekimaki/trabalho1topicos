/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClient;
import javax.inject.Inject;
import modelo.Person;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;


public class UserDAO extends BasicDAO<Person, ObjectId>{

       @Inject
       public UserDAO(MongoClient mongoClient) {
        super(Person.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
}
