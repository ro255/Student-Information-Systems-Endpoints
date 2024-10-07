package com.example.spring_demo.conntroller;
import com.example.spring_demo.Dto.UsersRequestDto;
import com.example.spring_demo.responses.RegisterResponse;
import com.example.spring_demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "*")

public class UserController {

  private final UserServices userServices;

  @Autowired
  public UserController(UserServices userServices, AuthenticationManager authenticationManager) {
    this.userServices = userServices;
  }

  @PostMapping(path="/register")
  public RegisterResponse<UsersRequestDto> registerUser(@RequestBody UsersRequestDto usersRequestDto) {
  return userServices.register(usersRequestDto);

  }

}
