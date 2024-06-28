package com.uninter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cofrinho {							
    private ArrayList<Moeda> listaMoedas;  // Lista para armazenar as moedas
    private Scanner scanner;                  // Objeto Scanner para entrada do usuário

    
    public Cofrinho() {				// Construtor de Cofrinho
        listaMoedas = new ArrayList<>();      // Inicializa a lista de moedas
        scanner = new Scanner(System.in);       // Inicializa o Scanner para entrada do usuário
    }

  

    public void adicionarMoeda() {   // Método para adicionar uma moeda ao cofrinho
        int escolha = -1;		// Inicializa a variável de escolha com um valor inválido
        double valorMoeda = -1;     // Inicializa o valor da moeda com um valor inválido

        do {
            System.out.println("\nEscolha o tipo de moeda:");  
            System.out.println("1. Real");
            System.out.println("2. Dólar");
            System.out.println("3. Euro");

            escolha = obterEscolha();    // Obtém a escolha do usuário
            if (escolha == -1) {		// Verifica se a escolha é inválida
                return;           // Retorna se a escolha for inválida
            }

            if (escolha < 1 || escolha > 3) {  // Verifica se a escolha está dentro do intervalo válido
                System.out.println();
                continue;                // Volta ao início do loop para solicitar uma nova escolha
            }

            System.out.print("Digite o valor da moeda: "); 
            valorMoeda = obterValorMoeda();   // Obtém o valor da moeda do usuário

            if (valorMoeda == -1) {            // Verifica se o valor da moeda é inválido
                System.out.println("Por favor, digite um valor válido:");  
                scanner.nextLine();      // Limpa o buffer do scanner
            }
        } while (valorMoeda == -1);    //  Repete o loop se o valor da moeda for inválido        
           Moeda novaMoeda = null;  // Processo de criação da moeda e adição ao cofrinho
           switch (escolha) {          // Cria uma nova moeda com base na escolha do usuário
            case 1:
                novaMoeda = new Real(valorMoeda);
                break;
            case 2:
                novaMoeda = new Dolar(valorMoeda);
                break;
            case 3:
                novaMoeda = new Euro(valorMoeda);
                break;
        }
        if (novaMoeda != null) {           // Adiciona a nova moeda ao cofrinho se for válida
            listaMoedas.add(novaMoeda);              // Adiciona a nova moeda à lista de moedas
            System.out.println();
            System.out.println("Moeda adicionada ao cofrinho...");  
        }
    }


 
    public void removerMoeda() {   // Método para remover uma moeda do cofrinho
        
        if (listaMoedas.isEmpty()) {	// Verifica se o cofrinho está vazio
        	System.out.println();
            System.out.println("Cofrinho vazio. Não há moedas para remover...");
            return;                   // Sai do método se o cofrinho estiver vazio
        }
       
        System.out.println("\nEscolha a moeda que deseja remover:"); 
        System.out.println("1. Real");
        System.out.println("2. Dólar");
        System.out.println("3. Euro");

        
        int escolha = obterEscolha();   // Obtém a escolha do usuário

        
        if (escolha != -1) {		// Verifica se a escolha é válida Solicita o valor da moeda a ser removida      
            System.out.print("Digite o valor da moeda a ser removida: ");
            double valorMoeda = obterValorMoeda();
           
            if (valorMoeda != -1) {			              // Verifica se o valor da moeda é válido
                boolean removida = false;                         // verifica se a moeda foi removida
                for (int i = 0; i < listaMoedas.size(); i++) {        // Percorre a lista de moedas
                    Moeda moeda = listaMoedas.get(i);              // Obtém a moeda na posição                  
                    if (moeda instanceof Real && escolha == 1) {    // Verifica o tipo de moeda e se o valor corresponde à escolha do usuário
                        if (moeda.valor == valorMoeda) {                          
                            listaMoedas.remove(i);                      // Remove a moeda da lista 
                            System.out.println();
                            System.out.println("Moeda Real removida do cofrinho...");  
                            removida = true;                         // Define a flag como true
                            break;                                 // Sai do loop após remover a moeda
                        }
                    } else if (moeda instanceof Dolar && escolha == 2) {   // Repete a mesma lógica para Dólar                       
                        if (moeda.valor == valorMoeda) {
                            listaMoedas.remove(i);
                            System.out.println();
                            System.out.println("Moeda Dólar removida do cofrinho...");
                            removida = true;
                            break;
                        }
                    } else if (moeda instanceof Euro && escolha == 3) {  // Repete a mesma lógica para Euro                       
                        if (moeda.valor == valorMoeda) {
                            listaMoedas.remove(i);
                            System.out.println();
                            System.out.println("Moeda Euro removida do cofrinho...");
                            removida = true;
                            break;
                        }
                    }
                }
               
                if (!removida)    // Se a moeda não foi removida, exibe mensagem de que não foi encontrada
                    System.out.println("Moeda não encontrada no cofrinho...");
            }
        }
    }

    public void listagemMoeda() {	               	 // Método para listar as moedas no cofrinho
        if (listaMoedas.isEmpty()) {		              // Verifica se o cofrinho está vazio
        	System.out.println();
            System.out.println("Cofrinho vazio. Não há moedas para listar...");  	
        } else {
        	System.out.println("");
            System.out.println("== Moedas no cofrinho ==");		
            for (Moeda moeda : listaMoedas) {		 			// Itera sobre cada moeda na list
                System.out.println("------------------------");
                System.out.println("Moeda: " + moeda.simbolo);		
                System.out.println("Valor: " + moeda.valor);			
            }
        }
    }

   
    public double totalConvertido() {		 // Método para calcular o total convertido das moedas no cofrinho
        double total = 0;					// Inicializa o total como 0
        for (Moeda moeda : listaMoedas) {
            total += moeda.converter();     // Soma os valores convertidos de cada moeda
        }
        return total;		// Retorna o total convertido
    }

  
    
    private int obterEscolha() {		 // Método para obter a escolha do usuário
        int escolha = -1;				// Inicializa a escolha com um valor inválido
        try {
            escolha = scanner.nextInt();		// Obtém a escolha do usuário
            if (escolha < 1 || escolha > 3) {
                throw new IllegalArgumentException();   // Lança uma exceção se a escolha for inválida
            }
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida. Digite um número válido...");  
        } catch (IllegalArgumentException e) {
            System.out.println("Opção inválida. Escolha uma opção entre 1 e 3...");   
        } 
        finally {
            scanner.nextLine(); // Limpa o buffer do scanner
        }
        return escolha;  // Retorna para escolha do usuário
    }

   
    private double obterValorMoeda() {   // Método para obter o valor da moeda do usuário
        double valor = -1;			// Inicializa o valor da moeda com um valor inválido
        try {
            valor = scanner.nextDouble();   // Lê o valor da moeda do usuário
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Digite um número válido...");  
        } finally {
            scanner.nextLine(); // Limpa o buffer do scanner
        }
        return valor;   // Retorna o valor da moeda
    }
}
