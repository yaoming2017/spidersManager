package com.sicdlib.util.SimilarityUtil;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by YH on 2017/5/24.
 */
public class CosSimilarity {
    public static double calculate(List<String> words1, List<String> words2) {
        //用词频来标注词的权重
        Map<String, Float> wordsWeight1 = wordsFrequency(words1);
        Map<String, Float> wordsWeight2 = wordsFrequency(words2);
        //所有的不重复词
        Set<String> words = new HashSet<>();
        words.addAll(words1);
        words.addAll(words2);
        //向量的维度为words的大小，每一个维度的权重是词频
        //a.b
        AtomicFloat ab = new AtomicFloat();
        //|a|的平方
        AtomicFloat aa = new AtomicFloat();
        //|b|的平方
        AtomicFloat bb = new AtomicFloat();
        //计算
        words
                .parallelStream()
                .forEach(word -> {
                    Float x1 = wordsWeight1.get(word);
                    Float x2 = wordsWeight2.get(word);
                    if (x1 != null && x2 != null) {
                        //x1x2
                        float oneOfTheDimension = x1 * x2;
                        //+
                        ab.addAndGet(oneOfTheDimension);
                    }
                    if (x1 != null) {
                        //(x1)^2
                        float oneOfTheDimension = x1 * x1;
                        //+
                        aa.addAndGet(oneOfTheDimension);
                    }
                    if (x2 != null) {
                        //(x2)^2
                        float oneOfTheDimension = x2 * x2;
                        //+
                        bb.addAndGet(oneOfTheDimension);
                    }
                });
        //|a|
        double aaa = Math.sqrt(aa.doubleValue());
        //|b|
        double bbb = Math.sqrt(bb.doubleValue());
        //使用BigDecimal保证精确计算浮点数
        //|a|*|b|
        //double aabb = aaa * bbb;
        BigDecimal aabb = BigDecimal.valueOf(aaa).multiply(BigDecimal.valueOf(bbb));
        //similarity=a.b/|a|*|b|
        //double cos = ab.get() / aabb.doubleValue();
        double cos = BigDecimal.valueOf(ab.get()).divide(aabb, 9, BigDecimal.ROUND_HALF_UP).doubleValue();

        return cos;
    }

    private static Map<String, Float> wordsFrequency(List<String> words){
        Map<String, AtomicInteger> frequency =new HashMap<>();
        words.forEach(word->{
            frequency.computeIfAbsent(word, k -> new AtomicInteger()).incrementAndGet();
        });

        //将权重转换纹float以便后续计算
        Map<String, Float> result = new ConcurrentHashMap<>();
        words.parallelStream().forEach(word->{
            result.put(word, frequency.get(word).floatValue());
        });
        return result;
    }
}
