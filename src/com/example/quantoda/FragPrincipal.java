package com.example.quantoda;

import java.util.HashMap;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragPrincipal extends Fragment {
	int fragId = R.layout.inicio_view;

	HashMap<String, Integer> cedulas;
	HashMap<String, Integer> moedas;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
		
		for (int i=0; i<Jogo.cedulas.length; i++){
			// pega o número de cédulas de um determinado valor
			int n = cedulas.get(String.valueOf(Jogo.cedulas[i]));
			if(n>0){
				//ImageView iv = ; // cria a imagem
				// adiciona ao layout
			}
		}
		
		
		
		// i.setImageResource(); // seta a imagem no componente
		
		return inflater.inflate(fragId, container, false);
	}

	private ImageView criarCedula(int n) {
		// Implementar
		/*
		if (n == 2) {
			//return new ImageView(null).setImageResource(R.drawable.)
		} else if (){
			
		} else if (){
			
		} else if (){
			
		} else if (){
			
		} else if (){
			
		} else if (){
			
		}*/
		return null;
	}

	public HashMap<String, Integer> getCedulas() {
		return cedulas;
	}

	public void setCedulas(HashMap<String, Integer> cedulas) {
		this.cedulas = cedulas;
	}

	public HashMap<String, Integer> getMoedas() {
		return moedas;
	}

	public void setMoedas(HashMap<String, Integer> moedas) {
		this.moedas = moedas;
	}

	public void ativarFragJogo() {
		fragId = R.layout.jogo_view;
	}

	public void ativarFragInicio() {
		fragId = R.layout.inicio_view;
	}
}
