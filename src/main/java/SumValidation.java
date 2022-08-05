import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {

    @Test
    public void sumOfCourses() {
        int sum = 0;
        JsonPath js=new JsonPath(Payload.CoursePrice());
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        int count=js.getInt("courses.size()");
        for(int i=0;i<count;i++) {
           int coursePrice=js.get("courses["+i+"].price");
           int copiesSold=js.get("courses["+i+"].copies");
           int courseSale = coursePrice*copiesSold;
           System.out.println(courseSale);
           sum = sum + courseSale;

        }
        System.out.println(sum);
        Assert.assertEquals(sum,purchaseAmount);


    }

}
