
package wjc.dubbo.demo.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/demoService")
public interface RestDemoService {
    @GET
    @Path("/hello")
    Integer hello(@QueryParam("a") Integer a, @QueryParam("b") Integer b);

    @GET
    @Path("/error")
    String error();

    @POST
    @Path("/say")
    @Consumes({MediaType.TEXT_PLAIN})
    String sayHello(String name);

    @GET
    @Path("/get_remote_application_name")
    String getRemoteApplicationName();
}
