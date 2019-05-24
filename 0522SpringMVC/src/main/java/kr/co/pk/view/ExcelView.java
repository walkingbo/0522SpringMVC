package kr.co.pk.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ExcelView extends AbstractXlsView {

	@Override
	//Map은 Controller 에서 넘겨준 데이터
	//workbook은 엑셀 파일 - 이 파일에 출력 
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//내용 출력을 위해서 워크 시트 생성
		Sheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "Sheet1");
		//컬럼의 너비 설정 
		sheet.setColumnWidth(0, 256*30);
		
		//제목 행 생성
		Row header = sheet.createRow(0);
		
		//셀 생성
		Cell cell = header.createCell(0);
		cell.setCellValue("좋아하는 노래");
		
		//출력할 데이터 가져오기 
		List<String> list = (List<String>) map.get("list");
		for(int i = 1; i<list.size(); i=i+1) {
			String song = list.get(i);
			Row row = sheet.createRow(i);
			Cell c = row.createCell(0);
			c.setCellValue(song);
		}
		
	}

}
