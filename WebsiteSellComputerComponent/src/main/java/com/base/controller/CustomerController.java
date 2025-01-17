package com.base.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.base.entity.Customers;
import com.base.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Lấy danh sách tất cả khách hàng
    @GetMapping("/getall/customer")
    public ResponseEntity<List<Customers>> getAll() {
        List<Customers> listCus = customerService.findAll();
        return ResponseEntity.ok(listCus);
    }

    // Lấy thông tin khách hàng theo ID
    @GetMapping("/getone/customer/{customer_id}")
    public ResponseEntity<Customers> getOne(@PathVariable Integer customer_id) {
        if (!customerService.existsById(customer_id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Không tìm thấy
        }
        Customers customer = customerService.getOne(customer_id);
        return ResponseEntity.ok(customer);
    }

    // Tạo khách hàng mới
    @PostMapping("/create/customer")
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customer) {
        // Kiểm tra nếu khách hàng đã tồn tại
        if (customerService.existsById(customer.getCustomer_id())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Trả về lỗi 409
        }
        customerService.save(customer); // Lưu khách hàng mới
        return ResponseEntity.ok(customer);
    }

    // Cập nhật thông tin khách hàng
    @PutMapping("/update/customer/{customer_id}")
    public ResponseEntity<Customers> updateCustomer(@RequestBody Customers customer, @PathVariable Integer customer_id) {
        Customers customerNew = null;

        if (customerService.existsById(customer_id)) {
            customerNew = customerService.getOne(customer_id);

            customerNew.setFirstName(customer.getFirstName());
            customerNew.setLastName(customer.getLastName());
            customerNew.setGender(customer.isGender());
            customerNew.setPhoneNumber(customer.getPhoneNumber());
            customerNew.setDateOfBirth(customer.getDateOfBirth());
            customerNew.setUpdateAt(LocalDate.now());

            customerService.save(customerNew);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(customerNew);
    }

    // Xóa khách hàng theo ID
    @DeleteMapping("/delete/customer/{customer_id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customer_id) {
        if (customerService.existsById(customer_id)) {
            customerService.deleteById(customer_id);
            return ResponseEntity.noContent().build(); // Xóa thành công
        } else {
            return ResponseEntity.notFound().build(); // Không tìm thấy khách hàng
        }
    }
}
