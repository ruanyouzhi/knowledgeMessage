package com.km.knowledgemessage.service;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.palette.LinearGradientColorPalette;
import com.km.knowledgemessage.Mapper.CardMapper;
import com.km.knowledgemessage.Mapper.UserMapper;
import com.km.knowledgemessage.Model.Card;
import com.km.knowledgemessage.Model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class KumoService {
    @Resource
    public CardMapper cardMapper;
    @Resource
    public UserMapper userMapper;
    public String getWordCloud(long cardId){

        //建立词频分析器，设置词频，以及词语最短长度，此处的参数配置视情况而定即可
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);
        //引入中文解析器
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
        //指定文本文件路径，生成词频集合
        final List<WordFrequency> wordFrequencyList;
        Card card = cardMapper.selectByPrimaryKey(cardId);
        User user = userMapper.selectByPrimaryKey(card.getCreatorId());
        List<String> words = new ArrayList<>();
        words.add(card.getCardDescription());
        words.add(card.getTitle());
        words.add(card.getCardText());
        words.add(card.getLabelName());
        words.add(card.getCardDescription());
        words.add(String.valueOf(card.getGmtCreate()));
        words.add("最近做了一个小");
        words.add("过串口通");
        words.add("运行");
        words.add("单片");
        words.add("，然后在把所有参");
        words.add("连接起");
        words.add("CSDN");
        words.add("级满意");
        words.add(")这个函数");
        words.add("C语言的标准库竟如此");
        words.add("如此强大");
        words.add("mysql的");
        words.add("ar包，");
        words.add("连接数据库，");
        words.add("-connector-jav");
        words.add("ng DRIVER_");
        words.add("IVER_CLA");
        words.add("n getConn(");
        words.add("catch (SQL");

        wordFrequencyList = frequencyAnalyzer.load(words);
        // 设置图片分辨率
        Dimension dimension = new Dimension(500, 500);
        // 此处的设置采用内置常量即可，生成词云对象
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 18);
        wordCloud.setKumoFont(new KumoFont(font));
        wordCloud.setPadding(2);
        wordCloud.setColorPalette(new ColorPalette(new Color(0xed1941), new Color(0xf26522), new Color(0x845538),new Color(0x8a5d19),new Color(0x7f7522),new Color(0x5c7a29),new Color(0x1d953f),new Color(0x007d65),new Color(0x65c294)));
        wordCloud.setBackground(new CircleBackground(200));
        wordCloud.setFontScalar(new SqrtFontScalar(10, 40));
        wordCloud.setBackgroundColor(new Color(255, 255, 255));

        wordCloud.build(wordFrequencyList);
        OutputStream output = new ByteArrayOutputStream();
        wordCloud.writeToStream("png", output);
        byte[] outputByte = ((ByteArrayOutputStream)output).toByteArray();
        return org.apache.commons.codec.binary.Base64.encodeBase64String(outputByte);
    }
}
