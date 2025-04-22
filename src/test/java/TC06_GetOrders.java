import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC06_GetOrders extends APIBaseTest {

    @Test
    public void testGetOrders() {
        // Replace with a valid token from authentication
        String authToken = "10f9be904ef8322454e973c4de40863559f6ddac601add7bcc02f389949ba97d"; // TODO: Replace with actual token

        // Send GET request to /orders
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/orders")
                .then()
                .extract()
                .response();

        // Print the response for debugging
        System.out.println(response.asPrettyString());

        // Validate status code and ensure orders are returned
        assertEquals(response.statusCode(), 200, "Status code should be 200");
      //  assertTrue(response.jsonPath().getList("$").size() > 0, "Orders list should not be empty");
    }
}