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
import in.nit.model.WhUserType;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=whUser.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome to WhUserType");
		//add element to document
		document.add(p);
		//read model data 
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		//create Table(element) with number of columns
		PdfPTable table=new PdfPTable(9);
		table.addCell("ID");
		table.addCell("TYPE");
		table.addCell("CODE");
		table.addCell("USER_FOR");
		table.addCell("MAIL");
		table.addCell("CONTACT");
		table.addCell("ID_TYPE");
		table.addCell("OTHER_ID_TYPE");
		table.addCell("OTHER_ID_NUM");
		//Add model data to table
		for(WhUserType w:list) {
			table.addCell(w.getWhUserId().toString());
			table.addCell(w.getWhUserType());
			table.addCell(w.getWhUserCode());
			table.addCell(w.getUserFor());
			table.addCell(w.getWhUserMail());
			table.addCell(w.getWhUserContact());
			table.addCell(w.getWhUserIdType());
			table.addCell(w.getWhUserOtherIdType());
			table.addCell(w.getWhUserIdNum());
		}
		//add element(Table) to document
		document.add(table);
		//add date and time to pdf
		document.add(new Paragraph(new Date().toString()));
	}
}
