package reboul.enzo.dto;

public class BikeDto {
	
	private Long id;
	
	private String model;
	
	private String conceptor;
	
	private String releaseDate;
	
	private String status;
	
	public Long getId() {
		return id;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getConceptor() {
		return conceptor;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setConceptor(String conceptor) {
		this.conceptor = conceptor;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
