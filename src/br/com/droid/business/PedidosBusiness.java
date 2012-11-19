package br.com.droid.business;

import br.com.droid.dao.PedidosDAO;
import br.com.droid.model.Pedidos;
import java.util.ArrayList;

public class PedidosBusiness {

	public ArrayList<Pedidos> buscarTodos() throws ClassNotFoundException {
		PedidosDAO pedidosDAO = new PedidosDAO();
		return pedidosDAO.buscarTodos();
	}
	
	public String inserir(Pedidos pedidos) throws ClassNotFoundException {

		PedidosDAO pedidosDAO = new PedidosDAO();
		if(pedidosDAO.inserir(pedidos) > 0){
			return "Grupo inserido no banco com sucesso!";
		} else {
			return "Falha ao inserir o grupo no banco!";
		}
	}
	
	public String deletar(int id) throws ClassNotFoundException {
		PedidosDAO pedidosDAO = new PedidosDAO();
		if(pedidosDAO.deletar(id) > 0){
			return "Grupo removido no banco com sucesso!";
		} else {
			return "Grupo não existe!";
		}
	}
	
	public Pedidos buscar(int id) throws ClassNotFoundException {
		PedidosDAO pedidosDAO = new PedidosDAO();
		return pedidosDAO.buscar(id);
	}
	
	public String inserirLista(ArrayList<Pedidos> listaPedidos) throws ClassNotFoundException {
		PedidosDAO pedidosDAO = new PedidosDAO();
		String retorno = "";
		for (int i = 0; i < listaPedidos.size(); i++) {
			if(pedidosDAO.inserir(listaPedidos.get(i)) < 1){
				retorno += "Erro ao inserir o grupo: "+ listaPedidos.get(i).getCodPed() +"\n";
			}
		}
		if(retorno.length() == 0){
			retorno = "Lista de pedidos inserida no banco com sucesso!";
		}
		return retorno;
	}
}
