package wjc.java.reactor;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-07-29 17:13
 **/
public class Server {
    private Selector   selector    = new Selector();
    private Dispatcher eventLooper = new Dispatcher(selector);
    private Acceptor   acceptor;

    Server(int port) {
        acceptor = new Acceptor(selector, port);
    }

    public void start() {
        eventLooper.registEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        eventLooper.handleEvents();
    }

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public Dispatcher getEventLooper() {
        return eventLooper;
    }

    public void setEventLooper(Dispatcher eventLooper) {
        this.eventLooper = eventLooper;
    }

    public Acceptor getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(Acceptor acceptor) {
        this.acceptor = acceptor;
    }
}
