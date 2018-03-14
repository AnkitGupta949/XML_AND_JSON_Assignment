package JsonParsing;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.List;

public class JsonParsingExample {
    public static void main(String[] args) {

        JSONParser parser=new JSONParser();

        try {

            Object obj=parser.parse(new FileReader("src/main/java/JsonParsing/file.json"));
            JSONObject jsonObject=(JSONObject) obj;
            Long id=(long)jsonObject.get("id");
            System.out.println(id);
            String name=(String) jsonObject.get("name");
            System.out.println(name);
            String company=(String) jsonObject.get("company");
            System.out.println(company);
            List<String> list=(JSONArray) jsonObject.get("hobbies");
            System.out.println(list);

            JSONObject empAddress=(JSONObject) jsonObject.get("address");

            System.out.println(empAddress.get("city"));
            System.out.println(empAddress.get("state"));



        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }

    }
}
