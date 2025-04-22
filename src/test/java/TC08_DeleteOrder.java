import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC08_DeleteOrder extends APIBaseTest {

    @Test
    public void testDeleteOrder() {
        // Replace with a valid order ID and token
        String orderId = "GuJaPk52U8vk-c3M62HdW"; // TODO: Replace with actual order ID
        String authToken = "10f9be904ef8322454e973c4de40863559f6ddac601add7bcc02f389949ba97d"; // TODO: Replace with actual token

        // Send DELETE request to remove order
        Response deleteResponse = RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .when()
                .delete("/orders/" + orderId)
                .then()
                .extract()
                .response();

        // Print delete response
        System.out.println("Delete Response:");
        System.out.println(deleteResponse.asPrettyString());

        // Validate delete status
        assertEquals(deleteResponse.statusCode(), 200, "Status code should be 200");

        // Try to fetch the deleted order
        Response getResponse = RestAssured.given()
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/orders/" + orderId)
                .then()
                .extract()
                .response();

        // Print get response after delete
        System.out.println("Get Response After Delete:");
        System.out.println(getResponse.asPrettyString());

        // Validate that the order no longer exists
        assertEquals(getResponse.statusCode(), 404, "Order should not exist after deletion");
        assertEquals(getResponse.jsonPath().getString("error"), "No order with id " + orderId, "Error message should match");
    }
}
