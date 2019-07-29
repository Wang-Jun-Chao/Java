package wjc.java.reactor;

/**
 * event处理器的抽象类
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-29 17:11
 **/
public abstract class EventHandler {
    private InputSource source;
    public abstract void handle(Event event);

    public InputSource getSource() {
        return source;
    }

    public void setSource(InputSource source) {
        this.source = source;
    }
}
