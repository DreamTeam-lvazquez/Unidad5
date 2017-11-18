package model;

public class Zoo {
	private Long id_zoom;
	private String name;
	private String number_animals;
	private String city;
	
	
	
	public Zoo(Long id_zoom, String name, String number_animals, String city) {
		super();
		this.id_zoom = id_zoom;
		this.name = name;
		this.number_animals = number_animals;
		this.city = city;
	}



	public Zoo() {
	this(0L," "," ", " ");
	}



	public Long getId_zoom() {
		return id_zoom;
	}



	public void setId_zoom(Long id_zoom) {
		this.id_zoom = id_zoom;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getNumber_animals() {
		return number_animals;
	}



	public void setNumber_animals(String number_animals) {
		this.number_animals = number_animals;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	@Override
	public String toString() {
		return "Zoo [id_zoom=" + id_zoom + ", name=" + name + ", number_animals=" + number_animals + ", city=" + city
				+ "]";
	}
	
	

}
