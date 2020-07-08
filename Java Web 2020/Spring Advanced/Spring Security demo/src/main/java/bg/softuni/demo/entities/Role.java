package bg.softuni.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {
    private String role;
    @Override
    public String getAuthority() {
        return this.getRole();
    }
}
