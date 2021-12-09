
package generator;

import java.util.Date;

public class Generator {
    public String generatorId(){
        String id="";
        Date fecha=new Date();
        id=""+fecha.getTime();
        return id;
    }
    
}
