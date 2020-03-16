package in.nit.service;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodService {
	Integer saveOrderMethod(OrderMethod unit);
	List<OrderMethod> getAllOrderMethod();
	void deleteOrderMethod(Integer id); 
	OrderMethod getOneOrderMethod(Integer id);
	void updateOrderMethod(OrderMethod ob);
	List<Object[]> getOrderMethodTypeCount();
	List<Object[]> getOrderMethodIdAndCode(String mode);
}
