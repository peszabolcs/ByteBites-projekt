//package hu.university.etelprojekt.etelprojekt.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
////@EnableWebSecurity
////TODO teljesen kivettem a security configurációt a tesztelés idejére, csak a baj volt vele, majd ha szükségesnek
//// látod visszateheted, ha meg tudod oldani hogy az oldal továbbra is helyesen működjön
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/cart").authenticated() // Hitelesített felhasználók számára
//                        .requestMatchers("/login", "/register").permitAll() // Nyilvános oldalak
//                        .anyRequest().permitAll()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login").permitAll()
//                ).exceptionHandling(exception -> exception
//                        .authenticationEntryPoint((request, response, authException) -> {
//                            response.setContentType("application/json");
//                            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                            response.getWriter().write("{\"error\": \"Bejelentkezés szükséges.\"}");
//                        })
//                );
//
//        http.csrf(AbstractHttpConfigurer::disable);
//
//        return http.build();
//    }
//
////    @Bean
////    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
////        UserDetails user = User.builder()
////                .username("testuser")
////                .password(passwordEncoder.encode("password"))
////                .roles("USER")
////                .build();
////        return new InMemoryUserDetailsManager(user);
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//}
//
//
