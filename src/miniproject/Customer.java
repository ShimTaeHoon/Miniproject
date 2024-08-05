package miniproject;


public class Customer {

	int orderNo;
	String cusName;
	String proName;
	int orderQuan;
	int price;
	String date;
	
	public Customer(int orderNo, String cusName, String proName, int orderQuan, int price, String date) {
		super();
		this.orderNo = orderNo;
		this.cusName = cusName;
		this.proName = proName;
		this.orderQuan = orderQuan;
		this.price = price;
		this.date = date;
	}
	
//	public Customer(String cusName, String proName, int orderQuan, int price) {
//		this.cusName = cusName;
//		this.proName = proName;
//		this.orderQuan = orderQuan;
//		this.price = price;
//		
//	}

	@Override
	public String toString() {
		return "주문번호: " + orderNo + ", 고객명: " + cusName + ", 제품명: " + proName + ", 주문수량: "
				+ orderQuan + ", 가격: " + price + ", 주문일시: " + date;
	}

}