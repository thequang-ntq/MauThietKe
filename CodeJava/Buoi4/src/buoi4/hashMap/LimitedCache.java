package buoi4.hashMap;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class LimitedCache<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public LimitedCache(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize; // Xóa phần tử lâu đời nhất nếu vượt quá maxSize
    }
}
