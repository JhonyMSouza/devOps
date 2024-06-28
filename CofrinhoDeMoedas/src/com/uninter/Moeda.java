package com.uninter;

abstract class Moeda {		
	protected double valor;		// Variável para armazenar o valor da moeda
	protected String simbolo;	// Variável para armazenar o símbolo da moeda

	
	public Moeda(double valor, String simbolo) {	// Construtor da Moeda, recebe o valor e o símbolo da moeda como parâmetros
     this.valor = valor;							 // Inicializa o valor da moeda com o valor recebido
     this.simbolo = simbolo;						// Inicializa o símbolo da moeda com o símbolo recebido
 }

 
    public abstract void info();   // Método abstrato para exibir informações sobre a moeda

 
    public abstract double converter();		// Método abstrato para converter o valor da moeda
}