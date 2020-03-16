package in.nit.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod unit) { 
		return (Integer)ht.save(unit);
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		 List<OrderMethod> list=ht.loadAll(OrderMethod.class);
		 Collections.sort(list, (o1,o2)->o1.getOrderMId()-o2.getOrderMId());
		return list;
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		OrderMethod u=new OrderMethod();
		u.setOrderMId(id);
		ht.delete(u);
	}

	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public void updateOrderMethod(OrderMethod ob) {
			ht.update(ob);
   }

	@Override
	public List<Object[]> getOrderMethodTypeCount() {
		String hql="SELECT orderMethod,COUNT(orderMethod) FROM in.nit.model.OrderMethod GROUP BY orderMethod";
		return (List<Object[]>) ht.find(hql);
	}
	@Override
	public List<Object[]> getOrderMethodIdAndCode(String mode) {
		String hql="select orderMId, orderCode from "+OrderMethod.class.getName()+" where orderMode=?0 ";
		return (List<Object[]>) ht.find(hql, mode);
	}
}