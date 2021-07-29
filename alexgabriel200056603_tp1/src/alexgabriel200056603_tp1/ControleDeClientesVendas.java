package alexgabriel200056603_tp1;

import java.util.Scanner;

public class ControleDeClientesVendas {

	public static void main(String[] args) {
		//Declarações
		Scanner input = new Scanner(System.in);
		int opcaoMenu;//armazena a opção do usuario
		int totalClientes = 0;//armazena o total de clientes
		int totalProdutos = 0;
		int qtdCadastroCliente;//quantidade de clientes que o usuario quer cadastrar na hora de adicionar novo cliente
		int qtdCadastroProduto;
		int localNoVetorClientes = 0;//armazena o ultimo local do vetor que foi armazenado os dados
		int localNoVetorProdutos = 0;
		Cliente clientes[] = new Cliente[50];//vetor que armazena os dados dos clientes
		Produto produtos[] = new Produto[50];
		
		//instruções
		for(int i = localNoVetorClientes; i< 10; i++) {//trecho de codigo usado para gerar dados
			clientes[i] = new Cliente();
			localNoVetorClientes ++;
			produtos[i] = new Produto();
			localNoVetorProdutos++;
		}
 		totalClientes = 10;//quantidade de dados que foram gerados pelo trecho anterior
		totalProdutos = 10;//quantidade de dados que foram gerados pelo trecho anterior
		
		do {
			menu();//chama o procedimento que apresenta as opções do menu
			opcaoMenu = input.nextInt();
			switch (opcaoMenu) {
				case 1://inicia o cadastro de novo cliente
					System.out.println("Quantos clientes deseja cadastrar? ");
					qtdCadastroCliente = input.nextInt();
					totalClientes += qtdCadastroCliente;//para calcular o total de clientes cadastrados
					input.nextLine();//para limpar o teclado
					for(int i = localNoVetorClientes; i< totalClientes; i++) {
						clientes[i] = new Cliente();
						clientes[i] = cadastrarCliente();
						localNoVetorClientes ++;
					}
					break;
				case 2://busca pelo cliente no sistema
					if(totalClientes== 0) {
						System.out.println("Não há clientes cadastrados!\n");
					}else {
						System.out.print("\n----Busca por cliente----\n");
						System.out.print("Qual o nome do cliente?\nNome:");
						input.nextLine();
						String clienteProcurado = input.nextLine();
						buscaClientes(clienteProcurado, totalClientes, clientes);//chama a função que procura o cliente nos dados
					}					
					break;
				case 3://adiciona novo produto no sistema
					System.out.println("Quantos produtos deseja cadastrar? ");
					qtdCadastroProduto = input.nextInt();
					totalProdutos += qtdCadastroProduto;
					input.nextLine();
					for(int j = localNoVetorProdutos; j < totalProdutos;j++ ) {
						produtos[j] = new Produto();
						produtos[j] = cadastrarProduto();
						localNoVetorProdutos++;
					}
					break;
				case 4://busca produto no sistema
					if(totalProdutos == 0) {
						System.out.println("Não há produtos cadastrados!\n");
					}else {
						System.out.print("\n----Busca por produtos----\n");
						System.out.print("Qual o nome do produto?\nNome:");
						input.nextLine();
						String produtoProcurado = input.nextLine();
						buscaProdutos(produtoProcurado, totalProdutos, produtos);
					}
					break;
				case 5://realiza uma compra para determinado cliente
					if(totalClientes == 0 ) {
						System.out.println("Não há clientes cadastrados!\n");
					}else {
						if(totalProdutos == 0) {
							System.out.println("Não há produtos cadastrados!\n");
						}else {
							cadastroVendas( totalClientes,  clientes,  totalProdutos,  produtos);
						}
					}
					break;
				case 6:
					if(totalProdutos== 0 ) {
						System.out.println("Não há produtos cadastrados");
					}else {
						estoque( produtos,  totalProdutos);
					}				
					break;
				case 7:
					System.out.print("Até a próxima!");
					break;
				default:
					System.out.print("\nEssa opção não existe\n");
			}
		}while(opcaoMenu != 7);
	}
	public static void menu() {
		System.out.print("\n-------Menu de opções-------\n");
		System.out.print( "1- Cadastro de novo cliente.\n");
		System.out.print( "2- Busca por cliente.\n");
		System.out.print( "3- Cadastro de novo produto.\n");
		System.out.print( "4- Busca por produto.\n");
		System.out.print( "5- Cadastro de venda.\n");
		System.out.print( "6- Mostrar produtos em estoque.\n");
		System.out.print( "7- sair\n");
		System.out.print( "Digite a opção:");
	}
	
	public static Cliente cadastrarCliente() {
		//Declarações
		Cliente novoCliente = new Cliente();
		Scanner input = new Scanner(System.in);
		//Instruções
		System.out.println("\n----Cadastro de novo cliente----\n");
		System.out.print("nome: ");
		novoCliente.setNome(input.nextLine());
		System.out.print("Endereço: ");
		novoCliente.setEndereco(input.nextLine());
		System.out.print("Telefone: ");
		novoCliente.setTelefone(input.nextLine());
		System.out.println("\n--------------------------------\n");
		
		return novoCliente;
	}
	
	public static Produto cadastrarProduto() {
		//Declarações
		Produto novoProduto = new Produto();
		Scanner input = new Scanner(System.in);
		//Instruções
		System.out.print("\n----Cadastro de novo produto----\n");
		System.out.print("Nome: ");
		novoProduto.setNome(input.nextLine());
		System.out.print("Descrição: ");
		novoProduto.setDescricao(input.nextLine());
		System.out.print("Valor de compra: ");
		novoProduto.setValor(input.nextFloat());						
		System.out.print("Porcentagem de lucro: ");
		novoProduto.setPorcentagem(input.nextFloat());
		System.out.print("Quantidade em estoque: ");
		novoProduto.setQuantidade(input.nextInt());
		System.out.println("\n------------------------\n");
		
		return novoProduto;
	}
	
	public static void buscaClientes(String nomeCliente, int totalClientes, Cliente clientes[]) {
		//Declarações
		boolean encontrado = false;
		int opcaoMenu;
		Scanner input = new Scanner(System.in);
		//instruções
		for (int i = 0; i < totalClientes; i++) {
			if(nomeCliente.equalsIgnoreCase(clientes[i].getNome())) {
				System.out.print("\n----Cliente encontrado----\n");
				System.out.print("Nome: "+ clientes[i].getNome()+ "\n");
				System.out.print("endereço: "+ clientes[i].getEndereco()+ "\n");
				System.out.print("Telefone: "+ clientes[i].getTelefone()+ "\n");
				encontrado = true;
				System.out.println("Deseja alterar os dados do cliente?\n1 - sim \n2 - não");
				opcaoMenu = input.nextInt();
				if(opcaoMenu == 1) {
					do {
						System.out.println("\n----O que deseja alterar?----\n"
										 + "1- nome\n"
										 + "2- endereço\n"
										 + "3- telefone\n"
										 + "4- sair\n:");
						opcaoMenu = input.nextInt();
						switch(opcaoMenu) {
							case 1:
								System.out.println("Novo nome: ");
								input.nextLine();
								clientes[i].setNome(input.nextLine());
								break;
							case 2:
								System.out.println("Novo endereço: ");
								input.nextLine();
								clientes[i].setEndereco(input.nextLine());
								break;
							case 3:
								System.out.println("Novo telefone: ");
								input.nextLine();
								clientes[i].setTelefone(input.nextLine());
								break;
							case 4:
								System.out.println("Dados alterados com sucesso!");
								break;
							default:
								System.out.println("Opção não encontrada\n");
						}
					}while(opcaoMenu != 4);
					
				}else{
					if( opcaoMenu != 2) {
						System.out.println("Opcao não encontrada");
					}
				}
			}
		}
		if(encontrado == false) {
			System.out.print("Cliente não encontrado!");
		}
	
	}
	
	public static void buscaProdutos(String nomeProcurado, int totalProdutos, Produto produtos[]) {
		//Declarações
		int opcaoMenu;
		boolean encontrado = false;
		Scanner input = new Scanner(System.in);
		//instruções
		for(int j = 0; j < totalProdutos; j++) {
			if(nomeProcurado.equalsIgnoreCase(produtos[j].getNome())) {
				System.out.print("\n----Produto encontrado----\n");				
				System.out.print("Nome: "+ produtos[j].getNome()+ "\n");				
				System.out.print("Descrição: "+ produtos[j].getDescricao()+ "\n");			
				System.out.print("Valor de compra: "+ produtos[j].getValor()+ "\n");								
				System.out.print("Porcentagem de lucro: "+ produtos[j].getPorcentagem()+ "\n");				
				System.out.print("Quantidade em estoque: "+ produtos[j].getQuantidade()+ "\n");				
				System.out.println("\n------------------------\n");
				System.out.print("Deseja alterar os dados do produto?\n1- sim\n2- não\n");
				opcaoMenu = input.nextInt();
				if(opcaoMenu == 1) {
					do {
						System.out.println("\n----O que deseja alterar?---\n"
										 + "1- Nome\n"
										 + "2- Descrição\n"
										 + "3- Valor de compra\n"
										 + "4- Porcentagem de lucro\n"
										 + "5- Quantidade em estoque\n"
										 + "6- sair");
						opcaoMenu = input.nextInt();
						switch(opcaoMenu){
							case 1:
								System.out.print("Novo nome:");
								input.nextLine();
								produtos[j].setNome(input.nextLine());
								break;
							case 2:
								System.out.print("Nova descrição:");
								input.nextLine();
								produtos[j].setDescricao(input.nextLine());
								break;
							case 3:
								System.out.print("Novo valor:");
								produtos[j].setValor(input.nextFloat());
								break;
							case 4:
								System.out.print("Nova porcentagem de lucro: ");
								produtos[j].setPorcentagem(input.nextFloat());
								break;
							case 5:
								System.out.print("Novo quantidade em estoque:");
								produtos[j].setQuantidade(input.nextInt());
								break;
							case 6:
								System.out.println("Dados alterados com sucesso!\n");
								break;
							default:
								System.out.println("Opção não encontrada!\n");
						}
					}while(opcaoMenu != 6);
				}else {
					if(opcaoMenu != 2) {
						System.out.println("Opção não encontrada");
					}
				}
				encontrado = true;
			}
		}
		if(encontrado == false) {
			System.out.println("Produto não encontrado!");
		}
	}
	
	public static void cadastroVendas(int totalClientes, Cliente clientes[], int totalProdutos, Produto produtos[]) {
		//Declarações
		int clienteSelecionado;
		int produtoSelecionado;
		int qtdComprada = 0;
		Scanner input = new Scanner(System.in);
		//instruções
		System.out.println("\n----Lista de clientes----\n");
		for(int k = 0; k < totalClientes;k++) {
			System.out.print("\n----------------------------\n");
			System.out.print("Cliente "+ (k+1)+ "°\n");
			System.out.print("Nome: "+ clientes[k].getNome()+ "\n");
			System.out.print("endereço: "+ clientes[k].getEndereco()+ "\n");
			System.out.print("Telefone: "+ clientes[k].getTelefone()+ "\n");
			System.out.print("\n----------------------------\n");
		}
		do {
			System.out.print("Selecione o cliente entre 1 a "+totalClientes+" ou 0 para sair:");
			clienteSelecionado = input.nextInt();
			switch(clienteSelecionado) {
				case 0:
					System.out.print("\nVenda finalizada\n");
					break;
				default:
					if(clienteSelecionado < 0 || clienteSelecionado > totalClientes) {
						System.out.print("\nErro! Cliente não encontrado\n");
					}
			}
		}while( clienteSelecionado < 0 || clienteSelecionado > totalClientes );
		if(clienteSelecionado != 0) {
			do {
				for(int k = 0; k <totalProdutos;k++) {
					System.out.print("\n----------------------------\n");
					System.out.print("Produto "+ (k+1)+ "°\n");
					System.out.print("Nome: "+ produtos[k].getNome()+ "\n");				
					System.out.print("Descrição: "+ produtos[k].getDescricao()+ "\n");						
					System.out.print("Quantidade em estoque: "+ produtos[k].getQuantidade()+ "\n");				
					System.out.print("\n----------------------------\n");
				}
				System.out.print("Selecione um produto de 1 a "+ totalProdutos+ " ou 0 para sair \n:");
				produtoSelecionado = input.nextInt();
				switch(produtoSelecionado) {
					case 0:
						System.out.print("\nVenda finalizada com sucesso!\n");
						break;
					default:
						if(produtoSelecionado < 0 || produtoSelecionado > totalProdutos) {
							System.out.println("\nopção não encontrada\n");
						}else {
							System.out.print("Qual a quantidade comprada de "+produtos[produtoSelecionado-1].getNome()+" pelo cliente "+clientes[clienteSelecionado-1].getNome()+"\n:");
							qtdComprada = input.nextInt();
							if(qtdComprada > produtos[produtoSelecionado-1].getQuantidade()) {//garante que a venda não seja maior que o estoque atual do produto
								System.out.print("Não há produtos suficientes no estoque\n");
								System.out.print("Estoque de "+produtos[produtoSelecionado-1].getNome()+"= "+produtos[produtoSelecionado-1].getQuantidade());
							}else {
								produtos[produtoSelecionado-1].setQuantidade(produtos[produtoSelecionado-1].getQuantidade()-qtdComprada);
								System.out.print("\nProduto comprado!\n");
							}
						}
				}
			}while(produtoSelecionado != 0 );										
		}
	}
		
	public static void estoque(Produto produtos[], int totalProdutos) {
		//instruções
		System.out.print("\n----estoque----\n");
		for(int m = 0; m<totalProdutos; m++) {
			System.out.print("\n----------------------------\n");
			System.out.print("Nome: "+ produtos[m].getNome()+ "\n");										
			System.out.print("Quantidade em estoque: "+ produtos[m].getQuantidade()+ "\n");
			System.out.print("\n----------------------------\n");
		}
	}
}
	














