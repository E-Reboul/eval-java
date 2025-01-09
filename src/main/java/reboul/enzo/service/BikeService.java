package reboul.enzo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reboul.enzo.dto.BikeDto;
import reboul.enzo.model.BikeModel;
import reboul.enzo.repository.BikeRepository;

@Service
public class BikeService {
	
	@Autowired
	private BikeRepository bikeRepository;
	
	public List<BikeDto> getAllBikes() {
		return bikeRepository.findAll().stream().map(bike -> toDto(bike)).toList();
	}
	
	public BikeDto getBikeById(Long id) {
		if (bikeRepository.findById(id) != null) {
			
			BikeModel bike = bikeRepository.findById(id).get();
			return toDto(bike);
		}
		
		throw new IllegalArgumentException("Bike at this id: " + id + "is null");
	}
	
	public BikeDto createBike(BikeDto bikeDto) {
		BikeModel newBike = bikeRepository.save(toModel(bikeDto));
		return toDto(newBike);
	}
	
	public BikeDto updateBike(Long id, BikeDto bikeDto) {
		if (bikeRepository.existsById(id)) {
			
			BikeModel bike = bikeRepository.findById(id).orElse(toModel(bikeDto));
			
			bike.setModel(bikeDto.getModel());
			bike.setConceptor(bike.getConceptor());
			bike.setReleaseDate(bikeDto.getReleaseDate());
			bike.setStatus(bikeDto.getStatus());
			
			BikeModel updatedBike = bikeRepository.save(bike);
			
			return toDto(updatedBike);
		}
		throw new IllegalArgumentException("This id: " + id + "didn't exist");
	}
	
	public void deleteBike(Long id) {
		if (bikeRepository.existsById(id)) {
			
			bikeRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("This id: " + id + "didn't exist");
		}
	}
	
	public BikeDto toDto(BikeModel model) {
		BikeDto dto = new BikeDto();
		
		dto.setId(model.getId());
		dto.setModel(model.getModel());
		dto.setConceptor(model.getConceptor());
		dto.setReleaseDate(model.getReleaseDate());
		dto.setStatus(model.getStatus());
		
		return dto;
	}
	
	public BikeModel toModel(BikeDto dto) {
		BikeModel model = new BikeModel();
		
		model.setId(dto.getId());
		model.setModel(dto.getModel());
		model.setConceptor(dto.getConceptor());
		model.setReleaseDate(dto.getReleaseDate());
		model.setStatus(dto.getStatus());
		
		return model;
	}
}
