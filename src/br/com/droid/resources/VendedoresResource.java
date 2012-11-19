package br.com.droid.resources;

import br.com.droid.exception.NoContentException;
import br.com.droid.model.Vendedores;
import br.com.droid.business.VendedoresBusiness;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/vendedores")
public class VendedoresResource {
	
	@GET
	@Path("/buscarTodos")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Vendedores> selTodos() throws ClassNotFoundException{
		return new VendedoresBusiness().buscarTodos();
	}

	@GET
	@Path("/buscarTodosGSON")
	@Produces({MediaType.APPLICATION_JSON})
	public String selTodosGSON() throws ClassNotFoundException{
		return new Gson().toJson(new VendedoresBusiness().buscarTodos());
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Vendedores getCliente(@PathParam("id") int id) throws ClassNotFoundException{
		Vendedores vendedores = new VendedoresBusiness().buscar(id);
		if(vendedores == null)
			throw new NoContentException("Grupo não encontrado!");
		return vendedores;
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteCliente(@PathParam("id") int id) throws ClassNotFoundException{
		return new VendedoresBusiness().deletar(id);
	}
	
	@POST
	@Path("/inserir")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirCliente(Vendedores grupo) throws ClassNotFoundException {
		return new VendedoresBusiness().inserir(grupo);
	}
	
	@POST
	@Path("/inserirLista")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirLista(String listaVendedoresJson) throws ClassNotFoundException {
		Gson gson = new Gson();
		ArrayList<Vendedores> listaVendedores = new ArrayList<Vendedores>();
		JsonParser parser = new JsonParser();
                JsonArray array = parser.parse(listaVendedoresJson).getAsJsonArray();
	    
	    for (int i = 0; i < array.size(); i++) {
	    	listaVendedores.add(gson.fromJson(array.get(i), Vendedores.class));
		}
		return new VendedoresBusiness().inserirLista(listaVendedores);
	}
}
