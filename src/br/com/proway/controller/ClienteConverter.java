package br.com.proway.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.proway.model.Cliente;

@FacesConverter("clienteconv")
public class ClienteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	Integer codigo = null;
    	
    	try {
    		//System.out.println("getAsObject: " + value);
    		codigo = Integer.valueOf(value);
    	} catch (NumberFormatException e) { }
        
    	if (value != null) {
            for (Cliente cliente : ClienteBean.lstClientes) {
                if (codigo.equals(cliente.getCodigo())) {
                    return cliente;
                }
            }
        }
        return null;
    }
    
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			Cliente cliente = (Cliente) value;
			return String.valueOf(cliente.getCodigo());
		}
		return null;
	}
	
}
