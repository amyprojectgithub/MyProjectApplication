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
import in.nit.model.Part;

public class PartPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//make pdf  as a downloadable file
		response.addHeader("Content-Disposition","attachment;filename=Part.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome to Part");
		//add element to document
		document.add(p);
		//read model data 
		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>) model.get("list");
		//create Table(element) with number of columns
		PdfPTable table=new PdfPTable(4);
		table.addCell("ID");
		table.addCell("CODE");
		table.addCell("WIDTH");
		table.addCell("LENGTH");
		table.addCell("HEIGHT");
		table.addCell("BASE COST");
		table.addCell("BASE CURRENCY");
		table.addCell("NOTE");
		//Add model data to table
		for(Part u:list) {
			table.addCell(u.getPartId().toString());
			table.addCell(u.getPartCode());
			table.addCell(u.getWidth().toString());
			table.addCell(u.getLength().toString());
			table.addCell(u.getHeight().toString());
			table.addCell(u.getBaseCost().toString());
			table.addCell(u.getBaseCurrency());
		}
			//add element(Table) to document
			document.add(table);
			//add date and time to pdf
			document.add(new Paragraph(new Date().toString()));
	}
}
