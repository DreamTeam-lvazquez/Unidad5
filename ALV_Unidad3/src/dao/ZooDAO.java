package dao;

import java.util.List;

import model.Zoo;

public interface ZooDAO {
	void createZoo(Zoo zoo);
	Zoo readZoo(Long id_zoom);
	List<Zoo> readAllZoos();
	void updateZoo(Zoo zoo);
	void deleteZoo(Long id_zoom);

}
