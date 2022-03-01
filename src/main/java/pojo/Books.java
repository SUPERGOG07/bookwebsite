package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    String bookName;
    String ptUrl;
    String sumIntro;
    String sort;
    String author;
    String onCheck;
}
