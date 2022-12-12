
package Model;

public class Cliente {

	private int idCliente;
	private String Nome;
	private String Telefone;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	
	public Cliente(int idCliente, String nome, String telefone) {
		super();
		this.idCliente = idCliente;
		Nome = nome;
		Telefone = telefone;
	}
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
