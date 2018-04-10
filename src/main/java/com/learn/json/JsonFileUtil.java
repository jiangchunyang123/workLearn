package com.learn.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class JsonFileUtil {
    static Logger logger = LoggerFactory.getLogger(JsonFileUtil.class);
    static ObjectMapper objMapper = new ObjectMapper();

    public static void readJsonFile(String filePath) {
        JsonNode rootNode = null;
        try {
            rootNode = objMapper.readTree(new File(filePath));
            findChildren(rootNode.findPath("children"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获得 json 字符串
        String strResult = rootNode.toString();
        logger.info("jsonresult:" + strResult);
    }

    static void findChildren(JsonNode jsonNode) {
        if (jsonNode.isArray()) {
            Iterator<JsonNode> iter = jsonNode.elements();
            while (iter.hasNext()) {
                JsonNode node = iter.next();
                JsonNode children = node.findPath("children");
                if (children != null && !"".equals(children.toString())) {
                    logger.info("现在进行到目录:"+node.get("title")+" 仍有子目录:"+children.toString());

                    findChildren(children);
                } else if(!StringUtils.isEmpty(node.get("uri"))){
                    logger.info(node.get("uri")+":"+node.get("title"));
                }
            }
        }
    }

}
