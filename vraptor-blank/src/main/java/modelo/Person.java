package modelo;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Person {
        @Id
    private ObjectId id;
        
     private String name;
    
    private String user;
    
    private String pass;
    
    private int Rank;
    private List<Document> documentos;

    
    public void Delete(int index){
        documentos.remove(index);
    }
    
    public void Add(Document newdoc){
        documentos.add(newdoc);
    }
    
    public List<Document> getDocumentos() {
        return documentos;
    }

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
