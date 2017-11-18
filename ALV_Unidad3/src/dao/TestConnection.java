package dao;

import java.util.List;

import model.Zoo;



public class TestConnection {
	public static void main(String[] args) {
		ZooDAOImpl zooDAOImpl = new ZooDAOImpl();
		zooDAOImpl.createZoo(new Zoo(6L, "Potero","GSILBN","Vespertino"));
		
		List<Zoo> zoos = zooDAOImpl.readAllZoos();
		for (Zoo zoo : zoos) {
			System.out.println(zoo);
			
		}
	}

}
