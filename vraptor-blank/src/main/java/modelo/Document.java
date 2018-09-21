package modelo;

import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Document {
        @Id
    private ObjectId id;
    
    private long date;
    private long lastupdate;
    private String filename;
    private List<Keyword> keywords;
    private int categoria;

    public Document(long date, long lastupdate, String filename, List<Keyword> keywords, int categoria) {
        this.date = date;
        this.lastupdate = lastupdate;
        this.filename = filename;
        this.keywords = keywords;
        this.categoria = categoria;
    }

    public Document() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    
    
}
