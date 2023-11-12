package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.test.rest.enums.Category;
import org.test.rest.model.Book;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateBookTestNegative extends BooksStoreTestBase {

    @Test(dataProvider = "createBooksNegative")
    public void testCreate(Book book) {
        testClient.create(book).
                checkStatusCode(400);
    }

    @DataProvider
    public Object[][] createBooksNegative() {
        return new Object[][] {
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(2))},
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(257))},
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(2))},
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(513))},
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(2))},
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(101))},
                { Book.defaultOf().setPrice(-1)},
                { Book.defaultOf().setCount(-1)},
                { Book.defaultOf().setCategory(Category.Unknown)},
        };
    }
}

