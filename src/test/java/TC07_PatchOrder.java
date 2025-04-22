import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC07_PatchOrder extends APIBaseTest {

    @Test
    public void testUpdateOrder() {
        // Replace with a valid order ID and token
        String orderId = "GuJaPk52U8vk-c3M62HdW"; // TODO: Replace with actual order ID
        String authToken = "10f9be904ef8322454e973c4de40863559f6ddac601add7bcc02f389949ba97d"; // TODO: Replace with actual token
//xC6SxsFfMz4SYvL3-Rrd2
        // Create updated customer name
        String requestBody = "{ \"customerName\": \"Kersteen Morris\" }";

        // Send PATCH request to update order
        Response updateResponse = RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch("/orders/" + orderId)
                .then()
                .extract()
                .response();

        // Print update response for debugging
        System.out.println("Update Response:");
        System.out.println(updateResponse.asPrettyString());

        // Validate status code of update
        assertEquals(updateResponse.statusCode(), 204, "Status code should be 200");

        // Send GET request to verify updated customerName
        Response getResponse = RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/orders/" + orderId)
                .then()
                .extract()
                .response();

        // Print get response for debugging
        System.out.println("Get Order Response:");
        System.out.println(getResponse.asPrettyString());

        // Validate customer name is updated
        assertEquals(getResponse.jsonPath().getString("customerName"), "Kersteen Morris", "Customer name should be updated");
    }
}
