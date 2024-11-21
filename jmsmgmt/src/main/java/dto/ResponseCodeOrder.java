package dto;

public class ResponseCodeOrder {
	
    public int code;
    public String message;
    public Order order;

    public ResponseCodeOrder(int code, String message, Order order) {
        this.code = code;
        this.message = message;
        this.order = order;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
