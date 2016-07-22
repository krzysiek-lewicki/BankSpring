package pl.training.bank.service.repository;

import java.util.List;

public class ResultPage<T> {

    private List<T> content;
    private int pageNumber;
    private int totalPages;

    public ResultPage(List<T> content, int pageNumber, int totalPages) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getTotalPages() {
        return totalPages;
    }

}
