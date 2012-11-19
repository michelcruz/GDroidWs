package br.com.droid.resources;

import br.com.droid.business.ClienteBusiness;
import br.com.droid.exception.NoContentException;
import br.com.droid.model.Clientes;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/cliente")
public class ClienteResource {
	
	@GET
	@Path("/buscarTodos")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Clientes> selTodos() throws ClassNotFoundException{
		return new ClienteBusiness().buscarTodos();
	}

	@GET
	@Path("/buscarTodosGSON")
	@Produces({MediaType.APPLICATION_JSON})
	public String selTodosGSON() throws ClassNotFoundException{
		return new Gson().toJson(new ClienteBusiness().buscarTodos());
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Clientes getCliente(@PathParam("id") int id) throws ClassNotFoundException{
		Clientes clientes = new ClienteBusiness().buscar(id);
		if(clientes == null) {
                throw new NoContentException("Cliente não encontrado!");
            }
		return clientes;
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteCliente(@PathParam("id") int id) throws ClassNotFoundException{
		return new ClienteBusiness().deletar(id);
	}
	
	@POST
	@Path("/inserir")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirCliente(Clientes clientes) throws ClassNotFoundException {
		return new ClienteBusiness().inserir(clientes);
	}
	
	@POST
	@Path("/inserirLista")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirLista(String listaClientesJson) throws ClassNotFoundException {
		Gson gson = new Gson();
		ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();
		JsonParser parser = new JsonParser();
                JsonArray array = parser.parse(listaClientesJson).getAsJsonArray();
	    
	    for (int i = 0; i < array.size(); i++) {
	    	listaClientes.add(gson.fromJson(array.get(i), Cliente.class));
		}
		return new ClienteBusiness().inserirLista(listaClientes);
	}
}
