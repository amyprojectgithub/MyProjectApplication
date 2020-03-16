package in.nit.dao;

import java.util.List;

import in.nit.model.WhUserType;


public interface IWhUserTypeDao {
	Integer saveWhUserType(WhUserType user);
	List<WhUserType> getAllWhUserType();
	void deleteWhUserType(Integer id);
	WhUserType getOneWhUserType(Integer id);
	void updateWhUserType(WhUserType ob);
	List<Object[]> getWhUserTypeCount();

}
