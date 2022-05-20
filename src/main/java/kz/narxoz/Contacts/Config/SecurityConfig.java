package kz.narxoz.Contacts.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

    @Configuration
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/contacts").hasAnyRole("ADMIN", "USER", "rifat")
                    .antMatchers(HttpMethod.GET, "/contacts/new", "/contacts/delete/{id}", "/contacts/update/{id}").hasAnyRole("ADMIN", "rifat")
                    .antMatchers(HttpMethod.POST, "/sss").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/deleteitem").hasRole("rifat")
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin()
                    .defaultSuccessUrl("/success");
        }

        @Bean
        @Override
        protected UserDetailsService userDetailsService() {
            return new InMemoryUserDetailsManager(
                    User.builder()
                            .username("admin")

                            .password(passwordEncoder().encode("admin"))
                            .roles("ADMIN")
                            .build(),
                    User.builder()
                            .username("user")
                            .password(passwordEncoder().encode("user"))
                            .roles("USER")
                            .build(),

                    User.builder()
                            .username("rifat")
                            .password(passwordEncoder().encode("rifat"))
                            .roles("rifat")
                            .build()
            );
        }

        @Bean
        protected PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder(12);}
}
