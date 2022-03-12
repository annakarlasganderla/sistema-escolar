package br.com.uniamerica.alunos.Dao;

import java.util.ArrayList;
import java.util.List;


import br.com.uniamerica.alunos.Aluno;

public class AlunoDao {
	
	private static List<Aluno> listaDeAlunos = new ArrayList<>();
	
	public AlunoDao() {
	}
	
	public void criaTabelaAluno(Aluno aluno) {
		this.listaDeAlunos.add(aluno);
	}
	
	public List<Aluno> listarAlunos(){
		return this.listaDeAlunos;
	}
	
	public Aluno getAlunoById(int id) {
		return this.listaDeAlunos.get(id);
	}
	
	public void editaAluno(int id, Aluno aluno) {
		this.listaDeAlunos.set(id, aluno);
	}
	
	public void deletaAluno(int id) {
		this.listaDeAlunos.remove(id);
	}

}
