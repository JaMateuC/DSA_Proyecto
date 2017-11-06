package eetac.dsa;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json")

public class JSONService {
    @GET
    @Path("/got/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getTrack(@PathParam("id") int id) {
        return 0;
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public int getTrackInJSON() {
        return 1;
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(int track) {
        // Atencion: siempre añade en la misma posicion por el scope de tracks
        return Response.status(201).entity("Track added in position").build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(int track) {

        String result = "Track saved : " + track;
        return Response.status(201).entity(result).build();
    }
}
