/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClient;
import javax.inject.Inject;
import modelo.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

/**
 *
 * @author utfpr
 */
public class DocumentoDAO extends BasicDAO<Document, ObjectId>{
    
    @Inject
    public DocumentoDAO(MongoClient mongoClient) {
        super(Document.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
}
