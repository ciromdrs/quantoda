package com.example.quantoda;

import java.util.HashMap;
import java.util.Random;

import android.util.Log;

public class Jogo {
	private int nivel = 1;
	private double resultado;
	public static int cedulas[] = {2, 5, 10, 20, 50, 100}; // a ordem dos valores pode interferir na dificuldade
	public static double moedas[] = {1, 0.50, 0.25, 0.10, 0.05}; // a ordem dos valores pode interferir na dificuldade
	private Random rand = new Random();
	
	private String tag = "Jogo.java"; // tag para debug
	
	public boolean testarFimDeJogo(){
		return true;
	}
	
	public void proximoNivel(){
		Log.d(tag, "proximoNivel(): nivel anterior = " + nivel);
		nivel += 1;
		Log.d(tag, "proximoNivel(): nivel atualizado = " + nivel);
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public FragPrincipal gerarNivel() {
		Log.d(tag, "gerarNivel()");
		// Primeiro, gera o resultado
		resultado = 0; // zera o resultado
		resultado = rand.nextInt(nivel+1); // sorteia o valor inteiro das cédulas
		resultado += rand.nextInt(nivel+1) * 0.05; // sorteia um valor inteiro e multiplica por 0.05
											       // para que não seja necessário usar moedas de 0.01
		Log.d(tag, "gerarNivel(): resultado = " + resultado);
		
		// Quebrando o valor de resultado em c�dulas
		HashMap<String, Integer> hashCedulas = new HashMap<String, Integer>();
		double resultado2 = resultado; // c�pia de resultado para n�o alterar o seu valor.
		for(int i=0; i<cedulas.length; i++){
			hashCedulas.put(String.valueOf(cedulas[i]), (int) (resultado2 / cedulas[i]));
			resultado2 = resultado2%cedulas[i];
			
			Log.d(tag, String.valueOf(cedulas[i]) + " = " + String.valueOf(hashCedulas.get(String.valueOf(cedulas[i]))));
		}
		
		// Quebrando o valor de resultado em moedas
		HashMap<String, Integer> hashMoedas = new HashMap<String, Integer>();
		for(int i=0; i<moedas.length; i++){
			hashMoedas.put(String.valueOf(moedas[i]), (int) (resultado2/moedas[i]));
			resultado2 = resultado2%moedas[i];
			
			Log.d(tag, String.valueOf(moedas[i]) + " = " + String.valueOf(hashMoedas.get(String.valueOf(moedas[i]))));
		}
		
		// Agora, cria o frag e passa as hashs informando as c�dulas e moedas
		FragPrincipal fragJogo = new FragPrincipal();
		fragJogo.setCedulas(hashCedulas);
		fragJogo.setMoedas(hashCedulas);
		
		return fragJogo;
	}
	
	
}
