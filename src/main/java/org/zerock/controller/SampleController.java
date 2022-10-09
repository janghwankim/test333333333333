package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;


//@Controller
@RestController   //모든 메서드의 반환형 @ResponseBody로 처리
@RequestMapping("/sample")
public class SampleController {

  @RequestMapping("/hello")    // ~/sample/hello로 요청
  //@ResponseBody //클라이언트에게 전달해주는 어노테이션<->@RequestBody
  public String sayHello() {  //반환형이 String
	  return "test";  //return "이동할 페이지명" ->단순히 출력시켜주는 문자열로
  }                        //                                    반환              
  /*
   * @RequestBody DTO자료형 객체명=>외부 json형태 자료->자바객체로 변환
   * @RequestBody Map<String,Object> 객체명
   */
  
  @RequestMapping("/sendVO")
  public SampleVO sendVO() {  //SampleVO=>json형태로 전송(chrome)
	  
	  SampleVO vo=new SampleVO();
	  vo.setFirstName("길동");
	  vo.setLastName("홍");
	  vo.setMno(123);
	  return vo;
  }
  
  //List형태로 반환
  @RequestMapping("/sendList")
  public List<SampleVO> sendList() {  //SampleVO=>json형태로 전송(chrome)
	  
	  List<SampleVO> list=new ArrayList<>();
	  
	  for(int i=0;i<10;i++) {
		  SampleVO vo=new SampleVO();
		  vo.setFirstName("길동");
		  vo.setLastName("홍");
		  vo.setMno(123);
	      list.add(vo);//DB의 레코드값을 하나씩 담기
	  }
	  return list;
  }
  
  //Map형태로 데이터값 반환->200
  @RequestMapping("/sendMap")
  public Map<Integer,SampleVO> sendMap() {  //SampleVO=>json형태로 전송(chrome)
	  
	  Map<Integer,SampleVO> map=new HashMap<>();
	  
	  for(int i=0;i<10;i++) {
		  SampleVO vo=new SampleVO();
		  vo.setFirstName("길동");
		  vo.setLastName("홍");
		  vo.setMno(123);
	      map.put(i,vo);//DB의 레코드값을 하나씩 담기
	  }
	  return map;
  }
  //현재 서버의 현재상태를 반환(ResponseEntity 형으로 반환)
  @RequestMapping("/sendErrorAuth")
  public ResponseEntity<Void> sendListAuth(){
	  return new ResponseEntity <> (HttpStatus.BAD_REQUEST);
  }
  
  //인증을 받아서 요청->요청페이지가 없다면  출력X  요청페이지가 존재 O 출력O
  @RequestMapping("/sendErrorNot")
  public ResponseEntity <List<SampleVO>> sendListNot() {  //SampleVO=>json형태로 전송(chrome)
	  
	  List<SampleVO> list=new ArrayList<>();
	  
	  for(int i=0;i<10;i++) {
		  SampleVO vo=new SampleVO();
		  vo.setFirstName("길동");
		  vo.setLastName("홍");
		  vo.setMno(123);
	      list.add(vo);//DB의 레코드값을 하나씩 담기
	  }
	  //요청페이지가 없으면 없다고 에러메세지 출력, 데이터가 있으면 반환 O
	  return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
  }
}













