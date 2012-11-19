package br.com.droid.resources;

import br.com.droid.exception.NoContentException;
import br.com.droid.model.Grupos;
import br.com.droid.business.GruposBusiness;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/grupos")
public class GruposResource {
	
	@GET
	@Path("/buscarTodos")
	@Produces({MediaType.APPLICATION_JSON})
	public ArrayList<Grupos> selTodos() throws ClassNotFoundException{
		return new GruposBusiness().buscarTodos();
	}

	@GET
	@Path("/buscarTodosGSON")
	@Produces({MediaType.APPLICATION_JSON})
	public String selTodosGSON() throws ClassNotFoundException{
		return new Gson().toJson(new GruposBusiness().buscarTodos());
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Grupos getCliente(@PathParam("id") int id) throws ClassNotFoundException{
		Grupos grupos = new GruposBusiness().buscar(id);
		if(grupos == null)
			throw new NoContentException("Grupo não encontrado!");
		return grupos;
	}
	
	@GET
	@Path("/delete/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteCliente(@PathParam("id") int id) throws ClassNotFoundException{
		return new GruposBusiness().deletar(id);
	}
	
	@POST
	@Path("/inserir")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirCliente(Grupos grupo) throws ClassNotFoundException {
		return new GruposBusiness().inserir(grupo);
	}
	
	@POST
	@Path("/inserirLista")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	public String inserirLista(String listaGruposJson) throws ClassNotFoundException {
		Gson gson = new Gson();
		ArrayList<Grupos> listaGrupos = new ArrayList<Grupos>();
		JsonParser parser = new JsonParser();
                JsonArray array = parser.parse(listaGruposJson).getAsJsonArray();
	    
	    for (int i = 0; i < array.size(); i++) {
	    	listaGrupos.add(gson.fromJson(array.get(i), Grupos.class));
		}
		return new GruposBusiness().inserirLista(listaGrupos);
	}
}
