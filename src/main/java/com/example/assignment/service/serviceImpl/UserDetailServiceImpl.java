package com.example.assignment.service.serviceImpl;

import com.example.assignment.domain.Member;
import com.example.assignment.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final MemberRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> user = userRepository.findById(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("해당 유저 없음");
        }

        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority("QUERY"));
        if(user.get().getRole().equals("admin"))
            auths.add(new SimpleGrantedAuthority("delete"));

        UserDetails ud = org.springframework.security.core.userdetails.User.builder()
                .username(user.get().getId())
                .password(user.get().getPw())
                .roles(user.get().getRole())
                .build();
        return ud;
    }
}
