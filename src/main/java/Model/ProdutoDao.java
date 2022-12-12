package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.Conexao;

public class ProdutoDao {
	
	Connection con;
	ResultSet rs;
	
	public ProdutoDao() {
		
		con = new Conexao(). conectar();		
		
	}
	
	public void Salvar(Produto pro) {

		try {	
			String sql = "insert into produto (nome,preco,quantidade) values (?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, pro.getNome());
			stmt.setDouble(2, pro.getPreco());
			stmt.setInt(3, pro.getQuantidade());
			stmt.executeUpdate();
			//con.close();
			
		}
		catch(SQLException erro) {
			
			System.out.println(erro);
			
		}
		
	}
	
	public void BuscaPro(Produto pro) {
		try {
			String sql = "select * from produto where idproduto=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, pro.getIdProduto());
			rs = stmt.executeQuery();
			while(rs.next()) {
				pro.setIdProduto(rs.getInt(1));
				pro.setNome(rs.getString(2));
				pro.setPreco(rs.getDouble(3));
				pro.setQuantidade(rs.getInt(4));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public ArrayList<Produto>listar(){
		
		try {
			
			String sql = "select * from produto";
			ArrayList<Produto> produtos = new ArrayList<>();
			PreparedStatement stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int idproduto = rs.getInt(1);
				String nome = rs.getString(2);
				Double preco = rs.getDouble(3);
				int quantidade = rs.getInt(4);
				produtos.add(new Produto(idproduto,nome,preco,quantidade));
				
			}
			
			return produtos;
			
		}catch(SQLException erro) {
			
			System.out.println(erro);
			return null;
			
		}
		
	}
	
public void Editar(Produto pro) {
		
		try {
			
			String sql = "update produto set nome=?,preco=?,quantidade=? where idproduto=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, pro.getNome());
			stmt.setDouble(2, pro.getPreco());
			stmt.setInt(3, pro.getQuantidade());
			stmt.setInt(4, pro.getIdProduto());
			stmt.executeUpdate();
			//con.close();			
			
		}
		catch(SQLException erro) {
			System.out.println(erro);
		}
		
	}
	
public void Excluir(Produto pro) {
	
	try {
		
		String sql = "delete from produto where idproduto=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, pro.getIdProduto());
		stmt.executeUpdate();
		//con.close();			
		
	}
	catch(SQLException erro) {
		System.out.println(erro);
	}
	
}
}
