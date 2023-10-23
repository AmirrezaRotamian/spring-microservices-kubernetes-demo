package pro.teamlead.kubepay.common.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;


@UtilityClass
public class ObjectMapperWrapper {

    private static final ObjectMapper mapper = ObjectMapperBuilder.build();

    public static <T> byte[] toJson(T obj, Class<T> tClass) throws IOException {
        return mapper.writerFor(tClass).writeValueAsBytes(obj);
    }

    public static <T> String toJsonString(T obj, Class<T> tClass) throws IOException {
        return mapper.writerFor(tClass).writeValueAsString(obj);
    }

    public static <T> String toJsonRawString(T obj) throws IOException{
        return mapper.writeValueAsString(obj);
    }

    public static <T> String toJsonString(T obj, TypeReference<T> reference) throws IOException {
        return mapper.writerFor(reference).writeValueAsString(obj);
    }

    public static <T> T fromStringJson(String json, Class<T> tClass) throws IOException {
        return mapper.readValue(json, tClass);
    }

    public static <T> T fromStringJson(String json, TypeReference<T> reference) throws IOException {
        return mapper.readValue(json, reference);
    }

    public static <T> T fromInputStream(InputStream stream, Class<T> tClass) throws IOException {
        return mapper.readerFor(tClass).readValue(stream);
    }

    public static <T> byte[] writeValueAsBytes(Object object, Class<T> tClass) throws JsonProcessingException {
        return mapper.writerFor(tClass).writeValueAsBytes(object);
    }

    public static <T> byte[] writeValueAsBytes(Object object) throws JsonProcessingException {
        return mapper.writeValueAsBytes(object);
    }

    public static <T> T readValue(byte[] data, Class<T> tClass) throws IOException {
        return mapper.readerFor(tClass).readValue(data);
    }

    public static JsonNode readTree(byte[] data) throws IOException {
        return mapper.readTree(data);
    }

    public static JsonNode readTree(InputStream is) throws IOException {
        return mapper.readTree(is);
    }

    public static JsonNode readTree(String data) throws IOException {
        return mapper.readTree(data);
    }

    public static <T> T readValue(byte[] data, TypeReference<T> reference) throws IOException {
        return mapper.readValue(data, reference);
    }

}
