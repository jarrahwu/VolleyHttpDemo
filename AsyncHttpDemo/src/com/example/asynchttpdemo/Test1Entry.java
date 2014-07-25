package com.example.asynchttpdemo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Test1Entry {
	private String msg;
	
	private int code;
	
	private ArrayList<CourseInfo> elem;
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class CourseInfo{
		String ftitle;
		String fintrol;
		String fpic;
		String url;
		int fid;
		String fpic1080;
		boolean lock;
		int movetime;
		int custkll;
		
		public String getFtitle() {
			return ftitle;
		}
		public void setFtitle(String ftitle) {
			this.ftitle = ftitle;
		}
		public String getFintrol() {
			return fintrol;
		}
		public void setFintrol(String fintrol) {
			this.fintrol = fintrol;
		}
		public String getFpic() {
			return fpic;
		}
		public void setFpic(String fpic) {
			this.fpic = fpic;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public int getFid() {
			return fid;
		}
		public void setFid(int fid) {
			this.fid = fid;
		}
		public String getFpic1080() {
			return fpic1080;
		}
		public void setFpic1080(String fpic1080) {
			this.fpic1080 = fpic1080;
		}
		public boolean isLock() {
			return lock;
		}
		public void setLock(boolean lock) {
			this.lock = lock;
		}
		public int getMovetime() {
			return movetime;
		}
		public void setMovetime(int movetime) {
			this.movetime = movetime;
		}
		public int getCustkll() {
			return custkll;
		}
		public void setCustkll(int custkll) {
			this.custkll = custkll;
		}
	}
	
	private LinkedHashMap<String, Object> recommend;
	
	public LinkedHashMap<String, Object> getRecommend() {
		return recommend;
	}
	public void setRecommend(LinkedHashMap<String, Object> recommend) {
		this.recommend = recommend;
	}
	public ArrayList<CourseInfo> getElem() {
		return elem;
	}
	public void setElem(ArrayList<CourseInfo> elem) {
		this.elem = elem;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "Test1Entry" + "\ncode : " + getCode() + "\nmsg: " + getMsg() + "\nelem: " + getElem().toString() + "\nrecommend : " + getRecommend().toString();
	}
}
