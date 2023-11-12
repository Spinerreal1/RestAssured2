package tests.delete;

import org.test.rest.model.Book;
import org.test.rest.model.response.BookValidatableResponse;
import org.testng.annotations.Test;
import tests.BooksStoreTestBase;

public class DeleteBookTest extends BooksStoreTestBase {
    @Test
    public void testDeleteBook() {
        BookValidatableResponse response = testClient.create(Book.defaultOf()).
                checkStatusCode(201);

        testClient.delete(response.getId()).
                checkStatusCode(200);

        testClient.read(response.getId()).
                checkStatusCode(404);
    }

    @Test
    public void testDeleteNotExistedBook() {
        testClient.delete(9999999).
                checkStatusCode(404);
    }
}
