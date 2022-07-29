package com.example.springbasicproject.config.auth;

import com.example.springbasicproject.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // spring security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 사용하려고 해당 옵션 disable
                .and()
                    .authorizeHttpRequests()    //url별 권한 관리
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()// 권한 관리 대상 지정 전체열람
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())                          // user권한 가진사람만 열수있음
                    .anyRequest().authenticated() // 나머지들 authenticated 추가하여 모두 인증된 사람에게만 허용 >> 로그인 해야 가능
                .and()
                     .logout().
                        logoutSuccessUrl("/")  //로그아웃 시 주소
                .and()
                    .oauth2Login() // 로그인시 진입
                       .userInfoEndpoint()// 로그인 성공 후 사용자 정보 가져올때의 설정들
                            .userService(customOAuth2UserService); //성공시 해야하는 일들 userservice 인터페이스의 구현체 등록
    }

}
