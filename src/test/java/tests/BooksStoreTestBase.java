package tests;

import org.test.rest.client.TestClient;

public class BooksStoreTestBase {
    protected static TestClient testClient;
    static {
        testClient = new TestClient();
    }
}
