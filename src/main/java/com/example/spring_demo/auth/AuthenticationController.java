package com.example.spring_demo.auth;

import com.example.spring_demo.models.Users;
import com.example.spring_demo.responses.ApiResponse;
import com.example.spring_demo.respositories.UsersRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class AuthenticationController {

  private final AuthenticationService service;
  private final UsersRepository usersRepository;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid RegisterRequest request, BindingResult bindingResult) {
//    if (bindingResult.hasErrors()) {
//      return ResponseEntity.badRequest().body("Validation failed");
//    }

    try {
      AuthenticationResponse response= service.register(request) ;
      ApiResponse<AuthenticationResponse> apiResponse= new ApiResponse<>(
        HttpStatus.OK.value(),
        "User registered Successfully",
        response
      );

      return  ResponseEntity.ok(apiResponse.getData());
    } catch (Exception e) {
      ApiResponse<AuthenticationResponse> apiResponse= new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "Failure to register user",
        null
      );

      return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }

  }



  @GetMapping("/users")
  public ResponseEntity<List<Users>> getAllUsers() {
    List<Users> users=usersRepository.findAll();
    if(users.isEmpty()) {
      throw new NoSuchElementException("No users found");
    }

  try {
  ApiResponse<List<Users>> apiResponse= new ApiResponse<>(
    HttpStatus.OK.value(),
    "Users retrieved successfully",
    users
  );

  return ResponseEntity.ok(apiResponse.getData());
  }
  catch (Exception e) {
  ApiResponse<List<Users>> apiResponse= new ApiResponse<>(
    HttpStatus.BAD_REQUEST.value(),
    "Users not found",
    null
  );

  return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }

  }


  @PutMapping("/register/{userId}")
  public ResponseEntity<AuthenticationResponse> updateUser(@PathVariable Long userId, @RequestBody RegisterRequest request) {
    try {
    Users user = usersRepository.findById(userId).orElseThrow(() ->
      new NoSuchElementException("User not found with ID:"+userId));
       user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
          usersRepository.save(user);

            AuthenticationResponse response= service.updateUser(request);
            ApiResponse<AuthenticationResponse> apiResponse= new ApiResponse<>(
              HttpStatus.OK.value(),
              "User updated successfully",
              response
            );

            return ResponseEntity.ok(apiResponse.getData());
          } catch (Exception e) {
            ApiResponse<AuthenticationResponse> apiResponse= new ApiResponse<>(
              HttpStatus.BAD_REQUEST.value(),
              "Fail to update user",
              null
            );

            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
          }
  }


  @DeleteMapping("/register/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {

    try{
    Users user = usersRepository.findById(userId).orElseThrow(()->
      new NoSuchElementException("User not found with ID:"+userId));
    usersRepository.delete(user);


      ApiResponse<Void> apiResponse= new ApiResponse<>(
        HttpStatus.OK.value(),
        "User deleted successfully",
        null
      );
      return ResponseEntity.ok(apiResponse.getData());
    } catch (Exception e) {
      ApiResponse<Void> apiResponse= new ApiResponse<>(
        HttpStatus.BAD_REQUEST.value(),
        "User not found with ID:"+userId,
        null
      );
      return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
    }
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {

   try{
     AuthenticationResponse response= service.login(request);
     ApiResponse<AuthenticationResponse> apiResponse= new ApiResponse<>(
       HttpStatus.OK.value(),
       "User Login successfully",
       response
     );
     return  ResponseEntity.ok(apiResponse.getData());
   } catch (Exception e) {
     ApiResponse<AuthenticationResponse> apiResponse= new ApiResponse<>(
       HttpStatus.BAD_REQUEST.value(),
       "Incorrect email or password",
       null
     );
     return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse.getData());
   }

  }
}
