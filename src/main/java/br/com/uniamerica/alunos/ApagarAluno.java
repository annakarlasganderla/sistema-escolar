package br.com.uniamerica.alunos;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.uniamerica.alunos.Dao.AlunoDao;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApagarAluno extends HttpServlet {

	AlunoDao alunoDao = new AlunoDao();
	
	public void doPost(
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse
	) throws IOException  {
		
		int id = Integer.valueOf(servletRequest.getParameter("id"));
		
		alunoDao.deletaAluno(id);
		
		servletResponse.sendRedirect("listaDeAlunos.html");
		
	}
	
}
