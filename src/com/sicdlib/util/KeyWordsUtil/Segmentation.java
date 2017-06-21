package com.sicdlib.util.KeyWordsUtil;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by YH on 2017/5/22.
 */
public class Segmentation implements ISegmentation{
    private List<String> sourceTextList;

    public Segmentation(List<String> sourceTextList) {
        this.sourceTextList = sourceTextList;
    }

    public Segmentation(String sourceText) {
        this.sourceTextList = new ArrayList<>();
        this.sourceTextList.add(sourceText);
    }

    @Override
    public List<String> getWordsList() {
        List<String> textList = new LinkedList<>();
        for(String text: sourceTextList) {

            text = text.replaceAll("\\d", "");

            // 创建分词对象
            StringReader reader = new StringReader(text);

            IKSegmenter ik = new IKSegmenter(reader,true);// 当为true时，分词器进行最大词长切分
            Lexeme lexeme;

            try {
                while((lexeme = ik.next())!=null) {
                    textList.add(lexeme.getLexemeText());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                reader.close();
            }
        }

        return textList;
    }
}
