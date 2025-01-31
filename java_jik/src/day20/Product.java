package day20;

import java.util.Objects;

import lombok.Data;

@Data
public class Product {
	
	private String code;
	private String category;
	private String name;
	private String option;
	private int price;
	private int amount;
	
	public Product(String code, String category, String name, String option, int price) {
		this.code = code;
		this.category = category;
		this.name = name;
		this.option = option;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[" + category + "] " + name +  " " + option + " - " + code + " : " 
				+ price + "원, 수량 : " + amount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(code, other.code);
	}

	
}
