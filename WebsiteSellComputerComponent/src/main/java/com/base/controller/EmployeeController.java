package com.base.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.entity.Employees;
import com.base.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Lấy tất cả nhân viên
    @GetMapping("/getall/employee")
    public ResponseEntity<List<Employees>> getAll() {
        List<Employees> listEmployees = employeeService.findAll();
        return ResponseEntity.ok(listEmployees);
    }

    // Lấy thông tin nhân viên theo ID
    @GetMapping("/getone/employee/{employee_id}")
    public ResponseEntity<Employees> getOne(@PathVariable Integer employee_id) {
        if (!employeeService.existsById(employee_id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Trả về lỗi 404 nếu không tìm thấy
        }
        Employees employee = employeeService.getOne(employee_id);
        return ResponseEntity.ok(employee);
    }

    // Tạo mới nhân viên
    @PostMapping("/create/employee")
    public ResponseEntity<Employees> createEmployee(@RequestBody Employees employee) {
        // Kiểm tra nếu nhân viên đã tồn tại
        if (employeeService.existsById(employee.getEmployee_id())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Trả về lỗi 409 nếu nhân viên đã tồn tại
        }
        employee.setCreateAt(LocalDate.now());
        employee.setUpdateAt(LocalDate.now());
        employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    // Cập nhật thông tin nhân viên
    @PutMapping("/update/employee/{employee_id}")
    public ResponseEntity<Employees> updateEmployee(@RequestBody Employees employee, @PathVariable Integer employee_id) {
        Employees existingEmployee = null;

        if (employeeService.existsById(employee_id)) {
            existingEmployee = employeeService.getOne(employee_id);

            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setGender(employee.isGender());
            existingEmployee.setPhoneNumber(employee.getPhoneNumber());
            existingEmployee.setDateOfBirth(employee.getDateOfBirth());
            existingEmployee.setImageEmployee(employee.getImageEmployee());
            existingEmployee.setRole(employee.getRole());
            existingEmployee.setUpdateAt(LocalDate.now()); // Cập nhật ngày sửa đổi

            employeeService.save(existingEmployee); // Lưu lại nhân viên đã cập nhật
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Trả về 404 nếu không tìm thấy
        }

        return ResponseEntity.ok(existingEmployee); // Trả về nhân viên đã cập nhật
    }

    // Xóa nhân viên theo ID
    @DeleteMapping("/delete/employee/{employee_id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer employee_id) {
        if (employeeService.existsById(employee_id)) {
            employeeService.deleteById(employee_id);
            return ResponseEntity.noContent().build(); // Trả về mã trạng thái 204 nếu xóa thành công
        } else {
            return ResponseEntity.notFound().build(); // Trả về mã trạng thái 404 nếu không tìm thấy
        }
    }
}
