import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class APIBaseTest {

    @BeforeClass
    public void setUp() {
        // Set base URL for all tests
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
    }
}