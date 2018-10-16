import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Ivan Sliusar on 10.10.2018.
 * Red Line Soft corp.
 */
public class SimpleRuCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public SimpleRuCache(int capacity) {
        super(capacity + 1, 1.1f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > this.capacity;
    }
}
