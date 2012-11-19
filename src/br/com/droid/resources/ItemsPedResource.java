package br.com.droid.resources;

import br.com.droid.exception.NoContentException;
import br.com.droid.model.ItemsPed;
import br.com.droid.business.ItemsPedBusiness;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/itemsPed")
public class ItemsPedResource {
	
	@GET
	@Path("/buscarTodos")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<ItemsPed> selTodos() throws ClassNotFoundException{
		return new ItemsPedBusiness().buscarTodos();
	}

	@GET
	@Path("/buscarTodosGSON")
	@Produces({MediaType.APPLICATION_JSON})
	public String selTodosGSON() throws ClassNotFoundException{
		return new Gson().toJson(new ItemsPedBusiness().buscarTodos());
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public ItemsPed getCliente(@PathParam("id") int id) throws ClassNotFoundException{
		ItemsPed itemsPed = new ItemsPedBusiness().buscar(id);
		if(itemsPed == null)
			throw new NoContentException("Grupo não encontrado!");
		return itemsPed;
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteCliente(@PathParam("id") int id) throws ClassNotFoundException{
		return new ItemsPedBusiness().deletar(id);
	}
	
	@POST
	@Path("/inserir")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirCliente(ItemsPed grupo) throws ClassNotFoundException {
		return new ItemsPedBusiness().inserir(grupo);
	}
	
	@POST
	@Path("/inserirLista")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirLista(String listaItemsPedJson) throws ClassNotFoundException {
		Gson gson = new Gson();
		ArrayList<ItemsPed> listaItemsPed = new ArrayList<ItemsPed>();
		JsonParser parser = new JsonParser();
                JsonArray array = parser.parse(listaItemsPedJson).getAsJsonArray();
	    
	    for (int i = 0; i < array.size(); i++) {
	    	listaItemsPed.add(gson.fromJson(array.get(i), ItemsPed.class));
		}
		return new ItemsPedBusiness().inserirLista(listaItemsPed);
	}
}
