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

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//make pdf  as a downloadable file
		response.addHeader("Content-Disposition","attachment;filename=shipments.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome to Shipment type");
		//add element to document
		document.add(p);
		//read model data 
		@SuppressWarnings("unchecked")
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		//create Table(element) with number of columns
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("ENABLE");
		table.addCell("GRADE");
		table.addCell("NOTE");
		//Add model data to table
		for(ShipmentType st:list) {
			table.addCell(st.getShipId().toString());
			table.addCell(st.getShipMode());
			table.addCell(st.getShipcode());
			table.addCell(st.getEnbShipment());
			table.addCell(st.getShipGrade());
			table.addCell(st.getShipDesc());
		}
			//add element(Table) to document
			document.add(table);
			//add date and time to pdf
			document.add(new Paragraph(new Date().toString()));
	}
}
