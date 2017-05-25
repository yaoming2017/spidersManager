package com.sicdlib.util.KeyWordsUtil;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Native;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

/**
 * Created by YH on 2017/5/23.
 */
public class NLPIRSegmentation implements ISegmentation {
    private List<String> sourceTextList;
    private String absPath;

    public NLPIRSegmentation(List<String> sourceTextList) {
        this.sourceTextList = sourceTextList;
        this.absPath = this.getClass().getResource(".").getPath();
    }


    public interface CLibrary extends Library {
        // 定义并初始化接口的静态变量
        int NLPIR_Init(String sDataPath, int encoding, String sLicenceCode);
        String NLPIR_ParagraphProcess(String sSrc, int bPOSTagged);
//        String NLPIR_GetKeyWords(String sLine, int nMaxKeyLimit, boolean bWeightOut);
//        String NLPIR_GetFileKeyWords(String sLine, int nMaxKeyLimit, boolean bWeightOut);
        int NLPIR_AddUserWord(String sWord);
        int NLPIR_DelUsrWord(String sWord);
        String NLPIR_GetLastErrorMsg();
        void NLPIR_Exit();
    }

    @Override
    public List<String> getWordsList() {
        CLibrary instance = (CLibrary) Native.loadLibrary(
                absPath + "NLPIRFile/NLPIR", CLibrary.class);
        String argu = this.absPath + "NLPIRFile/";
        int charset_type = 1;
        int init_flag = instance.NLPIR_Init(argu, charset_type, "0");
        String nativeBytes;

        if (0 == init_flag) {
            nativeBytes = instance.NLPIR_GetLastErrorMsg();
            System.err.println("初始化失败！fail reason is " + nativeBytes);
            return null;
        }

        List<String> textList = new LinkedList<>();
        for(String text: sourceTextList) {
            String nativeStr = instance.NLPIR_ParagraphProcess(text, 0);
            String[] splitList = nativeStr.split(" ");
            for(String split: splitList) {
                textList.add(split);
            }
        }

        return textList;
    }
}
