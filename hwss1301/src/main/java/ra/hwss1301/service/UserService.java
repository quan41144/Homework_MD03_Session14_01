package ra.hwss1301.service;

import ra.hwss1301.model.dto.request.LoginRequest;
import ra.hwss1301.model.dto.request.RegisterRequest;
import ra.hwss1301.model.entity.User;

public interface UserService {
    User registerUser(RegisterRequest registerRequest);
    User login(LoginRequest loginRequest);
}
