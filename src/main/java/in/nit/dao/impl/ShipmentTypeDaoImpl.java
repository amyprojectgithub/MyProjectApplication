package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveShipmentType(ShipmentType st) {
		return (Integer)ht.save(st);
	}
	@Override
	public List<ShipmentType> getAllShipmentType() {
		return ht.loadAll(ShipmentType.class);
		
	}
	@Override
	public void deleteShipmentType(Integer sid) {
		ht.delete(new ShipmentType(sid));
	}
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		return ht.get(ShipmentType.class, id);
	}
	@Override
	public void updateShipmentType(ShipmentType ob) {
		ht.update(ob);
		
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getShipmentModeCount() {
		String hql="SELECT shipMode,COUNT(shipMode) FROM in.nit.model.ShipmentType GROUP BY shipMode";
		return (List<Object[]>) ht.find(hql);
	}

}
