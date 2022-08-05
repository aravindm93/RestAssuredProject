public class Payload {

    public static String AddPlace() {
        return "{\n" +
                "    \"location\":{\n" +
                "        \"lat\": 38.254645,\n" +
                "        \"lng\": 33.427362\n" +
                "    },\n" +
                "    \"accuracy\": 50,\n" +
                "    \"name\":\"Bhagat Singh Road\",\n" +
                "    \"phone_number\":\"(+91)8879419439\",\n" +
                "    \"address\":\"15 high street, mumbai\",\n" +
                "    \"types\": [\n" +
                "        \"restaurant\",\n" +
                "        \"social outing\"\n" +
                "    ]\n" +
                "}"+"";
    }

    public static String CoursePrice() {
        return "{\n" +
                "    \"dashboard\": {\n" +
                "        \"purchaseAmount\": 1460,\n" +
                "        \"website\": \"rahulshettyacademy.com\"\n" +
                "    },\n" +
                "    \"courses\": [\n" +
                "        {\n" +
                "            \"title\": \"Selenium Python\",\n" +
                "            \"price\": 50,\n" +
                "            \"copies\": 6\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"Selenium Java\",\n" +
                "            \"price\": 100,\n" +
                "            \"copies\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"Cypress\",\n" +
                "            \"price\": 20,\n" +
                "            \"copies\": 8\n" +
                "        }\n" +
                "    ]\n" +
                "}";

    }

    public static String addBookPayload(String isbn, String aisle){
        String payload = "{\n" +
                "    \"name\": \"Learn Selenuium Automation with Java\",\n" +
                "    \"isbn\": \""+isbn+"\",\n" +
                "    \"aisle\": \""+aisle+"\",\n" +
                "    \"author\": \"John foe\"\n" +
                "}";
        return payload;
    }
}
