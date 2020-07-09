package bg.softuni.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().csrfTokenRepository(csrfTokenRepository()).and().authorizeRequests().antMatchers("/index","/users/login","/users/register").anonymous()
        .antMatchers("/admin").hasAuthority("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/users/login")
        .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/home")
        .failureForwardUrl("/login").and().logout().logoutUrl("/users/logout").logoutSuccessUrl("/index");
    }

    private CsrfTokenRepository csrfTokenRepository(){
        HttpSessionCsrfTokenRepository repo=new HttpSessionCsrfTokenRepository();
        repo.setSessionAttributeName("_csrf");

        return repo;
    }
}
