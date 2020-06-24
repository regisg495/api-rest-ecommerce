package com.ecommercerest.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationTokenProvider authenticationTokenProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/usuarios/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/usuarios/permissoes/editar/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/usuarios/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/usuarios/editar/**").hasAnyAuthority("ADMIN", "DBA", "USER")
                .antMatchers(HttpMethod.POST, "/logar/**", "/usuarios/cadastrar").permitAll()
                .antMatchers(HttpMethod.GET, "/grupos/**", "/subgrupos/**", "/produtos/**", "/clientes/**", "/avaliacoes/**").permitAll()
                .antMatchers(HttpMethod.POST, "/grupos/**", "/subgrupos/**", "/produtos/**").hasAnyAuthority("ADMIN", "DBA", "USER")
                .antMatchers(HttpMethod.PUT, "/grupos/**", "/subgrupos/**", "/produtos/**").hasAnyAuthority("ADMIN", "DBA", "USER")
                .antMatchers(HttpMethod.DELETE, "/grupos/**", "/subgrupos/**", "/produtos/**").hasAnyAuthority("DBA", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new AuthenticationTokenFilter(this.authenticationTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**");
    }
}
