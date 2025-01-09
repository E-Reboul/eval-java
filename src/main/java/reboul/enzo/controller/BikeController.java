package reboul.enzo.controller;

import reboul.enzo.dto.BikeDto;
import reboul.enzo.service.BikeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
@RequestMapping("eval")
public class BikeController {
	
	@Autowired
	private BikeService bikeService;

	@GetMapping("get/all")
	public List<BikeDto> getAllBikes() {
		return bikeService.getAllBikes();
	}
	
	@GetMapping("get/{id}")
	public BikeDto getBikeById(@PathVariable("id") Long id) {
		return bikeService.getBikeById(id);
	}
	
	@PostMapping("post")
	public BikeDto createBike(@RequestBody BikeDto bikeDto) {
		return bikeService.createBike(bikeDto);
	}
	
	@PutMapping("put/{id}")
	public BikeDto updateBike(@PathVariable("id") Long id, @RequestBody BikeDto bikeDto) {
		return bikeService.updateBike(id, bikeDto);
	}
	
	@DeleteMapping("del/{id}")
	public void deleteBike(@PathVariable("id") Long id) {
		bikeService.deleteBike(id);
	}
	
	
}
