

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        ApiFacade apiFacade = new ApiFacade();

        /*
         * Example 1:
         * Chuck Norris API
         */

        try {

            String joke =
                    apiFacade.getAttributeValueFromJson(
                            "https://api.chucknorris.io/jokes/random",
                            "value"
                    );

            System.out.println("Chuck Norris Joke:");
            System.out.println(joke);

        } catch (IOException | IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        System.out.println();

        /*
         * Example 2:
         * Another API
         *
         * This API returns JSON that contains:
         * "base": "EUR"
         */

        try {

            String baseCurrency =
                    apiFacade.getAttributeValueFromJson(
                            "https://api.fxratesapi.com/latest",
                            "base"
                    );

            System.out.println("Base currency:");
            System.out.println(baseCurrency);

        } catch (IOException | IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        System.out.println();

        /*
         * Example 3:
         * Attribute not found
         */

        try {

            apiFacade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "wrongAttribute"
            );

        } catch (IOException | IllegalArgumentException e) {

            System.out.println(
                    "Expected error: " + e.getMessage()
            );
        }
    }
}