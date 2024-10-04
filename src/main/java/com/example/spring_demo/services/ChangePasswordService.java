package com.example.spring_demo.services;
import com.example.spring_demo.conntroller.ChangePasswordRequest;
import com.example.spring_demo.models.Users;
import com.example.spring_demo.respositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.Principal;


@Service
@RequiredArgsConstructor
public class ChangePasswordService {

  private final PasswordEncoder passwordEncoder;
  private final UsersRepository usersRepository;

  public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
    var user= (Users)((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

    //check if the old password is correct
    if(!passwordEncoder.matches(request.getOldPassword(), user.getPassword())){
      throw new BadCredentialsException("Old password does not match");
    }

    //check if the two new password are the same
    if(!request.getNewPassword().equals(request.getConfirmPassword())) {
      throw new BadCredentialsException("Passwords does not match");
    }

    //update the password
    user.setPassword(passwordEncoder.encode(request.getNewPassword()));

    //save the user
    usersRepository.save(user);

  }
}
