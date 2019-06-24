package br.com.tracing.customer.controller;

import br.com.tracing.customer.dto.CustomerDTO;
import br.com.tracing.customer.service.CustomerService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;
import io.micronaut.validation.Validated;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;

@Validated
@Controller("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Inject
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ContinueSpan
    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public CustomerDTO save(@SpanTag("x.circle.id") @Header @NotBlank String xCircleId,
                            @Body CustomerDTO customerDTO) {
        return this.customerService.saveCustomer(customerDTO);
    }

    @ContinueSpan
    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public CustomerDTO findById(@SpanTag("x.circle.id") @Header @NotBlank String xCircleId,
                                @PathVariable(name = "id") String id) {
        return this.customerService.findCustomerById(id);
    }
}
