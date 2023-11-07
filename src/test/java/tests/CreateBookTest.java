package tests;

import org.test.rest.client.TestClient;
import org.test.rest.enums.Category;
import io.restassured.http.ContentType;
import org.test.rest.model.Book;
import org.hamcrest.Matchers;
import org.test.props.TestConfig;
import org.test.rest.model.response.BookValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBookTest {
    @Test
    public void testCreateBook(){
        Book book = new Book("The Adventures of Tom Sawyer",
                "The story about Tom Sawyer.",
                "Mark Twain",
                350, 10, Category.Adventures);

        TestClient client = new TestClient();

        BookValidatableResponse response = client.create(book).
                checkStatusCode(201).
                checkIdNotNull().
                checkLastUpdated().
                checkBook(book);
        client.read(response.getId()).
                checkStatusCode(200).
                checkId(response.getId()).
                checkLastUpdated().
                checkBook(book);
    }
}
