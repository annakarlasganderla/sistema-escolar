package br.com.uniamerica.alunos;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.uniamerica.alunos.Dao.AlunoDao;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditarAluno extends HttpServlet {
	
	AlunoDao alunoDao = new AlunoDao();

	public void doPost(
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws IOException {
		
		int id = Integer.valueOf(servletRequest.getParameter("id"));
		
		Aluno aluno = alunoDao.getAlunoById(id);
		
		servletResponse.setContentType("text/html");
		PrintWriter printWritter = servletResponse.getWriter();
		printWritter.println("<html><head><link href=\"index.css\" rel=\"stylesheet\"></head>");
		printWritter.println("<body><div class='link'>"
				+ "<a href='menu.html'>Voltar ao Menu</a>"
				+ "</div>");
		printWritter.println(""
				+ "<div class=\"container\">\r\n"
				+ "	<form action=\"cadastrar\" method=\"post\">"
				+ "		<div class=\"box\">\r\n"
				+ "			<div class=\"title\">\r\n"
				+ "		    	<h1>Editar Aluno</h1>\r\n"
				+ "		    </div>\r\n"
				+ "		    <div class=\"input\">\r\n"
				+ "		        <label>Nome Aluno</label>\r\n"
				+ "		        <input type=\"text\" name=\"nome\" value='"+aluno.getNome()+"'>\r\n"
				+ "		    </div>\r\n"
				+ "		    <div class=\"input\">\r\n"
				+ "		    	<label>Turma</label>\r\n"
				+ "		        <input type=\"text\" name=\"turma\" value='"+aluno.getTurma()+"'>\r\n"
				+ "		    </div>\r\n"
				+ "         <input type='hidden' name='id' value='"+id+"'>"
				+ "		    <input type=\"submit\" class=\"button\" value='salvar'>\r\n"
				+ "	    </div>\r\n"
				+ "	</form>\r\n"
				+ "</div>");
		printWritter.print("</body></html>");
	}
	
}
