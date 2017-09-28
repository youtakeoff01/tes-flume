package com.cn.hand.utils;

/*import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;*/

public class JacksonUtil {

  /*  private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
    private static ObjectMapper objectMapper = null;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setSerializationInclusion(Include.NON_NULL);

    }

    private JacksonUtil() {
    }

    *//**
     * @param @param  obj
     * @param @return 参数说明
     * @return String    返回类型
     * @throws
     * @Title: beanToJson
     * @Description: TODO(Bean & List 转 JSON)
     *//*
    public static String beanToJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("beanToJson error:", e);
            ;
        }
        ;
        return null;
    }

    *//**
     * @param @param  str
     * @param @param  clazz
     * @param @return 参数说明
     * @return T    返回类型
     * @throws
     * @Title: jsonToBean
     * @Description: TODO(JSON 转 Bean)
     *//*
    public static <T> T jsonToBean(String str, Class<T> clazz) {
        try {
            return objectMapper.readValue(str, clazz);
        } catch (IOException e) {
            logger.error("jsonToBean error:", e);
        }
        return null;
    }

    public static <T> T jsonToBean(JsonNode jsonNode, Class<T> clazz) {
        try {
            if (jsonNode != null && clazz != null)
                return objectMapper.readValue(jsonNode.toString(), clazz);
        } catch (IOException e) {
            logger.error("jsonToBean error:", e);
        }
        ;
        return null;
    }

    public static <T> T jsonToCollections(String str, Class<?> collectionClass, Class<?>... elementClasses) {
        try {

            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
            return objectMapper.readValue(str, javaType);
        } catch (IOException e) {
            logger.error("jsonToBean error:", e);
        }
        return null;
    }

    public static JsonNode getJsonNode(String plain) {
        JsonNode root = null;
        try {
            root = objectMapper.readTree(plain);
        } catch (Exception e) {
            logger.error("getJsonNode error:", e);
        }
        return root;
    }

    public static ObjectNode createObjectNode() {
        return objectMapper.createObjectNode();
    }

    public static Long getLong(JsonNode jsonNode, String nodeName) {
        if (jsonNode.has(nodeName)) {
            jsonNode = jsonNode.get(nodeName);
            if (!jsonNode.isNull()) {
                return jsonNode.asLong();
            }
        }
        return null;
    }

    public static Integer getInt(JsonNode jsonNode, String nodeName) {
        if (jsonNode.has(nodeName)) {
            jsonNode = jsonNode.get(nodeName);
            if (!jsonNode.isNull()) {
                return jsonNode.asInt();
            }
        }
        return null;
    }


    public static String getString(JsonNode jsonNode, String nodeName) {
        if (jsonNode.has(nodeName)) {
            jsonNode = jsonNode.get(nodeName);
            if (!jsonNode.isNull()) {
                return jsonNode.asText();
            }
        }
        return null;
    }

    public static Boolean getBoolean(JsonNode jsonNode, String nodeName) {
        if (jsonNode.has(nodeName)) {
            jsonNode = jsonNode.get(nodeName);
            if (!jsonNode.isNull()) {
                return jsonNode.asBoolean();
            }
        }
        return null;
    }

    *//**
     * 将Map<String , Object>数据转为 String
     *
     * @param map
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     * @paramitems
     *//*
    public static String convertToJsonStrs(Map<String, String> map) throws Exception {
        if (null == map || map.isEmpty()) {
            return "";
        }
        return objectMapper.writeValueAsString(map);
    }

    *//**
     * 将json数据 转为Map<String , Object>
     *
     * @param jsonItems
     * @return
     *//*
    public static Map<String, Object> convertToMaps(String jsonItems) throws Exception {
        if (jsonItems.equals("") || jsonItems == null) {
            return null;
        }
        TypeReference<Map<String, Object>> typeReference = new TypeReference<Map<String, Object>>() {
        };
        Map<String, Object> result = objectMapper.readValue(jsonItems, typeReference);
        return result;
    }

    *//**
     * bean转map
     *
     * @param obj
     * @return
     * @throws Exception
     *//*
    public static Map<String, Object> beanToMaps(Object obj) throws Exception {
        if (obj.equals("") || obj == null) {
            return null;
        }
        String beanStr = objectMapper.writeValueAsString(obj);
        TypeReference<Map<String, Object>> typeReference = new TypeReference<Map<String, Object>>() {
        };
        Map<String, Object> result = objectMapper.readValue(beanStr, typeReference);
        return result;
    }*/
}
