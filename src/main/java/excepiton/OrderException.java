package excepiton;

/**
 * @program: order
 * @description: 异常处理
 * @author: 马建鹏
 * @create: 2019-06-04 10:49
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
