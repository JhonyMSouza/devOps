package com.uninter;


	class Real extends Moeda {   	
 
		public Real(double valor) {		// Construtor da classe Real
			super(valor, "R$");      // Chama o construtor da classe Mãe passando o valor e o símbolo da moeda
		}

		@Override
		public void info() {         // Implementação do método info() para Real
			System.out.printf("Moeda: Real%nValor: %s%.2f%n", this.simbolo, this.valor);  // Exibe as informações da moeda
		}

		@Override
		public double converter() {		// Implementação do método converter() para Real
			return this.valor;			// Retorna o valor da moeda sem conversão
		}
}