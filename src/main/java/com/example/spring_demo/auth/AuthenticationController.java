package com.example.spring_demo.auth;
import com.example.spring_demo.models.Users;
import com.example.spring_demo.respositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class AuthenticationController {
  private final AuthenticationService service;
  private final UsersRepository usersRepository;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
    @RequestBody RegisterRequest request
    ) {
     return  ResponseEntity.ok(service.register(request));

  }

  @GetMapping("/users")
  public ResponseEntity<List<Users>> getAllUsers() {
    List<Users> users=usersRepository.findAll();
    if(users.isEmpty()){
      throw new NoSuchElementException("No users found");
    }
    return ResponseEntity.ok(users);
  }

  @PutMapping("/register/{userId}")
  public ResponseEntity<AuthenticationResponse> updateUser(@PathVariable Long userId, @RequestBody RegisterRequest request) {
    Users user = usersRepository.findById(userId).orElseThrow(() ->
      new NoSuchElementException("User not found with ID:"+userId));
       user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
          usersRepository.save(user);
        return ResponseEntity.ok(service.updateUser(request));
  }

  @DeleteMapping("/register/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
    Users user = usersRepository.findById(userId).orElseThrow(()->
      new NoSuchElementException("User not found with ID:"+userId));
    usersRepository.delete(user);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
    return  ResponseEntity.ok(service.login(request));

  }
}
