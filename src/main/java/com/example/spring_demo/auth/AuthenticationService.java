package com.example.spring_demo.auth;

import com.example.spring_demo.models.Role;
import com.example.spring_demo.models.StudentsDetails;
import com.example.spring_demo.models.Users;
import com.example.spring_demo.responses.LoginResponse;
import com.example.spring_demo.responses.StudentDetailsResponse;
import com.example.spring_demo.responses.UserResponse;
import com.example.spring_demo.respositories.StudentDetailsRepository;
import com.example.spring_demo.respositories.UsersRepository;
import com.example.spring_demo.config.JwtServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.example.spring_demo.models.Users.*;

@Service
public class AuthenticationService {

  @Autowired
  private final UsersRepository usersRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtServices jwtServices;

  @Autowired
  private StudentDetailsRepository studentsDetailsRepository;

  @Transactional
  public void saveUser(Users user, StudentsDetails studentsDetails) {
    studentsDetailsRepository.save(studentsDetails);
    user.setStudentsDetails(studentsDetails);
    usersRepository.save(user);

  }

  @Autowired
  public AuthenticationService(UsersRepository usersRepository, PasswordEncoder passwordEncoder, JwtServices jwtServices, AuthenticationManager authenticationManager) {
    this.usersRepository = usersRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtServices = jwtServices;
    this.authenticationManager = authenticationManager;
  }

  private final AuthenticationManager authenticationManager;
//  public AuthenticationResponse register(RegisterRequest request) {
//
//    var user= builder()
//      .name(request.getName())
//      .email(request.getEmail())
//      .password(passwordEncoder.encode(request.getPassword()))
//      .role(Role.USER)
//      .build();
//
//
//    usersRepository.save(user);
//
//    StudentsDetails studentsDetails = new StudentsDetails();
//    studentsDetails.setUserId(user.getUserId());
//    studentsDetails.setRegistrationNumber("REG123");
//    studentsDetails.setProgramme("Computer Science");
//    studentsDetails.setMobileNo("255766040293");
//    studentsDetails.setGender("Male");
//    studentsDetails.setNationality("Tanzania");
//    studentsDetails.setDateOfBirth("1998-01-01");
//    studentsDetails.setProfile("profile.jpg");
//    studentsDetails.setDisability("None");
//    studentsDetails.setYearOfStudy("3");
//    studentsDetails.setFormIVIndex("S1234567");
//
//    System.out.println("user.getUserId()"+ user.getUserId());
//  studentsDetails.setUsers(user);
//
//// Save the student details
//    studentsDetailsRepository.save(studentsDetails);
//    var jwtToken=jwtServices.generateToken(user);
//    return AuthenticationResponse.builder()
//      .token(jwtToken)
//      .build();
//  }
public LoginResponse<AuthenticationResponse> register(RegisterRequest request) {

  // Build and save the user
  var user = Users.builder()
    .name(request.getName())
    .email(request.getEmail())
    .password(passwordEncoder.encode(request.getPassword()))
    .role(Role.USER)
    .build();

  usersRepository.save(user);

  // Build and save the student details
  StudentsDetails studentsDetails = new StudentsDetails();
  studentsDetails.setUserId(user.getUserId());
  studentsDetails.setRegistrationNumber("REG123");
  studentsDetails.setProgramme("Computer Science");
  studentsDetails.setMobileNo("255766040293");
  studentsDetails.setGender("Male");
  studentsDetails.setNationality("Tanzania");
  studentsDetails.setDateOfBirth("1998-01-01");
  studentsDetails.setProfile("profile.jpg");
  studentsDetails.setDisability("None");
  studentsDetails.setYearOfStudy("3");
  studentsDetails.setFormIVIndex("S1234567");
  studentsDetails.setUsers(user);

  studentsDetailsRepository.save(studentsDetails);

  // Generate JWT token
  var jwtToken = jwtServices.generateToken(user);

  // Build the response objects
  UserResponse userResponse = UserResponse.builder()
    .userId(user.getUserId())
    .name(user.getName())
    .email(user.getEmail())
    .role(user.getRole())
    .build();

  StudentDetailsResponse studentDetailsResponse = StudentDetailsResponse.builder()
    .registrationNumber(studentsDetails.getRegistrationNumber())
    .programme(studentsDetails.getProgramme())
    .mobileNo(studentsDetails.getMobileNo())
    .gender(studentsDetails.getGender())
    .nationality(studentsDetails.getNationality())
    .dateOfBirth(studentsDetails.getDateOfBirth())
    .profile(studentsDetails.getProfile())
    .disability(studentsDetails.getDisability())
    .yearOfStudy(studentsDetails.getYearOfStudy())
    .formIVIndex(studentsDetails.getFormIVIndex())
    .build();

  // Build AuthenticationResponse containing user and student details
  AuthenticationResponse authResponse = AuthenticationResponse.builder()
    .token(jwtToken)
    .message("Registration successful")
    .statusCode(201)
    .user(userResponse)
    .studentDetails(studentDetailsResponse)
    .build();

  // Wrap the AuthenticationResponse in a LoginResponse
  return new LoginResponse<>("200", "User registration successful", authResponse);
}

  public AuthenticationResponse login(LoginRequest request) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
      )
    );
    var user=usersRepository.findByEmail(request.getEmail()).orElseThrow();
    var jwtToken=jwtServices.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .build();
  }

  public AuthenticationResponse updateUser(RegisterRequest request) {
    var user= builder()
      .name(request.getName())
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      .role(Role.USER)
      .build();

    usersRepository.save(user);
    var jwtToken=jwtServices.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .build();

  }

}
