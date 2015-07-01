package br.com.proway.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "qryBuilderView")
@SessionScoped
public class qryBuilderView {

	private Cliente cliente;
	private Cliente selected;
	private String msg = "SELECT * FROM cliente";
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
	
	@SuppressWarnings("unchecked")
	public void execQry() throws Exception {
		//
		lstClientes.clear();
		//
		Conexao conexao = new Conexao();
		ClienteDAO dao = new ClienteDAO(conexao.con);
		
		List<Map<String, Object>> buscaDinamica = dao.buscaDinamica(this.msg);
		lstClientes.addAll((Collection<? extends Cliente>) buscaDinamica);
	}
	
	@SuppressWarnings("unchecked")
	public qryBuilderView() throws Exception {
		Conexao conexao = new Conexao();
		ClienteDAO dao = new ClienteDAO(conexao.con);
		
		List<Map<String, Object>> buscaDinamica = dao.buscaDinamica(this.msg);
		lstClientes.addAll((Collection<? extends Cliente>) buscaDinamica);
	}

	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}

}
