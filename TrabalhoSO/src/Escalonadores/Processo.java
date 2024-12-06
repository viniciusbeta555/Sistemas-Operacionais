package Escalonadores;

public class Processo {
	
	 int id;
	 int tempoChegada;
	 int tempoExecucao;
	 int tempoInicio;
	 int tempoConclusao;
	 int tempoEspera;
	 int tempoTurnAroud;
	
	public Processo(int id, int tempoChegada, int tempoExecucao) {
		this.id = id;
		this.tempoChegada = tempoChegada;
		this.tempoExecucao = tempoExecucao;
	}	

}
