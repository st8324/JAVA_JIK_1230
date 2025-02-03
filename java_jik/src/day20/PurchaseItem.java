package day20;

import java.util.Date;

import lombok.Data;

@Data
public class PurchaseItem {

	Product p;
	int amount;
	int totalPrice;
	Date date;
	
	public PurchaseItem(Product p, int amount) {
		this.p = p;
		this.amount = amount;
		this.totalPrice = p.getPrice() * amount;
		date = new Date();
	}
	
	
}
