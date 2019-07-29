package wjc.java.reactor;

/**
 * reactor模式中内部处理的event类
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-29 17:10
 **/
public class Event {
    private InputSource source;
    private EventType type;

    public InputSource getSource() {
        return source;
    }

    public void setSource(InputSource source) {
        this.source = source;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
