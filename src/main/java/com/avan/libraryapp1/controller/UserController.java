package com.avan.libraryapp1.controller;
import org.springframework.http.HttpStatus;
import com.avan.libraryapp1.dto.UserDTO;
import com.avan.libraryapp1.model.User;
import com.avan.libraryapp1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
      
      List<UserDTO> userDTOs = userService.getAllUsers().stream()
              .map(this::convertEntityToDto)
              .toList();

      return ResponseEntity.ok(userDTOs);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
      return userService.getUserById(id)
              .map(user -> ResponseEntity.ok(convertEntityToDto(user)))
              .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = convertDtoToEntity(userDTO);
        User savedUser = userService.saveUser(user);
        UserDTO savedUserDTO = convertEntityToDto(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO updatedUserDTO) {
        User updatedUser = convertDtoToEntity(updatedUserDTO);
        updatedUser.setId(id);
        User savedUser = userService.saveUser(updatedUser);
        UserDTO savedUserDTO = convertEntityToDto(savedUser);
        return ResponseEntity.ok(savedUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    private User convertDtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        return user;
    }

    private UserDTO convertEntityToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}