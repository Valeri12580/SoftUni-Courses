package alararestaurant.domain.dtos.importDtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImportItemDto {

    @Expose
    @Size(min = 3,max = 30)
    private String name;

    @Expose
    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    private BigDecimal price;

    @Expose
    @NotNull
    @Size(min = 3,max = 30)
    private String category;
}
