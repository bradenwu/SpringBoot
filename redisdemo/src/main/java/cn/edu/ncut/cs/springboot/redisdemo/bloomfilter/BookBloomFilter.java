package cn.edu.ncut.cs.springboot.redisdemo.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookBloomFilter {
    public BloomFilter<Long> bloomFilter;
    private static final long SIZE = 1000000;

    @EventListener//监听容器初始化完成事件
    public void contextRefreshedEventListener(ContextRefreshedEvent contextRefreshedEvent) {
        bloomFilter = BloomFilter.create(Funnels.longFunnel(), SIZE);//创建布隆过滤器
        for (long i = 1; i <= SIZE; i++) {//将1-SIZE的数加入到布隆过滤器中
            bloomFilter.put(i);//将数据加入到布隆过滤器中
        }
    }

}