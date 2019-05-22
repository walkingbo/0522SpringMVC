package kr.co.pk.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ViewServiceImpl implements ViewService {
	
	@Override
	public List<String> filelist() {
		List<String> list = new ArrayList<>();
		//파일 목록을 보여줄 디렉토리 설정
		File f = new File("/Users/a503_18/Downloads");
		//하위에 존재하는 모든디렉토리 이름과 파일 이름을 가져오기 
		String [] subFiles = f.list();
		//파일만 골라서 List에 저장하기 
		for(String imsi : subFiles) {
			//파일이름에 .이 있으면 파일로 간주
			
			//String - length(),charAt(int idx),
			//subString(int start, int end+1)
			//split(String con)
			//indexOf(String find)
			
			if(imsi.indexOf(".")>=0) {
				list.add(imsi);
			}
			
			
		}
		
		return list;
	}

}
