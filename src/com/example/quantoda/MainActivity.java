package com.example.quantoda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
	private String tag = "MainActivity"; // debug
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
	}

	/**
	 * Método chamado ao clicar no botão sair. 
	 */
	public void sair(View v) {
		Log.d(tag, "sair: saindo da aplicação");
		finish();
	}
	
	/**
	 * Método chamado ao clicar no botão jogar. 
	 */
	public void jogar(View v) {
		Log.d(tag, "jogar");
		Intent i = new Intent(this, JogoActivity.class);
		startActivity(i);
	}
	
	/**
	 * Método chamado ao clicar no botão Ver Pontuações.
	 */
	public void verRanking(View v) {
		Log.d(tag, "verRanking");
	}
}
