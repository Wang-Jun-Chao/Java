import java.util.List;
import java.util.Map;

public interface IDemo {
    void f(int x, String y);

    int[] g(/*no args*/);

    List<Map<String, Integer>>[] h();
}
