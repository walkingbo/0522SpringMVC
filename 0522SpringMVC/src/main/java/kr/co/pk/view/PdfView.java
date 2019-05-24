package kr.co.pk.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//데이터 가져오기
		List<Map<String,String>> list =
				(List<Map<String, String>>) model.get("list");
		//데이터를 출력하기 위한 테이블을 만들기
		//열의 개수는 2행의 개수는 list의 크기 +1
		Table table = new Table(2,list.size()+1);
		table.setPadding(5);
		table.setBorderColor(Color.CYAN);
		//폰트 설정
		BaseFont korFont = BaseFont.createFont("/Users/a503_18/Downloads/NanumGothic.ttf"
				,BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(korFont);
		
		//제목 셀 만들기 
		Cell cell = new Cell(new Paragraph("OS",font));
		cell.setHeader(true);
		table.addCell(cell);
		
		cell = new Cell(new Paragraph("통합개발환경",font));
		cell.setHeader(true);
		table.addCell(cell);
		
		table.endHeaders();
		
		//데이터 출력하기 
		for(Map<String,String> map : list){
			Cell temp = new Cell(
					new Paragraph(map.get("OS"),font));
			table.addCell(temp);
			temp = new Cell(
					new Paragraph(map.get("IDE"),font));
			table.addCell(temp);
		}
		//테이블을 문서에 추가
		document.add(table);
	}

}
