package DAO;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

@Singleton
public class MongoClientProvider implements Serializable {
    public static final String DATABASE = "test";
    
    private static MongoClient mongoClient;
    
    private static Datastore datastore;

    public MongoClientProvider() {
    }
    
    @PostConstruct
    public void init() {
        if(mongoClient == null) {
            mongoClient = new MongoClient("localhost:27017");
        }
        if(datastore == null) {
            Morphia morphia = new Morphia();
            datastore = morphia.createDatastore(mongoClient, DATABASE);
        }
    }
    
    @Produces
    public Datastore getDatastore(){
        return datastore;
    }

    @Produces
    public MongoClient getMongoClient() {
        return mongoClient;
    }
    
    @Produces
    public MongoDatabase getDatabase() {
        return mongoClient.getDatabase(DATABASE);
    }
    
    @PreDestroy
    public void closeConnection() {
        if(mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
