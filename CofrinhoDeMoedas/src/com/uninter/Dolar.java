package com.uninter;


	class Dolar extends Moeda {		
 
		public Dolar(double valor) {		// Construtor da classe Dolar
			super(valor, "US$");			// Chama o construtor da classe Mãe passando o valor e o símbolo da moeda
		}
		 
		@Override
		public void info() {		// Implementação do método info() para Dolar			
			System.out.printf("Moeda: Dólar%nValor: %s%.2f%n", this.simbolo, this.valor); // Exibe as informações da moeda símbolo e valor
		}
 
		@Override
		public double converter() {		// Implementação do método converter() para Dolar
			return this.valor * 4.95;     // Retorna o valor da moeda com a Taxa de conversão 
		}
}
