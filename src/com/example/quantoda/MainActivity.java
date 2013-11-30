package com.example.quantoda;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
	private String tag = "MainActivity.java"; // debug
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		int fragId;
		FragPrincipal frag = new FragPrincipal();

		FragmentTransaction t = getFragmentManager().beginTransaction();

		if(telaPequena()){
			fragId = R.id.fragmento_pequeno;
		} else {
			fragId = R.id.fragmento_grande;
		}
		
		t.add(fragId, frag).commit();
	}

	/**
	 * Método chamado ao clicar no botão sair. 
	 */
	public void sair(View v) {
		Log.d(tag, "sair(View v): saindo da aplicação");
		finish();
	}
	
	/**
	 * Método chamado ao clicar no botão jogar. 
	 */
	public void jogar(View v) {
		Log.d(tag, "jogar(View v)");
		// Preparação da interface: 
		// Este é o frame que contém o fragment quando estiver num Tablet
		
		Log.d(tag, "jogar(View v):telaPequena() = " + telaPequena());
		
		int idFrag; // Identificador do Fragmento. Será setado de acordo com a tela.
		if (telaPequena()){
			idFrag = R.id.fragmento_pequeno;
		}else{
			idFrag = R.id.fragmento_grande;
		}
		
		Log.d(tag, "jogar(View v): idFrag = " + idFrag);
		
		// Preparação do jogo
		Jogo jogo = new Jogo();
		
		FragPrincipal frag = jogo.gerarNivel(); // Fragmento que irá conter o jogo
		frag.ativarFragJogo();
		
		Log.d(tag, "jogar(View v): troca de fragments");
		
		// inicia a transação para troca de Fragments
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(idFrag, frag);
        
     	transaction.addToBackStack(null); // adiciona esta Activity
       									  // à pilha do botão Back
        transaction.commit(); // Confirma a transação
	}
	
	/**
	 * Método chamado ao clicar no botão Ver Pontuações.
	 */
	public void verPontuacoes(View v) {
			
	}
	
	private boolean telaPequena(){
		return (findViewById(R.id.fragmento_grande)) == null;
	}
	
	/**
	 * Método chamado ao clicar no botão Ok, que submete o valor digitado.
	 */
	public void ok(View v){
		Log.d(tag, "ok(View v)");
	}

}
