package br.com.uniamerica.alunos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.uniamerica.alunos.Dao.AlunoDao;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CadastrarAluno extends HttpServlet {
	

	public void doPost(
			HttpServletRequest servletRequest,
			HttpServletResponse servletResponse) throws IOException {
		
		Aluno aluno = new Aluno();
		
		int id = -1;
		
		if(servletRequest.getParameter("id") != null) {
			id = Integer.valueOf(servletRequest.getParameter("id"));
		}
		
		aluno.setNome(servletRequest.getParameter("nome"));
		aluno.setTurma(servletRequest.getParameter("turma"));
		
		if(aluno.getNome() == " " || aluno.getTurma() == " ") {
			System.out.print("Por favor, preencher todos os campos =)");
		}
		
		AlunoDao alunoDao = new AlunoDao();
		
		if(id >= 0) {
			alunoDao.editaAluno(id, aluno);
		} else {
			alunoDao.criaTabelaAluno(aluno);
		}
		
		
		
		
		servletResponse.sendRedirect("listaDeAlunos.html");
	}
	

}
