package com.example.spring_demo.conntroller;
import com.example.spring_demo.Dto.UsersRequestDto;
import com.example.spring_demo.responses.RegisterResponse;
import com.example.spring_demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")

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

//  @PostMapping(path="/login")
//  public String loginUser(@Validated @RequestBody UsersRequestDto usersRequestDto) {
//    UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(loginUser.getEmail(),loginUser.getPassword());
//    Authentication authentication=authenticationManager.authenticate(authenticationToken);
//
//    if(authentication.isAuthenticated()){
//      return  "Login Successfully";
//    } else {
//      return "Invalid email or password";
//    }

//    return userServices.login(usersRequestDto);
//  }

}
