package org.test.rest.model.response;

import lombok.*;
import lombok.experimental.Accessors;
import org.test.rest.model.Book;

import java.time.OffsetDateTime;
@Accessors(chain = true)
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookResponce extends Book {

    private Integer id;
    private OffsetDateTime lastUpdated;

    @EqualsAndHashCode.Exclude
    private OffsetDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

    public static BookResponce error400(String path){
        return new BookResponce().setStatus(400).
                setError("Bad Request").
                setPath(path);
    }

    public static BookResponce createError400(){
        return error400("/rest-api/books");
    }
    public static BookResponce updateError400(Integer id){
        return error400(String.format("/rest-api/books/%s", id));
    }
}
