package source;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
/**
 *
 * @author Raj Kumar Sony
 */
public class CurrancyConvertorAPI {
    
    public static void main(String[] args) throws MalformedURLException, IOException, ParseException {
        String url_str = "http://data.fixer.io/api/latest?access_key=[YOUR-API-KEY]";

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        InputStream inputStream =(InputStream) request.getContent();
        JSONParser jp = new JSONParser();
        JSONObject jsonObject = (JSONObject)jp.parse(new InputStreamReader(inputStream, "UTF-8"));
        
        Map rates = (HashMap) jsonObject.get("rates");
        System.out.println("\nOnly rates data are bellow - ");
        System.out.println(rates);
        System.out.println();
        
        Set country = rates.keySet();
        System.out.println("Country Code : "+country);
        
        Collection currancy = rates.values();
        System.out.println("Carrancy Rate : "+currancy);
        System.out.println();
        
        String base = (String) jsonObject.get("base");
        System.out.println("Base Rate = "+base);
        
        String date = (String) jsonObject.get("date");
        System.out.println("Date = "+date);
        System.out.println();
        
        Set e = rates.entrySet();
        System.out.println("Rates : "+e);
        System.out.println();
        
        Iterator i = e.iterator();
        while(i.hasNext()){
            Map.Entry entry = (Map.Entry)i.next();
            System.out.println("Country Code = "+entry.getKey()+", Currancy Rate = "+entry.getValue());
        }
        System.out.println("\nOriginal JSON data are bellow - ");
        System.out.print(jsonObject);       
    }
}