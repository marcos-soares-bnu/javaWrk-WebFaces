package br.com.proway.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "indexView")
@SessionScoped
public class IndexView {

	private Cliente cliente;
	private Cliente selected;
	
	private String msg;
	private List<Cliente> lstClientes = new ArrayList<Cliente>();

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	public Cliente getSelected() {
		return selected;
	}

	public void setSelected(Cliente selected) {
		this.selected = selected;
	}

	public Cliente getCliente() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public IndexView() throws Exception {
		Conexao conexao = new Conexao();
		ClienteDAO dao = new ClienteDAO(conexao.con);
		
		List<Cliente> busca = dao.busca();
		lstClientes.addAll(busca);
	}

	public String inserir() throws Exception {

		Conexao conexao = new Conexao();
		ClienteDAO dao = new ClienteDAO(conexao.con);
		
		setMsg(dao.insere(cliente));
		return getMsg();
		//
		//lstClientes.add(cliente.getNome());
	}

	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}

}
