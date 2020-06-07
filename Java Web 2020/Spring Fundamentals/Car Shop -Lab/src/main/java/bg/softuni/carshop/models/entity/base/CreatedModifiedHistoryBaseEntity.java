package bg.softuni.carshop.models.entity.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class CreatedModifiedHistoryBaseEntity extends BaseEntity{

    @Column
    @CreationTimestamp
    private LocalDateTime created;


    @Column
    @UpdateTimestamp
    private LocalDateTime modified;
}
