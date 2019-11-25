package bzh.muzuliou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import bzh.muzuliou.config.JwtToken;
import bzh.muzuliou.entity.JwtRequest;
import bzh.muzuliou.service.JwtUserDetailsService;

import org.springframework.security.authentication.AuthenticationManager;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

    	  System.out.println("auth :" +authenticationRequest.getUsername());
    
      authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
 
        final UserDetails userDetails = jwtUserDetailsService

                .loadUserByUsername(authenticationRequest.getUsername());
  	  System.out.println("userDetails :" +userDetails.toString()); 
      //  UserInfo user = jwtUserDetailsService.getUserByUsername(authenticationRequest.getUsername());
      //  user.setPassword("");
      
      
        final String token = jwtToken.generateToken(userDetails);
    //    user.setToken("Bearer "+ token);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer "+token);
        return ResponseEntity.ok()
        		.headers(headers).body(userDetails);

    }

    private void authenticate(String username, String password) throws Exception {

        try {
  System.out.println("authenticationManager");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {

            throw new Exception("USER_DISABLED", e);

        } catch (BadCredentialsException e) {

            throw new Exception("INVALID_CREDENTIALS", e);

        } catch ( Exception e) {
        	 throw new Exception("Unknow error", e);
        }

    }

}
