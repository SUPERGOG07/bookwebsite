package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    String name;
    String ptuUrl;
    String txtUrl;
    String sumIntro;
    String sort;
}
