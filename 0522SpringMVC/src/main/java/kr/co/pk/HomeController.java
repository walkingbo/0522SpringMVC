package kr.co.pk;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.pk.service.ViewService;


@Controller
public class HomeController {
	
	@Autowired
	private ViewService viewService;
	
	//요청 처리 메소드를 만들 때 먼저 생각 : 요청주소, 요청방식, 파라미터 
	@RequestMapping(value = "filelist.do", method = RequestMethod.GET)
	public String filelist(Model model) {
		//파일 목록 가져오기 서비스를 실행 
		List<String>list = viewService.filelist();
		//데이터 저장하기
		model.addAttribute("list",list);
		return "filelist";
	}
	
	//시작 요청 페이지는 무조건 있어야 한다. 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
	//"download.do?filename=${item}" 요청을 처리하는 메소드 
	@RequestMapping(value = "download.do", method = RequestMethod.GET)
	public String download(Model model,@RequestParam("filename") String filename) {
		
		//파라미터를 이용해서 뷰에 전달할 데이터 만들기 
		File f = new File("/Users/a503_18/Downloads/"+filename);
		model.addAttribute("downloadFile",f);
		//출력할 뷰이름을 설정 
		return "download";
	}
	
	@RequestMapping(value = "excel.xlsx", method=RequestMethod.GET)
	public String excel(Model model) {
		//엑셀 파일에 출력할 데이터를 생성
		List<String> list = new ArrayList<>();
		list.add("임을 위한 행진곡");
		list.add("바위처럼 단단하게");
		list.add("원탁의 기사님은 갔습니다.");
		
		//데이터를 전달하기 위해서 저장
		model.addAttribute("list",list);
		
		return "excel";
	}
	
	
}
