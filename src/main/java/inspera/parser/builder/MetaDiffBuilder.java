package inspera.parser.builder;

import inspera.parser.domain.diff.MetaDiff;

import java.lang.reflect.Field;

/**
 * Interface for meta diff building
 * @param <T>
 */
public interface MetaDiffBuilder<T> {

    MetaDiff buildDiff(Field field, T beforeObj, T afterObj);

}
