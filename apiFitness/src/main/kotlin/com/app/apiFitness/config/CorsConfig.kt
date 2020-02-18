package com.app.apiFitness.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.http.HttpMethod.OPTIONS
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter


@Order(0)
@Configuration
@EnableWebSecurity
@EnableResourceServer
class HttpSecurityConfig : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        // @formatter:off
        http
                .cors()
                .and()
                .requestMatchers()
                .antMatchers(OPTIONS)
                .antMatchers("/v2/api-docs").antMatchers("/swagger-ui.html", "/webjars/**", "/swagger-resources/**")
                .antMatchers("/management/**").antMatchers("/swagger-ui.html", "/webjars/**", "/swagger-resources/**")
                .and()
                .authorizeRequests()
                .antMatchers(OPTIONS, "/**").permitAll()
                .and().httpBasic()
        // @formatter:on
    }

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOrigin("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        source.registerCorsConfiguration("/**", config)

        return CorsFilter(source)
    }

}