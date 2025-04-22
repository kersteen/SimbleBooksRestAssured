import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

public class TC05_PostSubmitOrder extends APIBaseTest {

    @Test
    public void testSubmitOrder() {
        // Replace with a valid token from authentication
        String authToken = "10f9be904ef8322454e973c4de40863559f6ddac601add7bcc02f389949ba97d"; // TODO: Replace with actual token

        // Create order body
        String requestBody = "{ \"bookId\": 1, \"customerName\": \"Kersteen Morris\" }";

        // Send POST request to /orders
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/orders")
                .then()
                .extract()
                .response();

        // Print response body for debugging
        System.out.println(response.asPrettyString());

        // Validate status code and order ID in the response
        assertEquals(response.statusCode(), 201, "Status code should be 201");
        assertNotNull(response.jsonPath().getString("orderId"), "Order ID should not be null");
    }
}

