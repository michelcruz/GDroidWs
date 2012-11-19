package br.com.droid.resources;

import br.com.droid.exception.NoContentException;
import br.com.droid.model.Pedidos;
import br.com.droid.business.PedidosBusiness;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/pedidos")
public class PedidosResource {
	
	@GET
	@Path("/buscarTodos")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Pedidos> selTodos() throws ClassNotFoundException{
		return new PedidosBusiness().buscarTodos();
	}

	@GET
	@Path("/buscarTodosGSON")
	@Produces({MediaType.APPLICATION_JSON})
	public String selTodosGSON() throws ClassNotFoundException{
		return new Gson().toJson(new PedidosBusiness().buscarTodos());
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Pedidos getCliente(@PathParam("id") int id) throws ClassNotFoundException{
		Pedidos pedidos = new PedidosBusiness().buscar(id);
		if(pedidos == null)
			throw new NoContentException("Grupo não encontrado!");
		return pedidos;
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteCliente(@PathParam("id") int id) throws ClassNotFoundException{
		return new PedidosBusiness().deletar(id);
	}
	
	@POST
	@Path("/inserir")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirCliente(Pedidos grupo) throws ClassNotFoundException {
		return new PedidosBusiness().inserir(grupo);
	}
	
	@POST
	@Path("/inserirLista")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirLista(String listaPedidosJson) throws ClassNotFoundException {
		Gson gson = new Gson();
		ArrayList<Pedidos> listaPedidos = new ArrayList<Pedidos>();
		JsonParser parser = new JsonParser();
                JsonArray array = parser.parse(listaPedidosJson).getAsJsonArray();
	    
	    for (int i = 0; i < array.size(); i++) {
	    	listaPedidos.add(gson.fromJson(array.get(i), Pedidos.class));
		}
		return new PedidosBusiness().inserirLista(listaPedidos);
	}
}
