package com.controller;

import com.domain.Author;
import com.service.impl.AuthorServiceImpl;
import com.service.impl.MyUserDetailsService;
import jwt_proccesing.JwtRequest;
import jwt_proccesing.JwtResponse;
import jwt_proccesing.JwtTokenUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jwt")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class JwtAuthenticationController {
    AuthenticationManager authenticationManager;

    JwtTokenUtil jwtTokenUtil;

    MyUserDetailsService service;

    AuthorServiceImpl aService;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        final UserDetails userDetails = service.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/registration")
    public ResponseEntity.BodyBuilder registration(@RequestBody Author author) throws Exception {
        aService.save(author);

        return ResponseEntity.ok();
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            /*
             * Attempts to authenticate the passed {@link Authentication} object, returning a
             * fully populated <code>Authentication</code> object (including granted authorities)
             * if successful.
             * */

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
