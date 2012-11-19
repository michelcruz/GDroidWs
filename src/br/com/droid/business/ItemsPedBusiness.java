package br.com.droid.business;

import br.com.droid.dao.ItemsPedDAO;
import br.com.droid.model.ItemsPed;
import java.util.ArrayList;

public class ItemsPedBusiness {

	public ArrayList<ItemsPed> buscarTodos() throws ClassNotFoundException {
		ItemsPedDAO itemsPedDAO = new ItemsPedDAO();
		return itemsPedDAO.buscarTodos();
	}
	
	public String inserir(ItemsPed itemsPed) throws ClassNotFoundException {

		ItemsPedDAO itemsPedDAO = new ItemsPedDAO();
		if(itemsPedDAO.inserir(itemsPed) > 0){
			return "Itens inseridos no banco com sucesso!";
		} else {
			return "Falha ao inserir o Itens no banco!";
		}
	}
	
	public String deletar(int id) throws ClassNotFoundException {
		ItemsPedDAO itemsPedDAO = new ItemsPedDAO();
		if(itemsPedDAO.deletar(id) > 0){
			return "Item removidos no banco com sucesso!";
		} else {
			return "Item não existe!";
		}
	}
	
	public ItemsPed buscar(int id) throws ClassNotFoundException {
		ItemsPedDAO itemsPedDAO = new ItemsPedDAO();
		return itemsPedDAO.buscar(id);
	}
	
	public String inserirLista(ArrayList<ItemsPed> listaItemsPed) throws ClassNotFoundException {
		ItemsPedDAO itemsPedDAO = new ItemsPedDAO();
		String retorno = "";
		for (int i = 0; i < listaItemsPed.size(); i++) {
			if(itemsPedDAO.inserir(listaItemsPed.get(i)) < 1){
				retorno += "Erro ao inserir o item: "+ listaItemsPed.get(i).getPedidos() +"\n";
			}
		}
		if(retorno.length() == 0){
			retorno = "Lista de Itens inserida no banco com sucesso!";
		}
		return retorno;
	}
}
