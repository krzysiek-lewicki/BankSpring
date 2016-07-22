package pl.training.bank.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "accounts")
public class AccountsListDto {

    @XmlElement(name = "account")
    private List<AccountDto> accounts;
    private int pageNumber;
    private int totalPages;

    public AccountsListDto() {
    }

    public AccountsListDto(List<AccountDto> accounts, int pageNumber, int totalPages) {
        this.accounts = accounts;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

    public List<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
