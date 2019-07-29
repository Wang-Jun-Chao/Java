package wjc.java.reactor;

/**
 * 输入对象，reactor模式中处理的原始输入对象
 *
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-29 17:10
 **/
public class InputSource {
    private Object data;
    private long id;

    public InputSource(Object data, long id) {
        this.data = data;
        this.id = id;
    }

    @Override
    public String toString() {
        return "InputSource{" +
                "data=" + data +
                ", id=" + id +
                '}';
    }
}
