package org.test.rest.model.response;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.test.rest.model.Book;
import org.testng.Assert;

public class BookValidatableResponse {

    private BookResponce model;
    private Response response;

    public BookValidatableResponse (Response response){
        this.response = response;
        if (response.asString().length() > 0) {
            model = response.as(BookResponce.class);
        }
    }

    public BookValidatableResponse checkStatusCode(int statusCode){
        response.then().statusCode(statusCode);
        return this;
    }

    public BookValidatableResponse checkIdNotNull(){
        response.then().body("id", Matchers.notNullValue());
        return this;
    }

    public BookValidatableResponse checkLastUpdated(){
        response.then().body("lastUpdated", Matchers.notNullValue());

        return this;
    }
    public BookValidatableResponse checkBook(Book expected){
        Assert.assertEquals(new Book(model), expected);

        return this;
    }

    public BookValidatableResponse checkId(Integer id){
        response.then().body("id", Matchers.equalTo(id));

        return this;
    }

public BookValidatableResponse checkErrorResponse(BookResponce expected){
        response.then().body("timestamp", Matchers.notNullValue());
        Assert.assertEquals(model, expected);

        return this;
}

    public Integer getId(){
        return response.jsonPath().getInt("id");
    }
}
