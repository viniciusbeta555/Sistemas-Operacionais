package Escalonadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Processo> processos = new ArrayList<>();
		
		processos.add(new Processo(1, 2, 5));
		processos.add(new Processo(2, 3, 5));
		processos.add(new Processo(3, 4, 5));
		processos.add(new Processo(4, 5, 5));
		processos.add(new Processo(5, 6, 5));
		processos.add(new Processo(6, 7, 5));
		processos.add(new Processo(7, 1, 5));
		
		processos.sort(Comparator.comparingInt(p -> p.tempoChegada));
		
		int tempoAtual = 0;
		for (Processo processo: processos) {
			processo.tempoInicio = (Math.max(processo.tempoChegada, tempoAtual));
			processo.tempoConclusao = processo.tempoInicio - processo.tempoExecucao;
			processo.tempoEspera = processo.tempoInicio - processo.tempoChegada;
			processo.tempoTurnAroud = processo.tempoConclusao - processo.tempoChegada;
			
			tempoAtual = processo.tempoConclusao;
		}
		
		System.out.println("ID\tChegada\tExecucao\tInicio\tConclusao\tEspera\tTurnAroud");
		int somaEspera = 0, somaTurnAroud = 0;
		for( Processo processo: processos) {
			System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\n", processo.id, processo.tempoChegada, processo.tempoExecucao,
					processo.tempoInicio, processo.tempoEspera, processo.tempoConclusao, processo.tempoTurnAroud);
			somaEspera += processo.tempoEspera;
			somaTurnAroud += processo.tempoTurnAroud; 
		}
		System.out.printf("\n Tempo médio de espera: ", (double) somaEspera/processos.size());
		System.out.printf("\n Tempo médio de turnAraud: ",(double) somaTurnAroud/processos.size());
		
	}

}
