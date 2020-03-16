package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWhUserTypeDao;
import in.nit.model.WhUserType;
import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
	@Autowired
private IWhUserTypeDao dao;
	@Override
	@Transactional
	public Integer saveWhUserType(WhUserType user) {
	return dao.saveWhUserType(user);
	}
	@Override
	@Transactional(readOnly = true)
	public List<WhUserType> getAllWhUserType() {
		List<WhUserType> list=dao.getAllWhUserType();
		Collections.sort(list, (o1,o2)->o1.getWhUserId()-o2.getWhUserId());
		return list;
	}
	@Override
	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);
	}
	@Override
	@Transactional(readOnly = true)
	public WhUserType getOneWhUserType(Integer id) {
		return dao.getOneWhUserType(id);
	}
	@Override
	@Transactional
	public void updateWhUserType(WhUserType ob) {
		dao.updateWhUserType(ob);
		
	}
	@Override
	public List<Object[]> getWhUserTypeCount() {
		return dao.getWhUserTypeCount();
	}

}
