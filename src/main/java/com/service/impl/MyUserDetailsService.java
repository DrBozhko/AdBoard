package com.service.impl;

import com.domain.Author;
import com.domain.Role;
import com.repository.AuthorRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    AuthorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Author author = repository.findByName(userName);
        List<GrantedAuthority> authorities = getUserAuthority(author.getRoles());
        return buildUserForAuthentication(author, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());

    }

    private UserDetails buildUserForAuthentication(Author author, List<GrantedAuthority> authorities) {
        return new User(author.getName(), author.getPassword(),
                author.isActive(), true, true, true, authorities);
    }
}
