package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.OrderMethod;
import in.nit.model.ShipmentType;

public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			                                                       Workbook workbook, HttpServletRequest request,
		                                                        	HttpServletResponse response) throws Exception {
		//Downloadable file name
		response.addHeader("Content-Disposition", "attachment;filename=order.xlsx");
		//create sheet fom workbook
		Sheet s=workbook.createSheet("OrderMethod");
		//create row-0
		setHeader(s);
		//read model data
		List<OrderMethod> list=(List<OrderMethod>)model.get("list");
        //create rest of the rows
		setBody(s,list);
	}

	private void setBody(Sheet s, List<OrderMethod> list) {
		int count=1;
		for(OrderMethod om:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(om.getOrderMId());
			r.createCell(1).setCellValue(om.getOrderMode());
			r.createCell(2).setCellValue(om.getOrderCode());
			r.createCell(3).setCellValue(om.getOrderMethod());
		//	r.createCell(4).setCellValue(om.getOrderAccept());
			r.createCell(5).setCellValue(om.getOrderDesc());
		}
		
	}

	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("MODE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("METHOD");
	//	r.createCell(4).setCellValue("ACCEPT");
		r.createCell(5).setCellValue("NOTE");
		
	}

}
