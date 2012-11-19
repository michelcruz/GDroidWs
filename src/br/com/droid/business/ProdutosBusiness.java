package br.com.droid.business;

import br.com.droid.dao.ProdutosDAO;
import br.com.droid.model.Produtos;
import java.util.ArrayList;

public class ProdutosBusiness {

	public ArrayList<Produtos> buscarTodos() throws ClassNotFoundException {
		ProdutosDAO produtosDAO = new ProdutosDAO();
		return produtosDAO.buscarTodos();
	}
	
	public String inserir(Produtos produtos) throws ClassNotFoundException {

		ProdutosDAO produtosDAO = new ProdutosDAO();
		if(produtosDAO.inserir(produtos) > 0){
			return "Grupo inserido no banco com sucesso!";
		} else {
			return "Falha ao inserir o grupo no banco!";
		}
	}
	
	public String deletar(int id) throws ClassNotFoundException {
		ProdutosDAO produtosDAO = new ProdutosDAO();
		if(produtosDAO.deletar(id) > 0){
			return "Grupo removido no banco com sucesso!";
		} else {
			return "Grupo não existe!";
		}
	}
	
	public Produtos buscar(int id) throws ClassNotFoundException {
		ProdutosDAO produtosDAO = new ProdutosDAO();
		return produtosDAO.buscar(id);
	}
	
	public String inserirLista(ArrayList<Produtos> listaProdutos) throws ClassNotFoundException {
		ProdutosDAO produtosDAO = new ProdutosDAO();
		String retorno = "";
		for (int i = 0; i < listaProdutos.size(); i++) {
			if(produtosDAO.inserir(listaProdutos.get(i)) < 1){
				retorno += "Erro ao inserir o grupo: "+ listaProdutos.get(i).getDesPro() +"\n";
			}
		}
		if(retorno.length() == 0){
			retorno = "Lista de produtos inserida no banco com sucesso!";
		}
		return retorno;
	}
}
