package kr.co.pk.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
//루트 태그로 표시할 태그 설정 
@XmlRootElement(name="DataList")
public class DataList {
	//객체 하나 마다 보여질 태그 
	@XmlElement(name="DataModel")
	private List<DataModel>list;

	public List<DataModel> getList() {
		return list;
	}

	public void setList(List<DataModel> list) {
		this.list = list;
	}
	
	
}
