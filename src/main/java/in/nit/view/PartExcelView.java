package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import in.nit.model.Part;

public class PartExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
			                                           HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=part.xlsx");
		//create sheet fom workbook
		Sheet s=workbook.createSheet("Part");
		//create row-0
		setHeader(s);
		//read model data
		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>)model.get("list");
        //create rest of the rows
		setBody(s,list);
	}

	private void setBody(Sheet s, List<Part> list) {
		int count=1;
		for(Part u:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(u.getPartId());
			r.createCell(1).setCellValue(u.getPartCode());
			r.createCell(2).setCellValue(u.getWidth());
			r.createCell(3).setCellValue(u.getLength());
			r.createCell(4).setCellValue(u.getHeight());
			r.createCell(5).setCellValue(u.getBaseCost());
			r.createCell(6).setCellValue(u.getBaseCurrency());
			r.createCell(7).setCellValue(u.getPdesc());
		}
		
	}

	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("WIDTH");
		r.createCell(3).setCellValue("LENGTH");
		r.createCell(4).setCellValue("HEIGHT");
		r.createCell(5).setCellValue("BASE COST");
		r.createCell(6).setCellValue("BASE CURRENCY");
		r.createCell(7).setCellValue("NOTE");
		
	}
		
	}

