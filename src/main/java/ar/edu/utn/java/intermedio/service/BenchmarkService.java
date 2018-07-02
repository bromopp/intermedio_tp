package ar.edu.utn.java.intermedio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import ar.edu.utn.java.intermedio.domain.BenchmarkResponse;
import ar.edu.utn.java.intermedio.operacion.Benchmark;
import ar.edu.utn.java.intermedio.operacion.OperacionFor;
import ar.edu.utn.java.intermedio.operacion.OperacionStreams;
import ar.edu.utn.java.intermedio.operacion.OperacionWhile;

@Service
public class BenchmarkService {
	
	private static final Integer CANTIDAD_MAXIMA_ITEMS = 50000000;
	
	public BenchmarkResponse imprimir(Integer cantidadItems) {
		
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new RuntimeException(String.format("Error: la cantidad maximo de items %d no debe superar el valor %d", 
					cantidadItems, CANTIDAD_MAXIMA_ITEMS));
		}
		
		BenchmarkResponse response = inicializarResponse(cantidadItems);		
		long tiempo = System.currentTimeMillis();
		
		//TiempoImprimirStream
		tiempo = System.currentTimeMillis();
		
		Benchmark operacion = new OperacionStreams();
		operacion.imprimirListado(response.getItems());
		
		response.setTiempoStreams((System.currentTimeMillis() - tiempo) );
		
		//TiempoImprimirFor
		tiempo = System.currentTimeMillis();
		
		Benchmark operacionFor = new OperacionFor();
		operacionFor.imprimirListado(response.getItems());
		response.setTiempoFor(System.currentTimeMillis()- tiempo);
		
		//TiempoImprimirWhile
		tiempo = System.currentTimeMillis();
		
		Benchmark operacionWhile = new OperacionWhile();
		operacionWhile.imprimirListado(response.getItems());
		response.setTiempoWhile(System.currentTimeMillis()- tiempo);
		
		
		return response;
	}

	public BenchmarkResponse sumar(Integer cantidadItems) {
		
		BenchmarkResponse response = inicializarResponse(cantidadItems);
		long tiempo = System.currentTimeMillis();
		
		//TiempoSumarStream
			tiempo = System.currentTimeMillis();
			
			Benchmark operacion = new OperacionStreams();
			response.setResultado(operacion.sumarValores(response.getItems()));
			response.setTiempoStreams((System.currentTimeMillis() - tiempo) );
		
		//TiempoSumarFor
		tiempo = System.currentTimeMillis();
				
			Benchmark operacionFor = new OperacionFor();
			response.setResultado(operacionFor.sumarValores(response.getItems()));
			response.setTiempoFor(System.currentTimeMillis()- tiempo);
				
		//TiempoSumarWhile
		tiempo = System.currentTimeMillis();
			
			Benchmark operacionWhile = new OperacionWhile();
			response.setResultado(operacionWhile.sumarValores(response.getItems()));
			response.setTiempoWhile(System.currentTimeMillis()- tiempo);
			
		return response;
	}
	
	public BenchmarkResponse maximo(Integer cantidadItems) {
		
		BenchmarkResponse response = inicializarResponse(cantidadItems);
		long tiempo = System.currentTimeMillis();
	
		//TiempoMaxStream
		tiempo = System.currentTimeMillis();
		
			Benchmark operacion = new OperacionStreams();
			response.setResultado(operacion.maximoValor(response.getItems()));
			response.setTiempoStreams((System.currentTimeMillis() - tiempo) );
		
		//TiempoMaxFor
		tiempo = System.currentTimeMillis();
		
			Benchmark operacionFor = new OperacionFor();
			response.setResultado(operacionFor.maximoValor(response.getItems()));
			response.setTiempoFor((System.currentTimeMillis() - tiempo));
		
		//TiempoMaxWhile
		tiempo = System.currentTimeMillis();
			
			Benchmark operacionWhile = new OperacionWhile();
			response.setResultado(operacionWhile.maximoValor(response.getItems()));
			response.setTiempoWhile((System.currentTimeMillis() - tiempo));
			
		return response;
	}
	
	private List<Integer> generarItems(Integer cantidadItems){
		List<Integer> items = new ArrayList<>();
		Random rand= new Random();
		for(int i = 0; i < cantidadItems; i++) {
			items.add(rand.nextInt(cantidadItems)+1);
		}
		return items;
	}

	private BenchmarkResponse inicializarResponse(Integer cantidadItems) {
		BenchmarkResponse response = new BenchmarkResponse();
		List<Integer> items = generarItems(cantidadItems);
		response.setItems(items);
		return response;
	}
	
}
