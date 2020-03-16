package in.nit.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveUom(Uom unit) { 
		return (Integer)ht.save(unit);
	}

	@Override
	public List<Uom> getAllUom() {
		 List<Uom> list=ht.loadAll(Uom.class);
		 Collections.sort(list, (o1,o2)->o1.getUomId()-o2.getUomId());
		return list;
	}

	@Override
	public void deleteUom(Integer id) {
		Uom u=new Uom();
		u.setUomId(id);
		ht.delete(u);
	}

	@Override
	public Uom getOneUom(Integer id) {
		return ht.get(Uom.class, id);
	}

	@Override
	public void updateUom(Uom ob) {
			ht.update(ob);
   }

	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getUomTypeCount() {
			String hql="SELECT uomType,COUNT(uomType) FROM in.nit.model.Uom GROUP BY uomType";
			return (List<Object[]>) ht.find(hql);
	}
	@Override
	public List<Object[]> getUomIdAndModel() {
		String hql="select uomId,uomModel from in.nit.model.Uom";
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}
}