import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJsonParse {


    public static void main(String[] args) {
        int coursePrices=0; 
        JsonPath js= new JsonPath(Payload.CoursePrice());
        int count = js.getInt("courses.size()");
        System.out.println(count);
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);
        String title = js.getString("courses[0].title");
        System.out.println(title);
        for(int i=0;i<count;i++) {
            String courseTitle = js.getString("courses["+i+"].title");
            int coursePrice = js.getInt("courses["+i+"].price");
            System.out.println("Course Title is "+courseTitle+" "+"Course Price is "+coursePrice);
        }

        //Print no of copies sold by RPA Course
        for (int i=0;i<count;i++) {
            String courseTitle = js.get("courses["+i+"].title");
           if(courseTitle.equalsIgnoreCase("Cypress")) {
               int copies = js.get("courses["+i+"].copies");
               System.out.println("Copies sold "+copies);
               break;
           }
           else{

           }
        }
//Verify if Sum of all Course prices matches with Purchase Amount
        for (int i=0;i<count;i++) {
            int price=js.get("courses["+i+"].price");
            int copies=js.get("courses["+i+"].copies");
            coursePrices=coursePrices+price*copies;
        }
        Assert.assertEquals(purchaseAmount,coursePrices);

    }



}
