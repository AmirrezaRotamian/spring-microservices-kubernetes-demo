package pro.teamlead.kubepay.common.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.experimental.UtilityClass;


@UtilityClass
public class ObjectMapperBuilder {

    /**
     * Instance
     */
    private static final ObjectMapper INSTANCE = createInstance();

    /**
     *
     * @return ObjectMapper
     */
    public static ObjectMapper build() {
        return INSTANCE;
    }

    /**
     *
     * @return ObjectMapper
     */
    private static ObjectMapper createInstance() {

//        SimpleModule module = new SimpleModule();
//        module.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());

//        Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder = new Jackson2ObjectMapperBuilder();
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        jackson2ObjectMapperBuilder.deserializers(new JsonDeserializer[]{new LocalDateDeserializer(dateFormatter)});
//        jackson2ObjectMapperBuilder.deserializers(new JsonDeserializer[]{new LocalDateTimeDeserializer(dateTimeFormatter)});
//        jackson2ObjectMapperBuilder.serializers(new JsonSerializer[]{new LocalDateSerializer(dateFormatter)});
//        jackson2ObjectMapperBuilder.serializers(new JsonSerializer[]{new LocalDateTimeSerializer(dateTimeFormatter)});
//        return jackson2ObjectMapperBuilder.build()
//                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                .registerModule(new JavaTimeModule());

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        mapper.registerModule(module);
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper;
    }
}
