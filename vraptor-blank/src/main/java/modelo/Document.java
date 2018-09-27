package modelo;

import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Document {
        @Id
    private ObjectId id;
    
    private String idPerson;
    private long date;
    private long lastupdate;
    private String filename;
    private List<Keyword> keywords;
    private String categoria;

    public Document(long date, long lastupdate, String filename, List<Keyword> keywords, int categoria) {
        this.date = date;
        this.lastupdate = lastupdate;
        this.filename = filename;
        this.keywords = keywords;
    }

    public Document() {
        this.date = 1234;
        this.lastupdate = 1234;
        this.filename = "teste";
        
        this.categoria = "1";
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    
    
    


    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(long lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

  
    
    
}
