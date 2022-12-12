package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.Conexao;

public class ClienteDao {
	
	Connection con;
	ResultSet rs;
	
	public ClienteDao() {
		con = new Conexao().conectar();
	}
	
	public void Salvar(Cliente cli) {
		
		try {
			
			String sql = "insert into cliente (nome,telefone) values (?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, cli.getNome());
			stmt.setString(2, cli.getTelefone());
			stmt.executeUpdate();
			//con.close();			
			
		}
		catch(SQLException erro) {
			System.out.println(erro);
		}
		
	}
	
	public ArrayList<Cliente>listar(){
		try {
			
			String sql = "select * from cliente";
			ArrayList<Cliente> clientes = new ArrayList<>();
			PreparedStatement stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int idcliente = rs.getInt(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				clientes.add(new Cliente(idcliente,nome,telefone));				
			}
			
			return clientes;
			
		}
		catch(Exception erro) {
			System.out.println(erro);
			return null;
		}
		
		
	}
	public void BuscaCli(Cliente cli) {
		try {
			String sql = "select * from cliente where idcliente=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, cli.getIdCliente());
			rs = stmt.executeQuery();
			while(rs.next()) {
				cli.setIdCliente(rs.getInt(1));
				cli.setNome(rs.getString(2));
				cli.setTelefone(rs.getString(3));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
public void Editar(Cliente cli) {
		
		try {
			
			String sql = "update cliente set nome=?,telefone=? where idcliente=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, cli.getNome());
			stmt.setString(2, cli.getTelefone());
			stmt.setInt(3, cli.getIdCliente());
			stmt.executeUpdate();
			//con.close();			
			
		}
		catch(SQLException erro) {
			System.out.println(erro);
		}
		
	}
	
public void Excluir(Cliente cli) {
	
	try {
		
		String sql = "delete from cliente where idcliente=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, cli.getIdCliente());
		stmt.executeUpdate();
		//con.close();			
		
	}
	catch(SQLException erro) {
		System.out.println(erro);
	}
	
}
	
	
	

}
