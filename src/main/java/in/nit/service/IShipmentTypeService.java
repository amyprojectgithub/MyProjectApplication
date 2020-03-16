package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeService {
Integer saveShipmentType(ShipmentType st);
List<ShipmentType> getAllShipment();
void deleteShipmentType(Integer sid);
 ShipmentType getOneShipmentType(Integer id);
 void updateShipmentType(ShipmentType ob);
 List<Object[]> getShipmentModeCount();
}
