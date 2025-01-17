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

import com.base.entity.Addresses;
import com.base.service.AddressService;

@RestController
@CrossOrigin("*")
public class AddressController {
	
	
	@Autowired
	private AddressService addressService;
	
	

	
	// lấy tất cả địa chỉ
	@GetMapping("/getall/address")
	public ResponseEntity<List<Addresses>> getAll(){
		List<Addresses> listAdd = addressService.findAll();
		return ResponseEntity.ok(listAdd);
	}
	
	
	// lấy thông tin địa chỉ
	@GetMapping("getone/address/{address_id}")
	public ResponseEntity<Addresses> getOne(@PathVariable Integer address_id){
		if (!addressService.existsById(address_id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // trả về lỗi không tìm thấy nếu không tồn tại
		}
		Addresses address_one =addressService.getOne(address_id);
		return ResponseEntity.ok(address_one);
	}
	
	
	
	// thêm mới địa chỉ
	@PostMapping("/create/address")
	public ResponseEntity<Addresses> createAddress(@RequestBody Addresses address){
		// Kiểm tra nếu địa chỉ đã tồn tại
	    if (addressService.existsById(address.getAddress_id())) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Trả về lỗi 409 nếu địa chỉ đã tồn tại
	    }
		addressService.save(address);
		
		return ResponseEntity.ok(address);
	}
	
	
	
	// cập nhật địa chỉ
	@PutMapping("/update/addresss/{address_id}")
	public ResponseEntity<Addresses> updateAddress(@RequestBody Addresses address, @PathVariable Integer address_id){
		
		Addresses address_new = null; // Khai báo biến bên ngoài khối if

	    if (addressService.existsById(address_id)) {
	        address_new = addressService.getOne(address_id);

	        // Cập nhật thông tin từ đối tượng request
	        address_new.setAddress_line1(address.getAddress_line1());
	        address_new.setAddress_line2(address.getAddress_line2());
	        address_new.setCity(address.getCity());
	        address_new.setState(address.getState());
	        address_new.setPost_code(address.getPost_code());
	        address_new.setCountry(address.getCountry());
	        address_new.set_default(address.is_default());
	        address_new.setUpdateAt(LocalDate.now()); // Cập nhật thời gian sửa đổi

	        addressService.save(address_new); // Lưu đối tượng đã cập nhật
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Trả về 404 nếu không tìm thấy địa chỉ
	    }

	    return ResponseEntity.ok(address_new); // Trả về đối tượng đã được cập nhật
		
	}
	
	
	
	// xóa địa chỉ
	@DeleteMapping("/delete/address/{address_id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable Integer address_id){
		if (addressService.existsById(address_id)) {
	        addressService.deleteById(address_id);
	        return ResponseEntity.noContent().build(); // Trả về mã trạng thái 204 (No Content) nếu xóa thành công
	    } else {
	        return ResponseEntity.notFound().build(); // Trả về mã trạng thái 404 nếu không tìm thấy địa chỉ
	    }
	}
}
