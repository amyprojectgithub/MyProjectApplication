package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IWhUserTypeDao;
import in.nit.model.WhUserType;
import in.nit.model.WhUserType;
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveWhUserType(WhUserType user) {
			return (Integer)ht.save(user);
	}

	@Override
	public List<WhUserType> getAllWhUserType() {
		return ht.loadAll(WhUserType.class);
	}

	@Override
	public void deleteWhUserType(Integer id) {
		WhUserType u=new WhUserType();
		u.setWhUserId(id);
		ht.delete(u);
	}
	@Override
	public WhUserType getOneWhUserType(Integer id) {
		return ht.get(WhUserType.class, id);
	}
	@Override
	public void updateWhUserType(WhUserType ob) {
		ht.update(ob);
		
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getWhUserTypeCount() {
		String hql="SELECT whUserIdType,COUNT(whUserIdType) FROM in.nit.model.WhUserType GROUP BY whUserIdType";
		return (List<Object[]>) ht.find(hql);
	}


}
