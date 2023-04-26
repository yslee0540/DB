package com.multu.mongodb;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBTest_find {

	public static void main(String[] args) {
		//1. 몽고db 프로그램에 연결
		MongoClient client = new MongoClient("localhost", 27017);
		System.out.println("1. 몽고db 프로그램에 연결 성공");
		
		//2. shop2 db로 연결
		MongoDatabase database = client.getDatabase("shop2");
		System.out.println("2. shop2 db로 연결 성공");
		
		//3. member 컬렉션에 연결
		MongoCollection<Document> collection = database.getCollection("member");
		System.out.println("3. member 컬렉션에 연결 성공");
		
		FindIterable<Document> list = collection.find();
		ArrayList<MemberVO> result = new ArrayList<MemberVO>();
		for (Document document : list) {
			//System.out.println(document);
			MemberVO vo = new MemberVO();
			vo.setId(document.getString("id"));
			vo.setPw(document.getString("pw"));
			vo.setName(document.getString("name"));
			vo.setTel(document.getString("tel"));
			
			result.add(vo);
		}
		System.out.println(result);
		
		client.close();

	}

}
