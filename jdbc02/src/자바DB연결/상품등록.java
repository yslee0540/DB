package 자바DB연결;

import java.util.Scanner;

import 화면DB연결.ProductVO;

public class 상품등록 {

	public static void main(String[] args) {
		//Scanner로 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("id/name/content 순으로 입력");
		String id = sc.next();
		String name = sc.next();
		String content = sc.next();
		
		//1. 가방 만들기
		ProductVO bag = new ProductVO();
		//2. 가방에 데이터 넣기
		bag.setId(id);
		bag.setName(name);
		bag.setContent(content);
		//3. 가방 전달
		ProductDAO dao = new ProductDAO();
		dao.insert(bag);
	}

}
