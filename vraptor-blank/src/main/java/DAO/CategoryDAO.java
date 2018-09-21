/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClient;
import modelo.Category;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author utfpr
 */
public  class CategoryDAO extends BasicDAO<Category, ObjectId>{
  
    public CategoryDAO(Class<Category> entityClass, MongoClient mongoClient, Morphia morphia, String dbName) {
        super(Category.class, mongoClient,new Morphia(), MongoClientProvider.DATABASE);
    }
  
    
}
