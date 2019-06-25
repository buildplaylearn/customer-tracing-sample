package br.com.tracing.customer.error_handler;

import br.com.tracing.customer.dto.DefaultErrorDTO;
import br.com.tracing.customer.exception.CreateCustomerErrorException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

@Produces
@Singleton
@Requires(classes = {CreateCustomerErrorException.class, ExceptionHandler.class})
public class CreateCustomerErrorHandler implements ExceptionHandler<CreateCustomerErrorException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, CreateCustomerErrorException exception) {
        return HttpResponse.unprocessableEntity().body(new DefaultErrorDTO(exception.getMessage()));
    }
}
