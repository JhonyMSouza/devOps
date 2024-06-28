package com.uninter;


	class Euro extends Moeda {		

		public Euro(double valor) {		 // Construtor da classe Euro
			super(valor, "€");			// Chama o construtor da classe Mãe passando o valor e o símbolo da moeda
		}
 
		@Override
		public void info() {		                 // Implementação do método info() para Euro			
			System.out.printf("Moeda: Euro%nValor: %s%.2f%n", this.simbolo, this.valor);  // Exibe as informações da moeda símbolo e o valor
		}
 
		@Override
		public double converter() {	  // Implementação do método converter() para Euro
			return this.valor * 5.6;   // Retorna o valor da moeda com a Taxa de conversão 
		}
}
