

import java.io.IOException;

/*
 * Facade class
 *
 * Hides:
 * - HTTP request handling
 * - response handling
 * - JSON parsing
 *
 * Client only uses one simple method.
 */

public class ApiFacade {

    private HttpClient httpClient;
    private JsonParserService jsonParser;

    public ApiFacade() {
        this.httpClient = new HttpClient();
        this.jsonParser = new JsonParserService();
    }

    public String getAttributeValueFromJson(
            String urlString,
            String attributeName)
            throws IllegalArgumentException, IOException {

        try {

            String json =
                    httpClient.get(urlString);

            return jsonParser.getAttributeValue(
                    json,
                    attributeName
            );

        } catch (IllegalArgumentException e) {

            throw e;

        } catch (IOException e) {

            throw e;

        } catch (Exception e) {

            throw new IOException(
                    "Failed to process API response"
            );
        }
    }
}