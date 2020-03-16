package in.nit.service;

import java.util.List;

import in.nit.model.Uom;

public interface IUomService {
	Integer saveUom(Uom unit);
	List<Uom> getAllUom();
	void deleteUom(Integer id); 
    Uom getOneUom(Integer id);
    public void updateUom(Uom ob);
    public List<Object[]> getUomTypeCount();
    List<Object[]> getUomIdAndModel();
}
