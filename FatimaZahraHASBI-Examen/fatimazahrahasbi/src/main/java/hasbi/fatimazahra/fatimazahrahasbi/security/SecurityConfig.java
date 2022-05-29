//package hasbi.fatimazahra.fatimazahrahasbi.security;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@AllArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private DataSource dataSource;
//    PasswordEncoder passwordEncoder;
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
//                .authoritiesByUsernameQuery("select username as principal, role from users_roles where username=?")
//                .rolePrefix("ROLE_")
//                .passwordEncoder(passwordEncoder);
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin();
//        http.authorizeRequests().antMatchers("/").permitAll();
//        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
//        http.authorizeRequests().antMatchers("/roleinvite/**").hasAuthority("ROLE_INVITE");
//        http.authorizeRequests().antMatchers("/rolemoderateur/**").hasAuthority("ROLE_MODERATEUR");
//        http.authorizeRequests().antMatchers("/roleconferencier/**").hasAuthority("ROLE_CONFERENCIER");
//        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
//        http.authorizeRequests().anyRequest().authenticated();
//        http.exceptionHandling().accessDeniedPage("/403");
//    }
//
//}
