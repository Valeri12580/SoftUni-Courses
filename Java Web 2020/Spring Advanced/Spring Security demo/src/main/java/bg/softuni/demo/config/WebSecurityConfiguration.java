package bg.softuni.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/index","/users/login","/users/register").anonymous()
                .anyRequest().authenticated().and().formLogin().loginPage("/users/login")
        .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/home")
        .failureForwardUrl("/login");
    }
}
