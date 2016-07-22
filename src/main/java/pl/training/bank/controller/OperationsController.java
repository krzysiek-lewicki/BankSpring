package pl.training.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.training.bank.operation.Operation;
import pl.training.bank.operation.OperationResolver;
import pl.training.bank.service.AccountsService;
import pl.training.bank.viewmodel.OperationModel;

@RequestMapping("operationForm.html")
@Controller
public class OperationsController {

    private AccountsService accountsService;
    private OperationResolver operationResolver;

    @Autowired
    public OperationsController(AccountsService accountsService, OperationResolver operationResolver) {
        this.accountsService = accountsService;
        this.operationResolver = operationResolver;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showOperationForm() {
        ModelAndView modelAndView = new ModelAndView("operationForm");
        modelAndView.addObject(new OperationModel());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processOperation(OperationModel operationModel) {
        Operation operation = operationResolver.get(operationModel.getName());
        operation.setSourceAccountNumber(operationModel.getSourceAccountNumber());
        operation.setFunds(operationModel.getFunds());
        accountsService.process(operation);

        ModelAndView modelAndView = new ModelAndView("processOperationConfirmation");
        modelAndView.addObject("operation", operationModel);
        modelAndView.addObject(accountsService.getAccountByNumber(operationModel.getSourceAccountNumber()));
        return modelAndView;
    }

}
