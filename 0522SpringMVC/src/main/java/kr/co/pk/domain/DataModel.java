package kr.co.pk.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
//출력에 사용할 변수와 순서를 결정 
@XmlType(name="",propOrder= {"title","content"})
public class DataModel {
	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "DataModel [title=" + title + ", content=" + content + "]";
	}
	
	
	
}
