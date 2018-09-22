/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClient;
import javax.inject.Inject;
import modelo.Category;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author utfpr
 */
public  class CategoryDAO extends BasicDAO<Category, ObjectId>{
  
    @Inject
    public CategoryDAO(MongoClient mongoClient) {
        super(Category.class, mongoClient,new Morphia(), MongoClientProvider.DATABASE);
    }
  
    
}
