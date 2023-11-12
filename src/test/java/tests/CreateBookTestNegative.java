package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.test.rest.enums.Category;
import org.test.rest.model.Book;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateBookTestNegative extends BooksStoreTestBase {

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testCreate(Book book) {
        testClient.create(book).
                checkStatusCode(400);
    }
}

