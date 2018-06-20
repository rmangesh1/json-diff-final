package inspera.parser.builder;

import inspera.parser.domain.Metadata;
import inspera.parser.domain.diff.MetaDiff;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardMetaDiffBuilderTest {

    private MetaDiffBuilder metaDiffBuilder = new StandardMetaDiffBuilder();

    @Test
    public void testStandardMetaDiffBuilderBuildingCorrectMetaDiff() throws NoSuchFieldException {
        //Expected
        MetaDiff expectedMetaDiff = new MetaDiff("title", "Title", "New Title");

        //When
        MetaDiff actualMetaDiff = metaDiffBuilder.buildDiff(Metadata.class.getDeclaredField("title"), "Title", "New Title");

        //Then
        assertEquals(expectedMetaDiff, actualMetaDiff);
    }
}
