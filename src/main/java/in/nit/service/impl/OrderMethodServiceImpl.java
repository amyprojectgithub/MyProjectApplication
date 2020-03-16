package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
	@Autowired
	private IOrderMethodDao dao;

	@Override
	@Transactional
	public Integer saveOrderMethod(OrderMethod unit) {
		return dao.saveOrderMethod(unit);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderMethod> getAllOrderMethod() {
		return dao.getAllOrderMethod();
	}

	@Override
	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);
	}

	@Override
	@Transactional(readOnly = true)
	public OrderMethod getOneOrderMethod(Integer id) {
		return dao.getOneOrderMethod(id);
	}

	@Override
	@Transactional
	public void updateOrderMethod(OrderMethod ob) {
			dao.updateOrderMethod(ob);	
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getOrderMethodTypeCount() {
		return dao.getOrderMethodTypeCount();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getOrderMethodIdAndCode(String mode) {
		return dao.getOrderMethodIdAndCode(mode);
	}
	

}
