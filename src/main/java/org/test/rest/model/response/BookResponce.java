package org.test.rest.model.response;

import lombok.*;
import org.test.rest.model.Book;

import java.time.OffsetDateTime;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookResponce extends Book {

    private Integer id;
    private OffsetDateTime lastUpdated;
}
