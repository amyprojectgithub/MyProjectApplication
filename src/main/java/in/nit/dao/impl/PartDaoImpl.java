package in.nit.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IPartDao;
import in.nit.model.Part;
@Repository
public class PartDaoImpl implements IPartDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePart(Part unit) { 
		return (Integer)ht.save(unit);
	}

	@Override
	public List<Part> getAllPart() {
		 List<Part> list=ht.loadAll(Part.class);
		 Collections.sort(list, (o1,o2)->o1.getPartId()-o2.getPartId());
		return list;
	}

	@Override
	public void deletePart(Integer id) {
		Part u=new Part();
		u.setPartId(id);
		ht.delete(u);
	}

	@Override
	public Part getOnePart(Integer id) {
		return ht.get(Part.class, id);
	}

	@Override
	public void updatePart(Part ob) {
			ht.update(ob);
   }

}