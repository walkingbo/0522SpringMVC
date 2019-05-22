package kr.co.pk.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {
	//생성자
	public DownloadView() {
		setContentType("application/download; charset=utf-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Controller에서 전달하는 Attribute를 읽어오는 구문 
		//Controller에서 File 객체를 downloadFile이라는 이름으로
		//문장열을 전달해 주면 됩니다.
		File file = (File) model.get("downloadFile");
		
		//ContentType과 파일의 크기 설정 
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());
		
		//파일이름을 설정하기 위해서 브라우저 종류를 확인 
		//자바스크립트에서는 navigator 객체의 useragent
		//웹 프로그래밍 언어에서는 요청 객체의 헤더 중에서 User-Agent
		//속성을 확인하면 운영체제 종류와 브라우저 종류를 확인할 수 있습니다. 
		String userAgent = request.getHeader("User-Agent");
		//IE를 구분하기 위해서 userAgent 에 rv 라는 문장열이 있는 지 확인
		//rv가 있으면 IE 입니다.
		boolean ie = userAgent.indexOf("rv") > -1;
		
		String fileName = null;
		//IE일 때는 바로 utf-8로 파일을 변환하고 IE가 아닐 때는 iso-8859-1로
		//가져와서 utf-8로 변환
		//조금 더 시간이 지나면 IE 구분 안하고 바로 변환해도 됩니다. 
		if (ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		//파일 이름 설정 
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		//전송 형식을 설정 
		response.setHeader("Content-Transfer-Encoding", "binary");
		//다운로드할 파일의 내용을 읽어서 브라우저에 전송 
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			//FileCopyUtils Spring의 클래스 
			//Spring을 사용하지 않을 때는 직접 읽어서(read) 기록(write)
			FileCopyUtils.copy(fis, out);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {
				}
		}
		out.flush();
	}

}

