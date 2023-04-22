package com.ums.university.management.system.Controller;

import com.ums.university.management.system.DTO.JWTRequestDTO;
import com.ums.university.management.system.DTO.JWTResponseDTO;
import com.ums.university.management.system.Helper.JWTUtil;
import com.ums.university.management.system.Service.Impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class JWTController {


    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JWTRequestDTO jwtRequest) throws Exception {
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmailId(),jwtRequest.getPassword()));
        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }

        //generate token
        UserDetails customUserDetails = customUserDetailsServiceImpl.loadUserByUsername(jwtRequest.getEmailId());

        String token = jwtUtil.generateToken(customUserDetails);

        //Create a class JWTResponse to send the token as json response.
        return ResponseEntity.ok(new JWTResponseDTO(token));
    }
}
