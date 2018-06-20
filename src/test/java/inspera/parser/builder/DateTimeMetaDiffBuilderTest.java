package inspera.parser.builder;

import inspera.parser.domain.Metadata;
import inspera.parser.domain.diff.MetaDiff;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.Assert.assertEquals;

public class DateTimeMetaDiffBuilderTest {

    private MetaDiffBuilder metaDiffBuilder = new DateTimeMetaDiffBuilder();

    @Test
    public void testDateTimeMetaDiffBuilderBuildingCorrectMetaDiff() throws NoSuchFieldException {
        //Given
        LocalDateTime beforeDateTime = LocalDateTime.now();
        LocalDateTime afterDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("Europe/Oslo");
        MetaDiff expectedMetaDiff = new MetaDiff("endTime", beforeDateTime.atZone(zoneId), afterDateTime.atZone(zoneId));

        //When
        MetaDiff actualMetaDiff = metaDiffBuilder.buildDiff(Metadata.class.getDeclaredField("endTime"), beforeDateTime, afterDateTime);

        //Then
        assertEquals(expectedMetaDiff, actualMetaDiff);
    }

}
