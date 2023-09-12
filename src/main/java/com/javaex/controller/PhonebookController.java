package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;


@WebServlet("/PhonebookController")
public class PhonebookController extends HttpServlet {
	//필드
	private static final long serialVersionUID = 1L;
	
	//생성자 디폴트 생성자사용 - 삭제
	
	//메소드 gs 필요없음
	
	//메소드 일반
	//	  get방식으로 요청이 들어왔올때 실행되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라미터 action의 값을 꺼내온다
		String action = request.getParameter("action");
		
		if("list".equals(action)) {
			System.out.println("action=list");
			
			//리스트/////////////////////////////////////////////////////////////////////
			//1.dao를 통해서 전체 리스트데이터 가져오기 
			PersonDao personDao = new PersonDao();	
			List<PersonVo> personList = personDao.personSelect("");

			//System.out.println(personList);
			
			//리스트 화면(html) + data 응답을 해야된다
			//request data를 넣어둔다
			request.setAttribute("pList", personList);
			
			//list.jsp 예제 시킨다		(포워드)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp"); //jsp파일 위치를
			rd.forward(request, response);
			///////////////////////////////////////////////////////////////////////////
		}else if("wform".equals(action)) {
			System.out.println("action=wform");
			//등록폼////////////////////////////////////////////////////////////////////
			
			//write.jsp 예제 시킨다		(포워드)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/write.jsp"); //jsp파일 위치를
			rd.forward(request, response);
			
		}else if("insert".equals(action)) {
			System.out.println("action=insert");
			//저장 일때
			
			//파라미터 꺼내기
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			//파라미터값 1개로 묶기
			PersonVo personVo = new PersonVo();
			personVo.setName(name);
			personVo.setHp(hp);
			personVo.setCompany(company);
			
			//System.out.println(personVo);
			
			//dao를 이용해서 데이터 저장하기
			PersonDao personDao = new PersonDao();
			int count = personDao.personInsert(personVo);
			System.out.println(count);
			
			
			//리스트로 출력 -->리다이렉트
			response.sendRedirect("/phonebook3/PhonebookController?action=list");
			
			
		}else {
				System.out.println("나머지");
		}
		
		//삭제일때
		//수정폼
		//수정
			
	}

	//  post방식으로 요청이 들어왔올때 실행되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}