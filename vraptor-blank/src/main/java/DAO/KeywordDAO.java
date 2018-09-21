/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClient;
import modelo.Keyword;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author utfpr
 */
public class KeywordDAO extends BasicDAO<Keyword, ObjectId>{
    
    public KeywordDAO(Class<Keyword> entityClass, MongoClient mongoClient, Morphia morphia, String dbName) {
        super(Keyword.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
}
