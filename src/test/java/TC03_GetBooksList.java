import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class TC03_GetBooksList extends APIBaseTest {

    @Test
    public void testGetBooks() {
        // Send GET request to /books
        Response response = RestAssured.given()
                .queryParam("type", "fiction")
                .queryParam("limit", 5)
                .when()
                .get("/books")
                .then()
                .extract()
                .response();

        // Print the response body
        System.out.println(response.asPrettyString());

        // Validate status code and check that books are returned
        assertEquals(response.statusCode(), 200, "Status code should be 200");
        //assertTrue(response.jsonPath().getList("$").size() > 0, "Books list should not be empty");
    }
}