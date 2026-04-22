
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParserService {

    public String getAttributeValue(String json,
                                    String attributeName) throws Exception {

        JSONParser parser = new JSONParser();

        JSONObject jsonObject =
                (JSONObject) parser.parse(json);

        Object value = jsonObject.get(attributeName);

        if (value == null) {
            throw new IllegalArgumentException(
                    "Attribute not found: " + attributeName
            );
        }

        return value.toString();
    }
}