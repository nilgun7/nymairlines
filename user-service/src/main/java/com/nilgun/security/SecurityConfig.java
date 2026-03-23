package com.nilgun.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // REST API mimarisinde CSRF koruması genellikle devre dışı bırakılır.
                .csrf(AbstractHttpConfigurer::disable)

                // İstek bazlı yetkilendirme kuralları
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/v1/users/register",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/swagger-resources/**",
                                "/webjars/**"
                        ).permitAll() // Kayıt endpoint'ine herkes erişebilir
                        .anyRequest().authenticated() // Diğer tüm isteklere kimlik doğrulaması şartı
                )

                // Mikroservislerde oturum (Session) yönetimi Stateless (durumsuz) olmalıdır.
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }

    /**
     * UserService içinde enjekte edilen PasswordEncoder bean'i burada tanımlanır.
     * Bu sayede şifreler BCrypt algoritması ile güvenli şekilde hash'lenir.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}