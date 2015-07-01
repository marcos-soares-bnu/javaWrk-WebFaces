package br.com.proway.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.proway.model.Cliente;
import br.com.proway.model.ClienteDAO;
import br.com.proway.model.Conexao;

@ManagedBean(name = "indexView")
@SessionScoped
public class ClienteBean {

	private Cliente cliente;
	private Cliente selected;
	
	private String msg;
	//public static final List<Cliente> LSTCLIENTES = new ArrayList<Cliente>();
	public static List<Cliente> lstClientes = new ArrayList<Cliente>();
	
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

	
	public void RefreshLstCliente() throws Exception {
		Conexao conexao = new Conexao();
		ClienteDAO dao = new ClienteDAO(conexao.con);
		
		List<Cliente> busca = dao.busca();
		lstClientes.addAll(busca);
	}
	
	
	public ClienteBean() throws Exception {
		RefreshLstCliente();
	}

	public String inserir() throws Exception {

		Conexao conexao = new Conexao();
		ClienteDAO dao = new ClienteDAO(conexao.con);
		
		setMsg(dao.insere(cliente));
		//
		lstClientes.clear();
		RefreshLstCliente();
		//
		return getMsg();
	}

	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	@SuppressWarnings("static-access")
	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}

	
	public List<Cliente> sugerirClientes(String consulta) {
        List<Cliente> clientesSugeridos = new ArrayList<>();
        
        for (Cliente cliente : lstClientes) {
            if (cliente.getNome().toLowerCase().startsWith(consulta.toLowerCase())) {
            	clientesSugeridos.add(cliente);
            }
        }
        
        return clientesSugeridos;
	}
	
	
}
