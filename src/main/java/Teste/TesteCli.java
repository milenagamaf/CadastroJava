package Teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Cliente;

class TesteCli {

	@Test
	public void testcorreto() {
		Cliente cli = new Cliente();
		cli.setNome("Maria Joaquina");
		assertEquals("Maria Joaquina", cli.getNome());
	}
	@Test
	public void testincorreto() {
		Cliente cli = new Cliente();
		cli.setNome("Maria Joaquina");
		assertEquals("Pedro", cli.getNome());
	}
	
	@Test
	public void testtelefone1() {
		Cliente cli = new Cliente();
		cli.setTelefone("99800376");
		assertEquals("99800376", cli.getTelefone());
	}
	@Test
	public void testtelefone2() {
		Cliente cli = new Cliente();
		cli.setTelefone("99800376");
		assertEquals("332355", cli.getTelefone());
	}



}

