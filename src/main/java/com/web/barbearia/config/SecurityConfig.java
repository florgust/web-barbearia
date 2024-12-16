// package com.web.barbearia.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .antMatchers("/login", "/css/**", "/js/**", "/images/**").permitAll()  // Permite acesso livre à página de login e recursos estáticos
//                 .antMatchers("/barbearia").authenticated() // Exige autenticação para acessar /barbearia
//                 .and()
//             .formLogin()
//                 .loginPage("/login")  // Defina a página de login personalizada
//                 .permitAll()  // Permite que todos acessem a página de login
//                 .loginProcessingUrl("/login") // URL de processamento do login
//                 .defaultSuccessUrl("/barbearia", true)  // Redireciona para /barbearia após login bem-sucedido
//                 .failureUrl("/login?error=true") // Redireciona para /login em caso de falha de login
//                 .and()
//             .logout()
//                 .logoutUrl("/logout")
//                 .logoutSuccessUrl("/login?logout=true") // Redireciona para a página de login após logout
//                 .permitAll();
//     }

//     @Bean
//     @Override
//     public UserDetailsService userDetailsService() {
//         // Definindo um usuário de exemplo para login
//         InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//         manager.createUser(User.withUsername("user")
//                 .password("{noop}password") // {noop} é usado para senha sem criptografia (apenas para testes)
//                 .roles("USER")
//                 .build());
//         return manager;
//     }
// }
