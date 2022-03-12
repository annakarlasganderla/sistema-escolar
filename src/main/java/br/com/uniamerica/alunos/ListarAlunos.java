package br.com.uniamerica.alunos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.uniamerica.alunos.Dao.AlunoDao;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarAlunos extends HttpServlet {
	

	public void doPost(
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws IOException {
		
		Aluno aluno = new Aluno();
		
		AlunoDao alunoDao = new AlunoDao();
		List<Aluno> listarAlunos = alunoDao.listarAlunos();
		
		PrintWriter printWritter = servletResponse.getWriter();
		servletResponse.setContentType("text/html");
		
		printWritter.println("<html><head><link href=\"./styles/listaAlunos.css\" rel=\"stylesheet\"></head>");
		printWritter.println("<body>"
				+ "<button class='link'>"
				+ "		<a href='aluno.html'>+</a>"
				+ "</button>");
		printWritter.println("<h1>Lista De Alunos</h1>");
		
		printWritter.print("<table>");
		printWritter.print("<tr>"
							+ "<th>Nome</th>"
							+ "<th>Turma</th>"
							+ "<th>Ações</th>"
						+ "</tr>");
		
		for(int i = 0; i < listarAlunos.size(); i++) {
			printWritter.println("<tr>"
					+ "<td>"+ listarAlunos.get(i).getNome() + "</td>"
	    	   		+ "<td>" + listarAlunos.get(i).getTurma() + "</td>"
	   				+ "<td><div class='options'>"
	   				+ "<form action='editarAluno' method='post'>"
	   					+ "<input type='hidden' name='id' value='"+ i +"'>"
	   					+ "<button type='submit' class='edit'>Editar</button>"
	   				+ "</form>"
	   				+ "<form action='apagarAluno' method='post'>"
	   					+ "<input type='hidden' name='id' value='"+ i +"'>"
						+ "<button type='submit' class='edit'>Apagar</button>"
	   				+ "</form>"
	   				+ "</div></td></tr>");
		
		}
		printWritter.print("</table></body></html>");
	}
	

}
