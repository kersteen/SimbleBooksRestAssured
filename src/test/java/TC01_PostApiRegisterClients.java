import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;
public class TC01_PostApiRegisterClients extends APIBaseTest {

    @Test
    public void testRegisterAPIClient() {
        // Create client data
        String requestBody = "{ \"clientName\": \"Kerstena\", \"clientEmail\": \"kresten213@gmail.com\" }";

        // Send POST request to /api-clients
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api-clients")
                .then()
                .extract()
                .response();
        // Print full response for debugging
        response.prettyPrint();
        // Validate response and token
        assertEquals(response.statusCode(), 201, "Status code should be 201");
        assertNotNull(response.jsonPath().getString("accessToken"), "Access token should not be null");
    }
}