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

    private static BookResponce createError400(){
        return new BookResponce().setStatus(400).
                setError("Bad Request").
                setPath("/rest-api/books");
    }
}
