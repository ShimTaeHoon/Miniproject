package miniproject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class OrderNo {
			
	int OrderNo() throws IOException {
		
		int getOrderNo = 1;
		
		FileReader fr = new FileReader("order.txt");
		BufferedReader br = new BufferedReader(fr);
		String orderLine;
		
		while((orderLine = br.readLine()) != null) {
			String[] noSplit = orderLine.split(",");
			String[] arr = noSplit[0].split(":");
			
			getOrderNo = Integer.parseInt(arr[1].trim());
			
		}
		
		return getOrderNo;
		
	}


	
}

public class OrderMain {

	static int orderNo;
	
	public static void main(String[] args) throws IOException {

		OrderNo order = new OrderNo();
		
		orderNo = order.OrderNo();
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Customer> cus = new ArrayList<>();

		FileOutputStream fos = new FileOutputStream("order.txt", true);
		OutputStreamWriter bos = new OutputStreamWriter(fos);

		OrderPrint op = new OrderPrint();
		OrderCustomer oc = new OrderCustomer();
		OrderDate od = new OrderDate();
				
		while (true) {
			System.out.println("1. 상품 주문하기");
			System.out.println("2. 전체 주문 이력 보기");
			System.out.println("3. 고객별 주문 이력 보기");
			System.out.println("4. 특정날짜에 들어온 주문이력 보기");
			System.out.println("5. 끝내기");

			System.out.print("옵션을 선택하세요: ");
			String option = scanner.nextLine();

			if (option.equals("1")) {
				System.out.print("고객명: ");
				String cusName = scanner.nextLine();

				System.out.print("제품명: ");
				String proName = scanner.nextLine();

				System.out.print("제품의수량: ");
				int proQuan = scanner.nextInt();

				System.out.print("제품의가격: ");
				int price = scanner.nextInt();

				LocalDateTime curDateTime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formatDate = curDateTime.format(formatter);
//				cus.add(new Customer(orderNo++, cusName, proName, proQuan, price, formatDate));

				scanner.nextLine();

				Customer orderInfo = new Customer((orderNo++), cusName, proName, proQuan, price, formatDate);
				cus.add(orderInfo);
				bos.write(orderInfo.toString() + '\n');
				bos.flush();

				System.out.println(orderInfo.toString());

				System.out.println("주문이 완료되었습니다!");

			} else if (option.equals("2")) {

				op.OrderPrint(scanner);

			} else if (option.equals("3")) {

				oc.OrderCustomer(scanner);
				
			} else if (option.equals("4")) {
				
				od.OrderDate(scanner);

			} else if (option.equals("5")) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}

		}

	}

}

class OrderPrint {

	void OrderPrint(Scanner scanner) throws IOException {

		FileReader fr = new FileReader("order.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;

		while ((line = br.readLine()) != null) {
			System.out.println(line);

		}
	}

}

class OrderCustomer {

	void OrderCustomer(Scanner scanner) throws NumberFormatException, IOException {

		System.out.println("고객명: ");
		String cusNameOutput = scanner.nextLine();

		FileReader fr = new FileReader("order.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		int orderCount = 0;
		int orderPrice = 0;

		while ((line = br.readLine()) != null) {

			if (line.contains(", 고객명: " + cusNameOutput)) {
				orderCount++;

				String[] splitOrder = line.split(",");
				String[] arr = splitOrder[4].split(":");
				String[] arr2 = splitOrder[3].split(":");

				orderPrice = orderPrice + (Integer.parseInt(arr2[1].trim()) * Integer.parseInt(arr[1].trim()));

			}
		}

		System.out.println("전체 주문 건수: " + orderCount);
		System.out.println("전체 주문 금액: " + orderPrice);

	}

}

class OrderDate {
	
	void OrderDate(Scanner scanner) throws IOException {
		
		System.out.println("날짜: ");
		String cusDateOutput = scanner.nextLine();

		FileReader fr = new FileReader("order.txt");
		BufferedReader br = new BufferedReader(fr);
		String orderDate;

		while ((orderDate = br.readLine()) != null) {

			if (orderDate.contains(cusDateOutput)) {

				String[] splitDate = orderDate.split(",");
				String[] arr = splitDate[5].split(":");

				System.out.println(orderDate);

			}
		}
		
	}
	
}

