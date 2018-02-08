package cn.edu.zzti.pi.micro_center.util;

import java.util.*;

public final class MapUtils {

    public static <K, V> boolean putList(Map<K, List<V>> map, K key, V value) {
        List<V> l = map.get(key);
        if (null == l) {
            l = new ArrayList<>();
            map.put(key, l);
        }
        return l.add(value);
    }

    public static <K, V> boolean putSet(Map<K, Set<V>> map, K key, V value) {
        Set<V> l = map.get(key);
        if (null == l) {
            l = new HashSet<>();
            map.put(key, l);
        }
        return l.add(value);
    }
}
