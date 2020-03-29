package softuni.exam.models.dtos.importDtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportCarDto {

    @Expose
    private  String make;

    @Expose
    private String model;

    @Expose
    private long kilometers;

    @Expose
    private  String registeredOn;
}
