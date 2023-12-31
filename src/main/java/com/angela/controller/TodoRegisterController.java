package com.angela.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angela.dto.TodoDto;
import com.angela.service.TodoService;

import lombok.extern.log4j.Log4j2;

@WebServlet(name="todoRegisterController", value="/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {
	
	private TodoService todoService = TodoService.INSTACNE;
	private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("/todo/register Get.....");
		req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TodoDto todoDto = TodoDto.builder()
				.title(req.getParameter("title"))
				.dueDate(LocalDate.parse(req.getParameter("dueDate"), DATEFORMATTER))
				.build();
		
		log.info("/todo/register POST.......");
		log.info(todoDto);
		
		try {
			todoService.register(todoDto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/todo/list");
	}
}
