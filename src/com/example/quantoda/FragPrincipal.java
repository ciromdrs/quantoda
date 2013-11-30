package com.example.quantoda;

import java.util.HashMap;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragPrincipal extends Fragment {
	int fragId = R.layout.inicio_view;
	
	HashMap<String, Integer> cedulas;
	HashMap<String, Integer> moedas;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
		
		//
		
		return inflater.inflate(fragId, container, false);
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
	
	public void ativarFragJogo(){
		fragId = R.layout.jogo_view;
	}
	
	public void ativarFragInicio(){
		fragId = R.layout.inicio_view;
	}
}
