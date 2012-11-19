package br.com.droid.business;

import br.com.droid.dao.ClienteDAO;
import br.com.droid.model.Clientes;
import java.util.ArrayList;

public class ClienteBusiness {

	public ArrayList<Clientes> buscarTodos() throws ClassNotFoundException {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.buscarTodos();
	}
	
	public String inserir(Clientes clientes) throws ClassNotFoundException {

		ClienteDAO clienteDAO = new ClienteDAO();
		if(clienteDAO.inserir(clientes) > 0){
			return "Cliente inserido no banco com sucesso!";
		} else {
			return "Falha ao inserir o cliente no banco!";
		}
	}
	
	public String deletar(int id) throws ClassNotFoundException {
		ClienteDAO clienteDAO = new ClienteDAO();
		if(clienteDAO.deletar(id) > 0){
			return "Cliente removido no banco com sucesso!";
		} else {
			return "Cliente não existe!";
		}
	}
	
	public Clientes buscar(int id) throws ClassNotFoundException {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.buscar(id);
	}
	
	public String inserirLista(ArrayList<Clientes> listaClientes) throws ClassNotFoundException {
		ClienteDAO clienteDAO = new ClienteDAO();
		String retorno = "";
		for (int i = 0; i < listaClientes.size(); i++) {
			if(clienteDAO.inserir(listaClientes.get(i)) < 1){
				retorno += "Erro ao inserir o cliente de CPF: "+ listaClientes.get(i).getCNPJCli() +"\n";
			}
		}
		if(retorno.length() == 0){
			retorno = "Lista de clientes inserida no banco com sucesso!";
		}
		return retorno;
	}
}
