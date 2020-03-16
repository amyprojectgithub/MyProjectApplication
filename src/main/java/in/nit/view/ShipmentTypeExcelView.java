package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			                                                       Workbook workbook, HttpServletRequest request,
		                                                        	HttpServletResponse response) throws Exception {
		//Downloadable file name
		response.addHeader("Content-Disposition", "attachment;filename=shipments.xlsx");
		//create sheet fom workbook
		Sheet s=workbook.createSheet("ShipmentType");
		//create row-0
		setHeader(s);
		//read model data
		List<ShipmentType> list=(List<ShipmentType>)model.get("list");
        //create rest of the rows
		setBody(s,list);
	}

	private void setBody(Sheet s, List<ShipmentType> list) {
		int count=1;
		for(ShipmentType st:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(st.getShipId());
			r.createCell(1).setCellValue(st.getShipMode());
			r.createCell(2).setCellValue(st.getShipcode());
			r.createCell(3).setCellValue(st.getEnbShipment());
			r.createCell(4).setCellValue(st.getShipGrade());
			r.createCell(5).setCellValue(st.getShipDesc());
		}
		
	}

	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("MODE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("ENABLED");
		r.createCell(4).setCellValue("GRADE");
		r.createCell(5).setCellValue("NOTE");
		
	}

}
