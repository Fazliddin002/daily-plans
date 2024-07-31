package uz.pdp.daily_plans_program_b.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.daily_plans_program_b.security.dto.LoginRequestDto;
import uz.pdp.daily_plans_program_b.security.dto.TokenDto;
import uz.pdp.daily_plans_program_b.security.service.JwtUtils;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    public final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginRequestDto loginRequestDto) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getPhone(), loginRequestDto.getPassword())
        );
        String accessToken = jwtUtils.generateToken((UserDetails) authenticate.getPrincipal());
        String refreshToken = jwtUtils.generateRefreshToken((UserDetails) authenticate.getPrincipal());
        return new TokenDto(accessToken, refreshToken);
    }
}
