import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC02_GetStatus extends APIBaseTest {

    @Test
    public void testStatus() {
        // Send GET request to /status
        Response response = RestAssured.given()
                .when()
                .get("/status")
                .then()
                .extract()
                .response();

        // Print response for debugging
        //System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Validate status code and response body
        assertEquals(response.statusCode(), 200, "Status code should be 200");
        // Verify the response body contains "OK"
        Assert.assertTrue(response.getBody().asString().contains("OK"));
    }
}
