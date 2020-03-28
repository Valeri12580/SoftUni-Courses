package alararestaurant.domain.dtos.importDtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ImportEmployeeDto {

    @Expose
    @NotNull
    @Size(min = 3,max = 30)
    private String name;

    @NotNull
    @Expose
    @Min(value = 15)
    @Max(value = 80)
    private int age;

    @NotNull
    @Expose
    @Size(min = 1)
    @Size(max=30)
    private String position;
}
