package alararestaurant.config;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDateTime> {
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v,dateFormat);
    }

    public String marshal(LocalDateTime v) throws Exception {
        return v.toString();
    }
}