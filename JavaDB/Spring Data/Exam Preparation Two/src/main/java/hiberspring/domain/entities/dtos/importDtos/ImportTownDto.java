package hiberspring.domain.entities.dtos.importDtos;


import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ImportTownDto {


    @Expose
    private String name;

    @Expose
    private int population;
}
