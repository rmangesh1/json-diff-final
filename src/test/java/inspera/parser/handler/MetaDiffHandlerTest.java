package inspera.parser.handler;

import inspera.parser.domain.Metadata;
import inspera.parser.domain.diff.MetaDiff;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MetaDiffHandlerTest {

    private MetaDiffHandler metaDiffHandler = new MetaDiffHandlerImpl(Metadata.class);

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    @Test
    public void testMetaDiffHandlerToReturnCorrectMetaDiffs() {
        //Given
        Metadata beforeMetadataObj = new Metadata("Title", LocalDateTime.parse("2016-01-20T10:00:00Z", formatter), LocalDateTime.parse("2016-01-20T16:00:00Z", formatter));
        Metadata afterMetadataObj = new Metadata("New Title", LocalDateTime.parse("2016-01-20T10:00:00Z", formatter), LocalDateTime.parse("2016-01-20T18:00:00Z", formatter));

        //Expected
        List<MetaDiff> expectedMetaDiffs = populateMetaDiffs();

        //When
        List<MetaDiff> actualMetaDiffs = metaDiffHandler.getMetaDifferences(beforeMetadataObj, afterMetadataObj);

        assertEquals(expectedMetaDiffs, actualMetaDiffs);
    }

    private List<MetaDiff> populateMetaDiffs() {
        ZoneId zoneId = ZoneId.of("Europe/Oslo");

        return Arrays.asList(
          new MetaDiff("title", "Title", "New Title"),
          new MetaDiff("endTime", LocalDateTime.parse("2016-01-20T16:00:00Z", formatter).atZone(zoneId), LocalDateTime.parse("2016-01-20T18:00:00Z", formatter).atZone(zoneId))
        );
    }
}
