package ar.edu.utn.java.intermedio.operacion;

import java.util.List;

public class OperacionFor extends Benchmark{

	@Override
	public void imprimir(List<Integer> items) {
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i));
			
		}
		
	}

	@Override
	public Double sumar(List<Integer> items) {
		double suma = 0;
		for (int i = 0; i < items.size(); i++) {
			suma = items.get(i) + suma;
		}
		return suma;
	}

	@Override
	public Double maximo(List<Integer> items) {
		double max = 0;
		for (int i = 0; i < items.size(); i++) {
			if (max < items.get(i)) {
				max= items.get(i);				
			}
		}
		
		return max;
	}

}
