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

import in.nit.model.OrderMethod;
import in.nit.model.ShipmentType;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//make pdf  as a downloadable file
		response.addHeader("Content-Disposition","attachment;filename=order.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome to OrderMethod");
		//add element to document
		document.add(p);
		//read model data 
		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		//create Table(element) with number of columns
		PdfPTable table=new PdfPTable(5);
		table.addCell("ID");
		table.addCell("MODE");
		table.addCell("CODE");
		table.addCell("METHOD");
	//	table.addCell("ACCEPT");
		table.addCell("NOTE");
		//Add model data to table
		for(OrderMethod om:list) {
			table.addCell(om.getOrderMId().toString());
			table.addCell(om.getOrderMode());
			table.addCell(om.getOrderCode());
			table.addCell(om.getOrderMethod());
			//table.addCell(om.getOrderAccept());
			table.addCell(om.getOrderDesc());
		}
			//add element(Table) to document
			document.add(table);
			//add date and time to pdf
			document.add(new Paragraph(new Date().toString()));
	}
}
