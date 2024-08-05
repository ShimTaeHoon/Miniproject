//package miniproject;
//
//import java.io.BufferedReader;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Old {
//
//	static int orderNo = 1;
//
//	public static void main(String[] args) throws IOException {
//
//		Scanner scanner = new Scanner(System.in);
//		ArrayList<Customer> cus = new ArrayList<>();
//
//		FileOutputStream fos = new FileOutputStream("order.txt", true);
//		OutputStreamWriter bos = new OutputStreamWriter(fos);
//
//		while (true) {
//			System.out.println("1. 상품 주문하기");
//			System.out.println("2. 전체 주문 이력 보기");
//			System.out.println("3. 고객별 주문 이력 보기");
//			System.out.println("4. 특정날짜에 들어온 주문이력 보기");
//			System.out.println("5. 끝내기");
//
//			System.out.print("옵션을 선택하세요: ");
//			String option = scanner.nextLine();
//
//			if (option.equals("1")) {
//				System.out.print("고객명: ");
//				String cusName = scanner.nextLine();
//
//				System.out.print("제품명: ");
//				String proName = scanner.nextLine();
//
//				System.out.print("제품의수량: ");
//				int proQuan = scanner.nextInt();
//
//				System.out.print("제품의가격: ");
//				int price = scanner.nextInt();
//
//				LocalDateTime curDateTime = LocalDateTime.now();
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//				String formatDate = curDateTime.format(formatter);
////				cus.add(new Customer(orderNo++, cusName, proName, proQuan, price, formatDate));
//
//				scanner.nextLine();
//
//				Customer order = new Customer((orderNo++), cusName, proName, proQuan, price, formatDate);
//				cus.add(order);
//				bos.write(order.toString() + '\n');
//				bos.flush();
//
//				System.out.println(order.toString());
//
//				System.out.println("주문이 완료되었습니다!");
//
//			} else if (option.equals("2")) {
//				FileReader fr = new FileReader("order.txt");
//				BufferedReader br = new BufferedReader(fr);
//				String line;
//
//				while ((line = br.readLine()) != null) {
//					System.out.println(line);
//				
//				
//				}
//
//			} else if (option.equals("3")) {
//				System.out.println("고객명: ");
//				String cusNameOutput = scanner.nextLine();
//
//				FileReader fr = new FileReader("order.txt");
//				BufferedReader br = new BufferedReader(fr);
//				String line;
//				int orderCount = 0;
//				int orderPrice = 0;
//
//				while ((line = br.readLine()) != null) {
//
//					if (line.contains(", 고객명: " + cusNameOutput)) {
//						orderCount++;
//
//						String[] splitOrder = line.split(",");
////						System.out.println(Arrays.toString(splitOrder));
//						String[] arr = splitOrder[4].split(":");
//						String[] arr2 = splitOrder[3].split(":");
////						System.out.println(Arrays.toString(arr));
//
//						orderPrice = orderPrice + (Integer.parseInt(arr2[1].trim()) * Integer.parseInt(arr[1].trim()));
//
//					}
//				}
//
//				System.out.println("전체 주문 건수: " + orderCount);
//				System.out.println("전체 주문 금액: " + orderPrice);
//
//			} else if (option.equals("4")) {
//				System.out.println("날짜: ");
//				String cusDateOutput = scanner.nextLine();
//
//				FileReader fr = new FileReader("order.txt");
//				BufferedReader br = new BufferedReader(fr);
//				String line;
//				String orderDate = "";
//
//				while ((line = br.readLine()) != null) {
//
//					if (line.contains(cusDateOutput)) {
//
//						String[] splitDate = line.split(",");
//						String[] arr = splitDate[5].split(":");
//						orderDate = line;
//
//						System.out.println(orderDate);
//
//					}
//				}
//
//			} else if (option.equals("5")) {
//				System.out.println("프로그램을 종료합니다...");
//				break;
//			}
//
//		}
//
//	}
//
//}
//
//class OrderPrint {
//
//	void OrderPrint(Scanner scan) throws IOException {
//
//		FileReader fr = new FileReader("order.txt");
//		BufferedReader br = new BufferedReader(fr);
//		String line;
//
//		while ((line = br.readLine()) != null) {
//			System.out.println(line);
//
//		}
//	}
//
//}
