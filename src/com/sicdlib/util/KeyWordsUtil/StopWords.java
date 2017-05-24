package com.sicdlib.util.KeyWordsUtil;

import com.sicdlib.dao.IStopWordsDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by YH on 2017/5/22.
 */
public class StopWords {
    private Set<String> stopWordsSet;

    public StopWords(Set<String> stopWordsSet) {
        this.stopWordsSet = stopWordsSet;
    }

    public StopWords(List<String> stopWordsList) {
        stopWordsSet = new HashSet<>();
        stopWordsSet.addAll(stopWordsList);
    }

    public List<String> removeStopWords(List<String> wordsList) {
        wordsList.removeAll(this.stopWordsSet);

        return wordsList;
    }
}
