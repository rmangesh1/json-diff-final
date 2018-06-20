package inspera.parser.handler;

import inspera.parser.builder.DateTimeMetaDiffBuilder;
import inspera.parser.builder.MetaDiffBuilder;
import inspera.parser.builder.StandardMetaDiffBuilder;
import inspera.parser.domain.Metadata;
import inspera.parser.domain.diff.MetaDiff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handler class responsible to get Metadata differences
 */
public class MetaDiffHandlerImpl implements MetaDiffHandler {

    private static final Logger logger = LoggerFactory.getLogger(MetaDiffHandlerImpl.class);

    private Class metaClass;

    private Map<Class, MetaDiffBuilder> builderStrategyMap;

    public MetaDiffHandlerImpl(Class metaClass) {
        this.metaClass = metaClass;
        this.builderStrategyMap = initStrategy();
    }

    private Map<Class, MetaDiffBuilder> initStrategy() {
        Map<Class, MetaDiffBuilder> builderStrategyMap = new HashMap<>();
        builderStrategyMap.put(LocalDateTime.class, new DateTimeMetaDiffBuilder());
        return builderStrategyMap;
    }

    public MetaDiffHandlerImpl(Class metaClass, Map<Class, MetaDiffBuilder> builderStrategyMap) {
        this.metaClass = metaClass;
        this.builderStrategyMap = builderStrategyMap;
    }

    /**
     * Returns list of MetaDiff between before and after Metadata
     * @param beforeMetadataObj
     * @param afterMetadataObj
     * @return
     */
    @Override
    public List<MetaDiff> getMetaDifferences(Metadata beforeMetadataObj, Metadata afterMetadataObj) {

        List<MetaDiff> metaDiffs = new ArrayList<>();
        MetaDiffBuilder standardMetaDiffBuilder = new StandardMetaDiffBuilder();
        MetaDiffBuilder metaDiffBuilder = null;
        Object beforeMetaVariableValue = null;
        Object afterMetaVariableValue = null;

        Field[] metaFields = metaClass.getDeclaredFields();

        try {
            for (Field field : metaFields) {
                field.setAccessible(true);
                beforeMetaVariableValue = field.get(beforeMetadataObj);
                afterMetaVariableValue = field.get(afterMetadataObj);
                if (!beforeMetaVariableValue.equals(afterMetaVariableValue)) {
                    metaDiffBuilder = builderStrategyMap.getOrDefault(field.getType(), standardMetaDiffBuilder);
                    metaDiffs.add(metaDiffBuilder.buildDiff(field, beforeMetaVariableValue, afterMetaVariableValue));
                }
            }
        } catch (IllegalAccessException e) {
            logger.error("Error during parsing/fetching Metadata values", e);
            throw new RuntimeException(e);
        }

        return metaDiffs;
    }
}
