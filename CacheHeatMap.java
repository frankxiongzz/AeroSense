package com.assure.common.component;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：ywb
 * @date ：Created in 2022/1/26 10:13
 * @modified By：
 */
@Component
public class CacheHeatMap {

    private final ConcurrentHashMap<String, byte[]> cache = new ConcurrentHashMap<>();

    /**
     *  cache heatMap to one file
     * @param radar rdarUuid
     * @param tag 0:over 1:not over
     * @param data heatMap data
     * @return more fram to one file
     */
    public byte[] cacheHeatMap(String radar, int tag, byte[] data) {
        System.out.println("进来处理:" + data.length);
        byte[] bytes1 = cache.get(radar);
        byte[] bytes2;

        if (bytes1 == null) {
            if (tag == 0) {
                return data;
            }
            //未完成，放入缓存后直接退出
            cache.put(radar, data);
            return null;
        } else {
            bytes2 = new byte[bytes1.length + data.length];
            System.arraycopy(bytes1, 0, bytes2, 0, bytes1.length);
            System.arraycopy(data, 0, bytes2, bytes1.length, data.length);
            cache.put(radar, bytes2);
            if (tag == 0) {
                cache.remove(radar);
                return bytes2;
            }
        }
        return null;
    }
}
