package pl.training.bank.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.training.bank.dto.DtoMapper;
import pl.training.bank.entity.Account;
import pl.training.bank.service.AccountsService;
import java.net.URI;

@RequestMapping(value = "api/accounts")
@RestController
public class AccountsResource {

    private AccountsService accountsService;
    private DtoMapper dtoMapper;

    @Autowired
    public AccountsResource(AccountsService accountsService, DtoMapper dtoMapper) {
        this.accountsService = accountsService;
        this.dtoMapper = dtoMapper;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create() {
        Account account = accountsService.createAccount();
        URI uri = createUriForId(account.getId());
        return ResponseEntity.created(uri).build();
    }

    private URI createUriForId(long id) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(id).toUri();
    }


}
