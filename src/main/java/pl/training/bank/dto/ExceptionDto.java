package pl.training.bank.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exception")
public class ExceptionDto {

    public enum Type {

        APPLICATION_EXCEPTION, ACCOUNT_NOT_FOUND, INSUFFICIENT_FUNDS, UNKNOWN_OPERATION

    }

    private Type type;

    public ExceptionDto() {
    }

    public ExceptionDto(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
