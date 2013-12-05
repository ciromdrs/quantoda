package com.example.quantoda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;

public class JogoActivity extends Activity {
	Random rand = new Random();
	int nivel = 10;
	double resultado;

	public static int cedulas[] = { 2, 5, 10, 20, 50, 100 }; // se mudar a ordem
																// dos valores
																// dá pau
	public static double moedas[] = { 1, 0.50, 0.25, 0.10, 0.05 }; // a ordem
																	// dos
																	// valores
																	// pode
																	// interferir
																	// na
																	// dificuldade

	HashMap<String, Integer> hashMoedas;

	private String tag = "JogoActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d(tag, "gerarNivel");

		// Primeiro, gera o resultado
		resultado = 0; // zera o resultado
		resultado = rand.nextInt((int) ((nivel + 1) / 2));
		resultado += nivel;
		resultado += (rand.nextInt(21)) * 0.05; // sorteia um valor inteiro e
												// multiplica por 0.05
												// para que não seja necessário
												// usar moedas de 0.01

		Log.d(tag, "gerarNivel:resultado = " + resultado);

		Log.d(tag, "gerarNivel - quebrando o resultado em cédulas");

		ArrayList<Integer> arrayCedulas = new ArrayList<Integer>();
		// Quebrando o valor de resultado em c�dulas
		double resultado2 = resultado; // c�pia de resultado para n�o alterar o
										// seu valor.
		for (int i = cedulas.length - 1; i >= 0; i--) {
			int qtd = (int) (resultado2 / cedulas[i]); // Quantidade de cédulas necessárias
			for (int j=0; j<qtd; j++) {
				arrayCedulas.add(getResId(cedulas[i]));
			}
			resultado2 = resultado2 % cedulas[i];

			Log.d(tag, "R$ " + cedulas[i] + " = " + (resultado2 / cedulas[i]));
		}

		// Quebrando o valor de resultado em moedas
		hashMoedas = new HashMap<String, Integer>();
		for (int i = 0; i < moedas.length; i++) {
			hashMoedas.put(String.valueOf(moedas[i]),
					(int) (resultado2 / moedas[i]));
			resultado2 = resultado2 % moedas[i];

			Log.d(tag,
					String.valueOf(moedas[i])
							+ " = "
							+ String.valueOf(hashMoedas.get(String
									.valueOf(moedas[i]))));
		}

		setContentView(R.layout.activity_jogo);

		// adicionar cédulas e moedas à tela
		GridView gridview = (GridView) findViewById(R.id.dinheiro_grid);
		gridview.setAdapter(new ImageAdapter(this, arrayCedulas));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jogo, menu);
		return true;
	}

	/**
	 * Método chamado ao clicar no botão Ok, que submete o valor digitado.
	 */
	public void ok(View v) {
		Log.d(tag, "ok");
	}

	private int getResId(int valor) {
		Log.d(tag, "criarCedula");

		if (valor == 2) {
			return R.drawable.c2;
		} else if (valor == 5) {
			return R.drawable.c5;
		} else if (valor == 10) {
			return R.drawable.c10;
		} else if (valor == 20) {
			return R.drawable.c20;
		} else if (valor == 50) {
			return R.drawable.c50;
		} else if (valor == 100) {
			return R.drawable.c100;
		} else {
			return 0;
		}
	}
}
