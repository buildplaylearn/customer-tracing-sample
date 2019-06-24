package br.com.tracing.customer.error_handler;

import br.com.tracing.customer.dto.DefaultErrorDTO;
import br.com.tracing.customer.exception.ResourceNotFoundException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {ResourceNotFoundErrorHandler.class, ExceptionHandler.class})
public class ResourceNotFoundErrorHandler implements ExceptionHandler<ResourceNotFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, ResourceNotFoundException exception) {
        return HttpResponse.notFound(new DefaultErrorDTO(exception.getMessage()));
    }
}
