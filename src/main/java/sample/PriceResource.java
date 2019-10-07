package sample;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.reactivestreams.Publisher;

import io.smallrye.reactive.messaging.annotations.Stream;

@Path("/prices")
public class PriceResource {
  @Inject
  @Stream("local-stream")
  Publisher<Double> prices;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "hello";
  }

  @GET
  @Path("/stream")
  @Produces(MediaType.SERVER_SENT_EVENTS)
  public Publisher<Double> stream() {
    return prices;
  }
}