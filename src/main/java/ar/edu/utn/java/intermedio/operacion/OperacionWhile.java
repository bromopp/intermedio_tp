package ar.edu.utn.java.intermedio.operacion;

import java.util.List;

public class OperacionWhile extends Benchmark {

	@Override
	public void imprimir(List<Integer> items) {
		int i = 0;
		while (items.size() > i) {
			System.out.println(items.get(i));
			i++;
		}

	}

	@Override
	public Double sumar(List<Integer> items) {
		int i = 0;
		double suma = 0;
		while (items.size() > i) {
			suma = suma + items.get(i);
			i++;
			
		}
		
		return suma;
	}

	@Override
	public Double maximo(List<Integer> items) {
		int i = 0;
		double max = 0;
		while(items.size() > i){
			if (max < items.get(i)) {
				max = items.get(i);
			}
			i++;
		}
				
		return max;
	}

}
