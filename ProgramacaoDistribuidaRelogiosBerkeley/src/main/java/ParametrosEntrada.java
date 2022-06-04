import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ParametrosEntrada {

    private Integer id;
    private String host;
    private String port;
    private LocalDateTime localDateTime;
    private Long milisegundos;
    private Long adelay;

}
