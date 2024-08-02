package miniproject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTest {

	public static void main(String[] args) throws IOException {

		// FileReader: 입력 기반 스트림
//		FileReader fr = new FileReader("FILE_NAME");
		
		// BufferedReader: 보조스트림 (줄단위로 텍스트를 가져오는 기능)
//		BufferedReader br = new BufferedReader(fr);
		
		// 한줄씩 가져오기~
//		String line = br.readLine();
		
		// 현재시간가져오기
		LocalDateTime curDateTime= LocalDateTime.now();
		System.out.println(curDateTime);
		
		// 날짜를특정포맷으로출력하기
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		String formatDate= curDateTime.format(formatter);
		System.out.println(formatDate);
		
//		// 문자열을LocalDateTime로변환하기
//		String str= "2024-07-31 11:11:11";
//		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
//		
//		// 날짜문자열, 날짜에 맞는 포맷
//		LocalDateTime datetime = LocalDateTime.parse(str, formatter2);
//		System.out.println(datetime);

	}

}
