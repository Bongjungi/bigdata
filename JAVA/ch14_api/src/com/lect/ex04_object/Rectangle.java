package com.lect.ex04_object;

public class Rectangle implements Cloneable {
	private int width;
	private int height;
	private String color;
	public Rectangle() {
		color="검정";
	}
	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("가로 %dcm, 세로 %dcm %s색 사각형",width,height,color);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null&&obj instanceof Rectangle) {
			boolean heightChk=width==((Rectangle)obj).width;
			boolean widthChk=width==((Rectangle)obj).width;
			boolean colorChk=color.equals(((Rectangle)obj).color);
			return widthChk&&heightChk&&colorChk;
		}
		return false;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
