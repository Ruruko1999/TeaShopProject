package model;

import java.io.Serializable;

public class Order implements Serializable{
	private Integer orderno;
	private Integer black;
	private Integer green;
	private Integer coffee;
	private Integer sum;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(Integer black, Integer green, Integer coffee) {
		super();
		this.black = black;
		this.green = green;
		this.coffee = coffee;
		this.sum =this.black*20+this.green*25+this.coffee*30 ;
	}

	public Integer getOrderno() {
		return orderno;
	}

	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}

	public Integer getBlack() {
		return black;
	}

	public void setBlack(Integer black) {
		this.black = black;
	}

	public Integer getGreen() {
		return green;
	}

	public void setGreen(Integer green) {
		this.green = green;
	}

	public Integer getCoffee() {
		return coffee;
	}

	public void setCoffee(Integer coffee) {
		this.coffee = coffee;
	}

	public Integer getSum() {
		sum =this.black*20+this.green*25+this.coffee*30 ;
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	
	
	
}
