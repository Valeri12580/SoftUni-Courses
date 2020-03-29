package softuni.exam.config;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter  extends XmlAdapter<String, LocalDateTime> {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v,DTF);
    }

    public String marshal(LocalDateTime v) throws Exception {

        return v.toString();
    }
}
