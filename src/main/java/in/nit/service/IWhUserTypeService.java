package in.nit.service;

import java.util.List;

import in.nit.model.WhUserType;


public interface IWhUserTypeService {
	Integer saveWhUserType(WhUserType user);
	List<WhUserType> getAllWhUserType();
	void deleteWhUserType(Integer id);
	 WhUserType getOneWhUserType(Integer id);
	 void updateWhUserType(WhUserType ob);
	 List<Object[]> getWhUserTypeCount();
}
