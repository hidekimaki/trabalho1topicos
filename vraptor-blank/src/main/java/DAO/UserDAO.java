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
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

public class UserDAO extends BasicDAO<Person, ObjectId> {

    @Inject
    public UserDAO(MongoClient mongoClient) {
        super(Person.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }

    public void updateUserDAO(Person p) {
        UpdateOperations<Person> ops = this.createUpdateOperations();
        Query<Person> pp = this.createQuery().field("id").equal(p.getId().toHexString());
        this.update(pp, ops);
    }

}
