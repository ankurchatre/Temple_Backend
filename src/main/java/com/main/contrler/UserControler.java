package com.main.contrler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.main.entity.Temple;
import com.main.service.TempleService;
import com.main.upload.ImageUpload;


@RestController
@CrossOrigin (origins ="*")
public class UserControler {
	@Autowired
	TempleService service;
	@Autowired
	ImageUpload upload;
	

	@PostMapping("/temple")
	public Temple addData(@RequestBody Temple temple) {
		return service.addData(temple);
	}
	@GetMapping("/temple/{id}")
	public ResponseEntity<?>getSingleData(@PathVariable int id){
	 Temple temple=service.getTemple(id);
	 if (temple != null) {
		return ResponseEntity.ok(temple);
	}
	 return ResponseEntity.status(404).body("Invalid Id Please Inter Valid Id");
	}
	
	@GetMapping("/temple")
	public ResponseEntity<List<Temple>> getAllData() {
		List<Temple> data=service.getAllTemple();
		return ResponseEntity.ok(data);
	}
	@PutMapping("/temple/{id}")
	public ResponseEntity<?> editData(@PathVariable int id, @RequestBody Temple temple){
		Temple update=service.updat(id, temple);
		if (update!=null) {
			return ResponseEntity.ok(update);
		}
		return ResponseEntity.status(404).body("Inter Vallied id....");
	}
	@DeleteMapping("/temple/{id}")
	public ResponseEntity<List<Temple>> deletById(@PathVariable int id){
		service.deletById(id);
		List<Temple> temples=service.getAllTemple();
		return ResponseEntity.ok(temples);
	}
	@DeleteMapping("/temple")
	public ResponseEntity<List<Temple>> delet(){
		service.deletAll();
		List<Temple> temples=service.getAllTemple();
		return ResponseEntity.ok(temples);
	}
	
	@PostMapping("/temple/{id}/upload")
public ResponseEntity<?> addImg(@PathVariable int id, @RequestParam("image") MultipartFile file) {
    boolean isUploaded = upload.uploadFile(file);
    if (!isUploaded) {
        return ResponseEntity.status(500).body("Image not uploaded");
    }

    Temple temple = service.getTemple(id);
    if (temple == null) {
        return ResponseEntity.status(404).body("Temple not found");
    }

    String imgPath = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/uploads/")
            .path(file.getOriginalFilename())
            .toUriString();
    temple.setImageUrl(imgPath);

    Temple updatedTemple = service.addData(temple); // Consider renaming addData() to updateData() if it's for updates
    return ResponseEntity.ok(updatedTemple);
}

	

}
