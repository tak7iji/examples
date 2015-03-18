package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        
        auth.inMemoryAuthentication().withUser("user1").password("password1")
                .roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password("password2")
                .roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .httpBasic() // BASIC認証を行う場合は、これだけ指定する
        .and()
        .authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN") // /adminページで必要なロールの設定
        .and()
        .authorizeRequests()
        .antMatchers("/sec").hasRole("USER"); // /secページで必要なロールの設定
        
    }
}
