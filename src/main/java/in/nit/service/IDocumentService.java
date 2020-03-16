package in.nit.service;

import java.util.List;

import in.nit.model.Document;

public interface IDocumentService {
	Integer saveDocument(Document doc);
	public List<Object[]> getFileIdAndNames();
	public Document getOneDocumen(Integer id);
}
