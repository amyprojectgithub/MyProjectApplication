package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.ShipmentType;
import in.nit.model.Uom;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//make pdf  as a downloadable file
		response.addHeader("Content-Disposition","attachment;filename=uom.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome to Uom");
		//add element to document
		document.add(p);
		//read model data 
		@SuppressWarnings("unchecked")
		List<Uom> list=(List<Uom>) model.get("list");
		//create Table(element) with number of columns
		PdfPTable table=new PdfPTable(4);
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("MODEL");
		table.addCell("NOTE");
		//Add model data to table
		for(Uom u:list) {
			table.addCell(u.getUomId().toString());
			table.addCell(u.getUomType());
			table.addCell(u.getUomModel());
			table.addCell(u.getUomDesc());
		}
			//add element(Table) to document
			document.add(table);
			//add date and time to pdf
			document.add(new Paragraph(new Date().toString()));
	}
}
