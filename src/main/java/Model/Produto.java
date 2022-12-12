package Model;

public class Produto {
	
	private int IdProduto;
	private String Nome;
	private Double Preco;
	private int Quantidade;
	
	public int getIdProduto() {
		return IdProduto;
	}
	public void setIdProduto(int idProduto) {
		IdProduto = idProduto;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Double getPreco() {
		return Preco;
	}
	public void setPreco(Double preco) {
		Preco = preco;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	public Produto(int idProduto, String nome, Double preco, int quantidade) {
		super();
		IdProduto = idProduto;
		Nome = nome;
		Preco = preco;
		Quantidade = quantidade;
	}
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	

}
