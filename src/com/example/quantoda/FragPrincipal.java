/*package com.example.quantoda;

import java.util.HashMap;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;

public class FragPrincipal extends Fragment {
	int fragId = R.layout.inicio_view;

	private Context context;
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	HashMap<String, Integer> cedulas;
	HashMap<String, Integer> moedas;

	private String tag = "FragPricipal.java";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (fragId == R.layout.jogo_view) {
			Log.d(tag, "onCreateView: fragId == jogo_view");

			for (int i = 0; i < Jogo.cedulas.length; i++) {
				// pega o número de cédulas de um determinado valor
				Log.d(tag, "onCreateView:for (i = " + i + ")");
				
				String key = String.valueOf(Jogo.cedulas[i]);
				int qtd = cedulas.get(key).intValue();
				
				Log.d(tag, "onCreateView: " + cedulas.get(key).intValue() + " cedulas de "+ key + ")");
				
				while (qtd > 0) {
					Log.d(tag, "onCreateView:while(" + qtd + " cedulas de "+ Jogo.cedulas[i] + ")");
					ImageView iv = criarCedula(Jogo.cedulas[i]); // cria a imagem
					
					container.addView(iv); // adiciona ao layout
					qtd--;
				}
			}
		}

		return inflater.inflate(fragId, container, false);
	}

	private ImageView criarCedula(int valor) {
		Log.d(tag, "criarCedula()");
		
		// Implementar
		ImageView img = new ImageView(context);
		 if (valor == 2) { 
			 img.setImageResource(R.drawable.c2);
		 } else if (valor == 5) {
			 img.setImageResource(R.drawable.c5);
		 } else if(valor == 10) {
			 img.setImageResource(R.drawable.c10);
		 } else if (valor == 20) {
			 img.setImageResource(R.drawable.c20);
		 } else if (valor == 50) {
			 img.setImageResource(R.drawable.c50);
		 } else if(valor == 100){
			 img.setImageResource(R.drawable.c100);
		 } else {
			 return null;
		 }
		img.setAdjustViewBounds(true);
		img.setMaxHeight(50);
		img.setMaxWidth(50);

		return img;
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
*/