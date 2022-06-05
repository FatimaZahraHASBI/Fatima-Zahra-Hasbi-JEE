package com.example.tp8_etud_spring_mvc_jpa_security.sec;


import com.example.tp8_etud_spring_mvc_jpa_security.sec.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
//                .authoritiesByUsernameQuery("select username as principal, role from users_roles where username=?")
//                .rolePrefix("ROLE_")
//                .passwordEncoder(passwordEncoder);

        /*
        String encodedPWD=passwordEncoder.encode("1111");
        System.out.println(encodedPWD);
        auth.inMemoryAuthentication()
                .withUser("user1").password(encodedPWD).roles("USER")
                .and()
                .withUser("user2").password(passwordEncoder.encode("2222")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("3333")).roles("USER", "ADMIN");

         */
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin().loginPage("/auth");
        http.formLogin();
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/user/**").hasAuthority("USER");
        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
        http.authorizeRequests().antMatchers("/auth/**").permitAll();
//        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");
    }



}
