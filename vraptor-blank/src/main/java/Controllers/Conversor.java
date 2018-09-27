package Controllers;


import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import javax.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;
@Convert(ObjectId.class)
@ApplicationScoped
public class Conversor implements Converter<ObjectId> {
  @Override
 public ObjectId convert(String string, Class<? extends ObjectId> type) {
   try{
     return new ObjectId(string);
   } catch(NullPointerException ex) {
     return null;
   }
 }
}

