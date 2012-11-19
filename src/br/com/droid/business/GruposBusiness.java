package br.com.droid.business;

import br.com.droid.dao.GruposDAO;
import br.com.droid.model.Grupos;
import java.util.ArrayList;

public class GruposBusiness {

	public ArrayList<Grupos> buscarTodos() throws ClassNotFoundException {
		GruposDAO gruposDAO = new GruposDAO();
		return gruposDAO.buscarTodos();
	}
	
	public String inserir(Grupos grupos) throws ClassNotFoundException {

		GruposDAO gruposDAO = new GruposDAO();
		if(gruposDAO.inserir(grupos) > 0){
			return "Grupo inserido no banco com sucesso!";
		} else {
			return "Falha ao inserir o grupo no banco!";
		}
	}
	
	public String deletar(int id) throws ClassNotFoundException {
		GruposDAO gruposDAO = new GruposDAO();
		if(gruposDAO.deletar(id) > 0){
			return "Grupo removido no banco com sucesso!";
		} else {
			return "Grupo não existe!";
		}
	}
	
	public Grupos buscar(int id) throws ClassNotFoundException {
		GruposDAO gruposDAO = new GruposDAO();
		return gruposDAO.buscar(id);
	}
	
	public String inserirLista(ArrayList<Grupos> listaGrupos) throws ClassNotFoundException {
		GruposDAO gruposDAO = new GruposDAO();
		String retorno = "";
		for (int i = 0; i < listaGrupos.size(); i++) {
			if(gruposDAO.inserir(listaGrupos.get(i)) < 1){
				retorno += "Erro ao inserir o grupo: "+ listaGrupos.get(i).getDesGrupo() +"\n";
			}
		}
		if(retorno.length() == 0){
			retorno = "Lista de grupos inserida no banco com sucesso!";
		}
		return retorno;
	}
}
