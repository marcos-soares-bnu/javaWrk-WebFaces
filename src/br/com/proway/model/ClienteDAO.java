package br.com.proway.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.ResultSetMetaData;

public class ClienteDAO {

	public String test;
	public Connection con = null;

	public ClienteDAO(Connection con) {
		this.con = con;
	}

	public String insere(Cliente cliente) throws SQLException {
		PreparedStatement pstm;
		pstm = (PreparedStatement) con
				.prepareStatement("INSERT INTO cliente(codigo,nome,cpf,rg,dataNascimento) VALUES(?,?,?,?,?); ");

		pstm.setInt(1, cliente.getCodigo());
		pstm.setString(2, cliente.getNome());
		pstm.setString(3, cliente.getCpf());
		pstm.setString(4, cliente.getRg());
		pstm.setDate(5,
				new java.sql.Date(cliente.getDataNascimento().getTime()));

		pstm.executeUpdate();
		pstm.close();

		return "Inserido (" + cliente.getNome() + ") com sucesso!";
	}

	public List<Cliente> busca() throws SQLException {
		PreparedStatement pstm;
		pstm = (PreparedStatement) con
				.prepareStatement("SELECT * FROM cliente;");

		List<Cliente> resultado = new ArrayList<Cliente>();
		ResultSet resultSet = pstm.executeQuery();
		while (resultSet.next()) {

			int codigo = resultSet.getInt(1);
			String nome = resultSet.getString(2);
			String cpf = resultSet.getString(3);
			String rg = resultSet.getString(4);
			java.util.Date dataNascimento = new java.util.Date(resultSet
					.getDate(5).getTime());

			resultado.add(new Cliente(codigo, nome, cpf, rg, dataNascimento));
		}

		pstm.close();

		return resultado;
	}

	
	public Cliente buscaPorNome(String nome) throws SQLException {

		List<Cliente> lstClientes = new ArrayList<Cliente>();
		lstClientes = busca();
		for (Cliente cliente : lstClientes) {
			if (cliente.getNome().equals(nome)){
				return cliente;
			}
		}
		return null;
	}
	
	
	public List<Map<String, Object>> buscaDinamica(String qry) throws SQLException {
		PreparedStatement pstm;
		pstm = (PreparedStatement) con
				.prepareStatement(qry + ";");

		ResultSet rs = pstm.executeQuery();

		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (rs.next()) {
		    Map<String, Object> columns = new LinkedHashMap<String, Object>();

		    for (int i = 1; i <= columnCount; i++) {
		        columns.put(metaData.getColumnLabel(i), rs.getObject(i));
		    }

		    rows.add(columns);
		}

		pstm.close();
		return rows;
	}
	
	
	public void altera(Object obj) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void exclui(Object obj) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}