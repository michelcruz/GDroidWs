package br.com.droid.business;

import br.com.droid.dao.VendedoresDAO;
import br.com.droid.model.Vendedores;
import java.util.ArrayList;

public class VendedoresBusiness {

	public ArrayList<Vendedores> buscarTodos() throws ClassNotFoundException {
		VendedoresDAO vendedoresDAO = new VendedoresDAO();
		return vendedoresDAO.buscarTodos();
	}
	
	public String inserir(Vendedores vendedores) throws ClassNotFoundException {

		VendedoresDAO vendedoresDAO = new VendedoresDAO();
		if(vendedoresDAO.inserir(vendedores) > 0){
			return "Grupo inserido no banco com sucesso!";
		} else {
			return "Falha ao inserir o grupo no banco!";
		}
	}
	
	public String deletar(int id) throws ClassNotFoundException {
		VendedoresDAO vendedoresDAO = new VendedoresDAO();
		if(vendedoresDAO.deletar(id) > 0){
			return "Grupo removido no banco com sucesso!";
		} else {
			return "Grupo não existe!";
		}
	}
	
	public Vendedores buscar(int id) throws ClassNotFoundException {
		VendedoresDAO vendedoresDAO = new VendedoresDAO();
		return vendedoresDAO.buscar(id);
	}
	
	public String inserirLista(ArrayList<Vendedores> listaVendedores) throws ClassNotFoundException {
		VendedoresDAO vendedoresDAO = new VendedoresDAO();
		String retorno = "";
		for (int i = 0; i < listaVendedores.size(); i++) {
			if(vendedoresDAO.inserir(listaVendedores.get(i)) < 1){
				retorno += "Erro ao inserir o grupo: "+ listaVendedores.get(i).getApelido() +"\n";
			}
		}
		if(retorno.length() == 0){
			retorno = "Lista de vendedores inserida no banco com sucesso!";
		}
		return retorno;
	}
}
