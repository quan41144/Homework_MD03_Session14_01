package ra.hwss1301.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.hwss1301.model.dto.request.LoginRequest;
import ra.hwss1301.model.dto.request.RegisterRequest;
import ra.hwss1301.model.dto.response.ApiDataResponse;
import ra.hwss1301.model.dto.response.AuthResponse;
import ra.hwss1301.model.entity.User;
import ra.hwss1301.security.jwt.JwtProvider;
import ra.hwss1301.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    @PostMapping("/test")
    public String test() {
        return "Đăng nhập thành công";
    }
    @PostMapping("/register")
    public ResponseEntity<ApiDataResponse<User>> register(@Valid @RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Tạo người dùng mới thành công!",
                userService.registerUser(registerRequest),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        String role = authentication.getAuthorities().stream()
                .findFirst()
                .map(a -> a.getAuthority())
                .orElse("user");
        String username = loginRequest.getUsername();
        String token = jwtProvider.generateToken(username, role);
        return new ResponseEntity<>(new AuthResponse(
                username,
                role,
                token
        ), HttpStatus.OK);
    }
}
