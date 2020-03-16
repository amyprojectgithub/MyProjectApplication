package in.nit.dao;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodDao {
	Integer saveOrderMethod(OrderMethod unit);
	List<OrderMethod> getAllOrderMethod();
	void deleteOrderMethod(Integer id); 
	OrderMethod getOneOrderMethod(Integer id);
	void updateOrderMethod(OrderMethod ob);
	List<Object[]> getOrderMethodTypeCount();
	List<Object[]> getOrderMethodIdAndCode(String mode);
}
