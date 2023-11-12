package tests.update;

import org.test.rest.model.Book;
import org.test.rest.model.response.BookResponce;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.BookData;
import tests.BooksStoreTestBase;

public class UpdateBookNegativeTest extends BooksStoreTestBase {
    private Integer id;

    @BeforeClass
    public void setUp(){
        id=testClient.create(Book.defaultOf()).
                checkStatusCode(201).getId();
    }
    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testUpdateBook(Book book){
        testClient.update(id, book).
                checkStatusCode(400).
                checkErrorResponse(BookResponce.updateError400(id));

        testClient.read(id).
                checkStatusCode(200).
                checkId(id).checkLastUpdated().
                checkBook(Book.defaultOf());
    }

}
