package inspera.parser.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Singleton exam difference object mapper holder
 */
public class ExamDiffObjectMapper {

    private static ExamDiffObjectMapper examDiffObjectMapper;

    private ObjectMapper objectMapper;

    private ExamDiffObjectMapper() {
        initMapper();
    }

    private void initMapper() {
        objectMapper = new ObjectMapper();

        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        DateTimeFormatter zonedDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssx");

        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(localDateTimeFormatter));
        javaTimeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer(zonedDateTimeFormatter));
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(javaTimeModule);
    }

    public static ObjectMapper getObjectMapper() {
        if(examDiffObjectMapper == null)
            examDiffObjectMapper = new ExamDiffObjectMapper();
        return examDiffObjectMapper.objectMapper;
    }
}
