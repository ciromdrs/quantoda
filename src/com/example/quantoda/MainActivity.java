package com.example.quantoda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/**
	 * Método chamado ao clicar no botão sair. 
	 */
	public void sair(View v) {
		finish();
	}
	
	/**
	 * Método chamado ao clicar no botão jogar. 
	 */
	public void jogar(View v) {
		// Este é o frame que contém o fragment quando estiver num Tablet
		FrameLayout frame = (FrameLayout) findViewById(R.id.frame_grande);
		boolean telaPequena = frame == null;

		int dificuldade = 0; // Inicia o jogo no nivel 0 para somar 1 a cada iteração
		boolean perdeu = true;
		
		do {
			dificuldade += 1;
			// frag = Jogo.gerarNivel(dificuldade, telaPequena);
			if (telaPequena){
				// troca o frag pequeno
			}else{
				// coloca o frag grande
			}
			// perdeu = Resultado do jogo
		} while (!perdeu);

		// mostrar pontuções
	}
	
	/**
	 * Método chamado ao clicar no botão Ver Pontuações. 
	 */
	public void verPontuacoes(View v) {

	}

}
