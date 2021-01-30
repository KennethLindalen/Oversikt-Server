package dev.kennethlindalen.rkupongoversikt.Controller;

import dev.kennethlindalen.rkupongoversikt.Security.JWT.Models.JWTRequest;
import dev.kennethlindalen.rkupongoversikt.Security.JWT.Models.JWTResponse;
import dev.kennethlindalen.rkupongoversikt.Security.JWT.Utils.JWTTokenManager;
import dev.kennethlindalen.rkupongoversikt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticManager;

    @Autowired
    private JWTTokenManager jwtTokenManager;

    @PostMapping(value = "/login")
    public ResponseEntity<JWTResponse> createToken(@RequestBody JWTRequest req) throws Exception{
        try {
            authenticManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        } catch (DisabledException e){
            throw new Exception("Disabled User");
        }catch (BadCredentialsException e){
            throw new Exception("Invalid credentials");
        }
        final UserDetails userDetails = userService.loadUserByUsername(req.getUsername());
        final String JWTToken = jwtTokenManager.generateToken(userDetails);

        return ResponseEntity.ok(new JWTResponse(JWTToken));
    }

}
