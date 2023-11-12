package tests.update;

import org.apache.commons.lang3.RandomStringUtils;
import org.test.rest.enums.Category;
import org.test.rest.model.Book;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BookData;
import tests.BooksStoreTestBase;

public class UpdateBookTest extends BooksStoreTestBase {

    private Integer id;

    @BeforeClass
    public void setUp(){
        id=testClient.create(Book.defaultOf()).
                checkStatusCode(201).getId();
    }

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testUpdateBook(Book book) {
        testClient.update(id, book).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(book);

        testClient.read(id).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(book);
    }
}
