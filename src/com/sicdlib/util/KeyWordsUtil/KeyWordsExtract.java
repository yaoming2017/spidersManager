package com.sicdlib.util.KeyWordsUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

/**
 * Created by YH on 2017/5/22.
 */
public class KeyWordsExtract {
    /**
     * 阻尼系数，一般取值为0.85
     */
    static final float d = 0.85f;
    /**
     * 最大迭代次数
     */
    static final int max_iter = 200;
    static final float min_diff = 0.001f;

    public List<Map.Entry<String, Float>> getKeyword(List<String> sList, List<String> stops) {
        // 分词
        ISegmentation seg = new Segmentation(sList);
        List<String> segList = seg.getWordsList();

        //去除停用词
        StopWords stopWords = new StopWords(stops);
        List<String> wordList = stopWords.removeStopWords(segList);

        Map<String, Set<String>> words = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        for (String w : wordList) {
            if (!words.containsKey(w)) {
                words.put(w, new HashSet<>());
            }

            que.offer(w);
            if (que.size() > 10) {
                que.poll();
            }

            for (String w1 : que) {
                for (String w2 : que) {
                    if (w1.equals(w2)) {
                        continue;
                    }

                    words.get(w1).add(w2);
                    words.get(w2).add(w1);
                }
            }
        }

        Map<String, Float> score = new HashMap<>();
        for (int i = 0; i < max_iter; ++i) {
            Map<String, Float> m = new HashMap<>();
            float max_diff = 0;
            for (Map.Entry<String, Set<String>> entry : words.entrySet()) {
                String key = entry.getKey();
                Set<String> value = entry.getValue();
                m.put(key, 1 - d);
                for (String other : value) {
                    int size = words.get(other).size();
                    if (key.equals(other) || size == 0) continue;
                    m.put(key, m.get(key) + d / size * (score.get(other) == null ? 0 : score.get(other)));
                }
                max_diff = Math.max(max_diff, Math.abs(m.get(key) - (score.get(key) == null ? 0 : score.get(key))));
            }
            score = m;
            if (max_diff <= min_diff) break;
        }
        List<Map.Entry<String, Float>> entryList = new ArrayList<>(score.entrySet());
        Collections.sort(entryList, (o1, o2) -> (o1.getValue() - o2.getValue() > 0 ? -1 : 1));

        if (entryList.size() > 1000) {
            return entryList.subList(0, 1000);
        }

        return entryList;
    }

}
