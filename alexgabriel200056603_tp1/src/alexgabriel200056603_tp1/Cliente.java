package alexgabriel200056603_tp1;

public class Cliente {
	//Declara��es
	private String nome, endereco, telefone;
	//instru��es
	public Cliente() {
		this.nome = "Cliente";
		this.endereco = "sem endere�o";
		this.telefone = "(00)00000-0000";
	}
	//----------------------getters and setters------------------------
	public String getNome() {
		return this.nome;
	}
	public void setNome(String name) {
		 this.nome = name;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String adress) {
		 this.endereco = adress;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	public void setTelefone(String tell) {
		 this.telefone = tell;
	}
	//----------------------------------------------------------------------
}











