package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeDao {
	Integer saveShipmentType(ShipmentType st);
	List<ShipmentType> getAllShipmentType();
	void deleteShipmentType(Integer sid);
	ShipmentType getOneShipmentType(Integer id);
	void updateShipmentType(ShipmentType ob);
	List<Object[]> getShipmentModeCount();
}
