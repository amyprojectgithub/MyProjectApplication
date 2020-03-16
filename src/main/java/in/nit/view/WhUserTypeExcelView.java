package in.nit.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import in.nit.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		//Downloadable file name
		response.addHeader("Content-Disposition", "attachment;filename=whUser.xlsx");
		//create sheet from workbook
		Sheet s=workbook.createSheet("WhUser");
		//create row-0
		setHeader(s);
		//read model data
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		//create rest of the rows
		setBody(s,list);
	}

	private void setBody(Sheet s, List<WhUserType> list) {
		int count=1;
		for(WhUserType u:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(u.getWhUserId());
			r.createCell(1).setCellValue(u.getWhUserType());
			r.createCell(2).setCellValue(u.getWhUserCode());
			r.createCell(3).setCellValue(u.getUserFor());
			r.createCell(4).setCellValue(u.getWhUserMail());
			r.createCell(5).setCellValue(u.getWhUserContact());
			r.createCell(6).setCellValue(u.getWhUserIdType());
			r.createCell(7).setCellValue(u.getWhUserOtherIdType());
			r.createCell(8).setCellValue(u.getWhUserIdNum());
		}

	}

	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("USER_FOR");
		r.createCell(4).setCellValue("MAIL");
		r.createCell(5).setCellValue("CONTACT");
		r.createCell(6).setCellValue("ID_TYPE");
		r.createCell(7).setCellValue("OTHER_ID_TYPE");
		r.createCell(8).setCellValue("USERID_NUM");

	}

}

