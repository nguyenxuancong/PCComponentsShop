package com.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.entity.Users;
import com.base.service.UserService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    // Lấy tất cả người dùng
    @GetMapping("/getall/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> usersList = userService.findAll();
        return ResponseEntity.ok(usersList);
    }

    // Lấy thông tin người dùng theo ID
    @GetMapping("/get/user/{user_id}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer user_id) {
        if (!userService.existsById(user_id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Nếu không tìm thấy người dùng
        }
        Users user = userService.getOne(user_id);
        return ResponseEntity.ok(user);
    }

    // Tạo mới người dùng
    @PostMapping("/create/user")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        // Kiểm tra nếu người dùng đã tồn tại
        if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Trả về lỗi 409 nếu username đã tồn tại
        }

        userService.save(user); // Lưu người dùng
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // Cập nhật thông tin người dùng
    @PutMapping("/update/user/{user_id}")
    public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable Integer user_id) {
        Users existingUser = userService.getOne(user_id);

        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Nếu không tìm thấy người dùng
        }

        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setUpdateAt(user.getUpdateAt()); // Cập nhật ngày sửa đổi

        userService.save(existingUser); // Lưu lại thông tin người dùng đã sửa
        return ResponseEntity.ok(existingUser); // Trả về người dùng đã cập nhật
    }

    // Xóa người dùng theo ID
    @DeleteMapping("/delete/user/{user_id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer user_id) {
        if (!userService.existsById(user_id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Nếu không tìm thấy người dùng
        }
        userService.deleteById(user_id); // Xóa người dùng
        return ResponseEntity.noContent().build(); // Trả về mã trạng thái 204 nếu xóa thành công
    }
}
