package es.um.sisdist.backend.Service;

import es.um.sisdist.backend.Service.impl.AppLogicImpl;
import es.um.sisdist.models.UserDTO;
import es.um.sisdist.models.UserDTOUtils;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * el endpoint correspondiente a esta clase estará accesible 
 * a través de la URL que tenga "/u" como parte de la ruta.
 */

@Path("/u")
public class UsersEndpoint
{
    private AppLogicImpl impl = AppLogicImpl.getInstance();

   /** punto de entrada para una solicitud GET a la ruta "/u/{username}",
    * donde "{username}" es un parámetro de ruta que representa el nombre de usuario 
    del usuario del que se desea obtener información.
   */

   /**
    * el método produce una respuesta en formato JSON.
    */
    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUserInfo(@PathParam("username") String username)
    {
        return UserDTOUtils.toDTO(impl.getUserByEmail(username).orElse(null));
    }
}
