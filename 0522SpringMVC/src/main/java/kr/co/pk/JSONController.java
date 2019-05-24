package kr.co.pk;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {
	//문자열을 리턴하면 csv 형식 
	@RequestMapping(value="data.csv",method=RequestMethod.GET)
	public String csv() {
		String data ="냉면 과일 아이스크림";
		return data;
	}
	
	//기본형이나 String, Date를 제외한 자룔형의 데이터를 리턴하면 json 형식 
	@RequestMapping(value="controller.json",method=RequestMethod.GET)
	public Map<String,Object>json() {
		Map<String,Object> map = new HashMap<>();
		
		double [] [] [] data= {{{1,2},{5,12.4},{2,2.4}}};
		map.put("data", data);
		return map;
		}
}
