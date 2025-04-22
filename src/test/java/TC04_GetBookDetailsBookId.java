import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC04_GetBookDetailsBookId extends APIBaseTest {

    @Test
    public void testGetSingleBook() {
        // Replace :bookId with an actual book ID (example: 1)
        Response response = RestAssured.given()
                .when()
                .get("/books/5")
                .then()
                .extract()
                .response();

        // Print response for debugging
        System.out.println(response.asPrettyString());

        // Validate status code and book details
        assertEquals(response.statusCode(), 200, "Status code should be 200");
        assertEquals(response.jsonPath().getInt("id"), 5, "Book ID should match");
    }
}
