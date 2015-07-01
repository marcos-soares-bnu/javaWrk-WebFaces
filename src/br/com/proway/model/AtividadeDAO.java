package br.com.proway.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO {

	public Connection con = null;

	public AtividadeDAO(Connection con) {
		this.con = con;
	}

	public String insere(Atividade atividade) throws SQLException {
		PreparedStatement pstm;
		pstm = (PreparedStatement) con
				.prepareStatement("INSERT INTO Atividade(codigo,titulo,descricao,codigocliente) VALUES(?,?,?,?); ");

		pstm.setInt(1, atividade.getCodigo());
		pstm.setString(2, atividade.getTitulo());
		pstm.setString(3, atividade.getDescricao());
		pstm.setInt(4, atividade.getCodigocliente());

		pstm.executeUpdate();
		pstm.close();

		return "Inserido (" + atividade.getTitulo() + ") com sucesso!";
	}

	public List<Atividade> busca() throws SQLException {
		PreparedStatement pstm;
		pstm = (PreparedStatement) con
				.prepareStatement("SELECT * FROM Atividade;");

		List<Atividade> resultado = new ArrayList<Atividade>();
		ResultSet resultSet = pstm.executeQuery();
		while (resultSet.next()) {

			int codigo = resultSet.getInt(1);
			String titulo = resultSet.getString(2);
			String descricao = resultSet.getString(3);
			int codigocliente = resultSet.getInt(4);

			resultado.add(new Atividade(codigo, titulo, descricao, codigocliente));
		}

		pstm.close();

		return resultado;
	}
	
	public void altera(Object obj) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void exclui(Object obj) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
