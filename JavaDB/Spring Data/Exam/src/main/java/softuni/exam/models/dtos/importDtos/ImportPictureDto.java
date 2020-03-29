package softuni.exam.models.dtos.importDtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportPictureDto {
    @Expose
    private String name;

    @Expose
    private String dateAndTime;

    @Expose
    private int car;
}
