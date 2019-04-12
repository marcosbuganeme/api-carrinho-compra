package api.carrinho.compra.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder password = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
			.anyRequest().authenticated()
			    .and()
			.httpBasic()
			    .and()
			.csrf().disable();

    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        final User.UserBuilder userBuilder = User
    										.builder()
    										.passwordEncoder(password::encode);

        UserDetails user = userBuilder
                            .username("user")
                            .password("user")
                            .roles("USER")
                            .build();

        UserDetails admin = userBuilder
                                .username("admin")
                                .password("admin")
                                .roles("USER","ADMIN")
                                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}