package br.com.uniamerica.alunos;

public class Aluno {
	
	private String nome;
	private String turma;
	
	
	public Aluno() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", turma=" + turma + "]";
	}

}
