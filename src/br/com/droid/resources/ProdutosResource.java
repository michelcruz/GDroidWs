package br.com.droid.resources;

import br.com.droid.exception.NoContentException;
import br.com.droid.model.Produtos;
import br.com.droid.business.ProdutosBusiness;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/produtos")
public class ProdutosResource {
	
	@GET
	@Path("/buscarTodos")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Produtos> selTodos() throws ClassNotFoundException{
		return new ProdutosBusiness().buscarTodos();
	}

	@GET
	@Path("/buscarTodosGSON")
	@Produces({MediaType.APPLICATION_JSON})
	public String selTodosGSON() throws ClassNotFoundException{
		return new Gson().toJson(new ProdutosBusiness().buscarTodos());
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Produtos getCliente(@PathParam("id") int id) throws ClassNotFoundException{
		Produtos produtos = new ProdutosBusiness().buscar(id);
		if(produtos == null)
			throw new NoContentException("Grupo não encontrado!");
		return produtos;
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteCliente(@PathParam("id") int id) throws ClassNotFoundException{
		return new ProdutosBusiness().deletar(id);
	}
	
	@POST
	@Path("/inserir")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirCliente(Produtos grupo) throws ClassNotFoundException {
		return new ProdutosBusiness().inserir(grupo);
	}
	
	@POST
	@Path("/inserirLista")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirLista(String listaProdutosJson) throws ClassNotFoundException {
		Gson gson = new Gson();
		ArrayList<Produtos> listaProdutos = new ArrayList<Produtos>();
		JsonParser parser = new JsonParser();
                JsonArray array = parser.parse(listaProdutosJson).getAsJsonArray();
	    
	    for (int i = 0; i < array.size(); i++) {
	    	listaProdutos.add(gson.fromJson(array.get(i), Produtos.class));
		}
		return new ProdutosBusiness().inserirLista(listaProdutos);
	}
}
