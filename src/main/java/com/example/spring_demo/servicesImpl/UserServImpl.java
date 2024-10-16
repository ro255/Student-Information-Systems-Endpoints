package com.example.spring_demo.servicesImpl;
import com.example.spring_demo.Dto.UsersRequestDto;
import com.example.spring_demo.models.StudentsDetails;
import com.example.spring_demo.models.Users;
import com.example.spring_demo.responses.LoginResponse;
import com.example.spring_demo.responses.RegisterResponse;
import com.example.spring_demo.respositories.UsersRepository;
import com.example.spring_demo.services.UserServices;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServImpl implements UserServices {

  private static final org.apache.commons.logging.Log log = LogFactory.getLog(UserServImpl.class);
  @Autowired
  private UsersRepository usersRepository;

  @Override
  public RegisterResponse<UsersRequestDto> register(UsersRequestDto users) {

    Users user = new Users();
    user.setUserId(user.getUserId());
    user.setName(users.getName());
    user.setPassword(users.getPassword());
    user.setEmail(users.getEmail());

    usersRepository.save(user);

    return new RegisterResponse<>("User registered", users);
  }

  @Override
  public LoginResponse<UsersRequestDto> login(UsersRequestDto user) {

    return new LoginResponse<>("Login successfully",user);

  }

}
