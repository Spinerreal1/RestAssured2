package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.BaseDescription;
import org.test.rest.client.TestClient;
import org.test.rest.enums.Category;
import io.restassured.http.ContentType;
import org.test.rest.model.Book;
import org.hamcrest.Matchers;
import org.test.props.TestConfig;
import org.test.rest.model.response.BookResponce;
import org.test.rest.model.response.BookValidatableResponse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBookTest extends BooksStoreTestBase {
    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testCreateBook(Book book){


        BookValidatableResponse response = testClient.create(book).
                checkStatusCode(201).
                checkIdNotNull().
                checkLastUpdated().
                checkBook(book);

        testClient.read(response.getId()).
                checkStatusCode(200).
                checkId(response.getId()).
                checkLastUpdated().
                checkBook(book);
    }
}
