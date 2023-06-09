package es.um.sisdist.backend.Service;

import java.util.Optional;

import es.um.sisdist.backend.Service.impl.AppLogicImpl;
import es.um.sisdist.models.UserDTO;
import es.um.sisdist.models.UserDTOUtils;
import es.um.sisdist.backend.dao.models.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

// POJO, no interface no extends

// verifica el login de usuario

@Path("/checkLogin")
public class CheckLoginEndpoint
{
    private AppLogicImpl impl = AppLogicImpl.getInstance();
// metodo POST
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUser(UserDTO uo)
    {
    	/** modificada por kholoud **/
        Optional<User> u = impl.checkLogin(uo.getEmail(), uo.getPassword());
        if (u.isPresent()) { // si existe return ok
        	// este metodo se modifica para incrementar visitas
        	
            return Response.ok(UserDTOUtils.toDTOLogin(u.get())).build();
        }
        else // si no existe devuelve estado de error
            return Response.status(Status.FORBIDDEN).build();
    }
}
