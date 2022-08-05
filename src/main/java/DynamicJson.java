import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

    public class DynamicJson {

        @Test(dataProvider = "Books")
        public void addBook(String isbn, String aisle){
            RestAssured.baseURI="https://rahulshettyacademy.com";
            String response = given().header("Content-Type","application/json").
                    body(Payload.addBookPayload(isbn,aisle)).
                    when().post("/Library/Addbook.php").
                    then().log().all().assertThat().statusCode(200).
                    extract().response().toString();
            JsonPath json = ReusableMethods.rawToJson(response);
            String bookId = json.get("ID");
            System.out.println(bookId);

        }
        //Delete Book
//        @Test(dataProvider="Books")
//        public void deleteBookTest() {
//            String bookID = addBook();
//            RestAssured.baseURI="https://rahulshettyacademy.com";
//            String response = given().header("Content-Type","application/json").
//                    body("{\n" +
//                            "    \"ID\": \""+bookID+"\"\n" +
//                            "}").
//                    when().delete("/Library/DeleteBook.php").
//                    then().log().all().assertThat().statusCode(200).
//                    extract().response().toString();
//            JsonPath js2 = ReusableMethods.rawToJson(response);
//            String responseMessage=js2.getString("msg");
//            System.out.println(responseMessage);
//            Assert.assertEquals(responseMessage,"book is successfully deleted");
//        }
        //Parameterization with DataProvider
        @DataProvider(name="Books")
        public Object[][] getData() {
            return new Object[][]{{"PUN","5975"},{"BLG","5976"},{"DEL","5979"}};
        }

    }

