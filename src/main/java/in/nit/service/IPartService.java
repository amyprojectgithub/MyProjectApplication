package in.nit.service;

import java.util.List;

import in.nit.model.Part;

public interface IPartService {
	Integer savePart(Part unit);
	List<Part> getAllPart();
	void deletePart(Integer id); 
    Part getOnePart(Integer id);
    public void updatePart(Part ob);
}
