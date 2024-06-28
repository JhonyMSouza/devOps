package com.uninter;

import java.util.InputMismatchException;  // Importa a classe InputMismatchException do pacote java.util para tratamento de exceções
import java.util.Scanner;			// Importa a classe Scanner do pacote java.util para leitura de entrada do usuário

public class Principal {		
    
    public static void main(String[] args) {		
      
        Cofrinho cofrinho = new Cofrinho();		  // Criação do objeto cofrinho
                
        Scanner scanner = new Scanner(System.in);		// Objeto Scanner para entrada do usuário
                
        int opcao = 0;			// Variável para armazenar a opção do usuário

        
        do { 						 // Loop do menu principal inicia a estrutura de controle 
            														
            System.out.println("\n======== COFRINHO =========");   
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Calcular total convertido em Real");
            System.out.println("0. Sair");
            System.out.println("=============================");
            System.out.print("Escolha uma opção: ");

            try {     				  // Início de um bloco de código onde exceções podem ocorrer.
               
                opcao = scanner.nextInt();	  // Lê a opção do usuário

          
                switch (opcao) {				 // Executa a opção escolhida estrutura de controle que permite a seleção de uma ação
                    case 1:
                        cofrinho.adicionarMoeda();  // Adiciona moeda ao cofrinho
                        break;
                    case 2:
                        cofrinho.removerMoeda(); // Remove moeda do cofrinho
                        break;
                    case 3:
                        cofrinho.listagemMoeda();   // Lista as moedas no cofrinho
                        break;
                    case 4:
                        double totalConvertido = cofrinho.totalConvertido();     // Calcula o total convertido
                        System.out.println();
                        System.out.printf("Total convertido em Real: R$%.2f%n", totalConvertido);
                        break;
                    case 0:
                    	System.out.println();
                        System.out.println("Saindo do Cofrinho...");
                        break;
                    default:
                    	System.out.println();
                        System.out.println("Opção inválida. Tente novamente...");
                        break;
                }
            } catch (InputMismatchException e) {    //Tratamento para algo que não é um número inteiro, como uma letra ou um número decimal,
            	System.out.println();
                System.out.println("Opção inválida. Digite um número válido...");
            } finally {
                scanner.nextLine();    // Limpa o buffer do scanner
            }
        } while (opcao != 0);     // Repete até a escolha da opção sair
       
        scanner.close();       // Fecha o Scanner após o término do programa
    }
}