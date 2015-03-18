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
        .csrf().and()
        .formLogin() // form認証をする場合は、これを指定する
        .loginPage("/auth/login") // カスタムログインページを使う場合は、これを指定する。デフォルトは/login
        .usernameParameter("j_username") // ユーザ名フィールドの名前。デフォルトはusername
        .passwordParameter("j_password") // パスワードフィールドの名前。デフォルトはpassword
        .failureUrl("/auth/login?fail") // 失敗時の転送先URL。デフォルトは/login?error
        .and()
        .authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN") // /adminページで必要なロールの設定
        .and()
        .authorizeRequests()
        .antMatchers("/sec").hasRole("USER"); // /secページで必要なロールの設定
        
    }
}
