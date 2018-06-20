package inspera.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import inspera.parser.domain.Examination;
import inspera.parser.exception.NonMatchingEntityException;
import inspera.parser.mapper.ExamDiffObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class ParserTest {

    private DiffParser parser = new ExaminationDiffParser();

    private ObjectMapper objectMapper = ExamDiffObjectMapper.getObjectMapper();

    @Parameterized.Parameters
    public static Collection<Object[]> validTestData() {
        return Arrays.asList(new Object[][] {
                {"testdata/validtest-1/before.json", "testdata/validtest-1/after.json", "testdata/validtest-1/diff.json"},
                {"testdata/validtest-2/before.json", "testdata/validtest-2/after.json", "testdata/validtest-2/diff.json"},
                {"testdata/validtest-3/before.json", "testdata/validtest-3/after.json", "testdata/validtest-3/diff.json"},
                {"testdata/validtest-4/before.json", "testdata/validtest-4/after.json", "testdata/validtest-4/diff.json"}
        });
    }

    @Parameter(0)
    public String beforeFilePath;

    @Parameter(1)
    public String afterFilePath;

    @Parameter(2)
    public String diffFilePath;

    @Test
    public void testParserToGiveCorrectDifference() throws URISyntaxException, IOException {
        //Given
        JsonNode beforeJsonNode = objectMapper.readTree(new String(Files.readAllBytes(Paths.get(ParserTest.class.getClassLoader().getResource(beforeFilePath).toURI()))));
        JsonNode afterJsonNode = objectMapper.readTree(new String(Files.readAllBytes(Paths.get(ParserTest.class.getClassLoader().getResource(afterFilePath).toURI()))));

        //Expected
        JsonNode expectedDiffJsonNode = objectMapper.readTree(new String(Files.readAllBytes(Paths.get(ParserTest.class.getClassLoader().getResource(diffFilePath).toURI()))));

        //When
        JsonNode actualDiffJsonNode = parser.parse(beforeJsonNode, afterJsonNode);

        //Then
        assertEquals(valueOf(expectedDiffJsonNode), valueOf(actualDiffJsonNode));
    }

    @Test(expected = NonMatchingEntityException.class)
    public void testParserToGiveExceptionWhenExaminationIdsAreDifferent() throws IOException, URISyntaxException {
        //Given
        JsonNode beforeJsonNode = objectMapper.readTree(new String(Files.readAllBytes(Paths.get(ParserTest.class.getClassLoader().getResource("testdata/invalidtest-1/before.json").toURI()))));
        JsonNode afterJsonNode = objectMapper.readTree(new String(Files.readAllBytes(Paths.get(ParserTest.class.getClassLoader().getResource("testdata/invalidtest-1/after.json").toURI()))));

        //Convert to POJO
        Examination beforeExaminationObj = objectMapper.convertValue(beforeJsonNode, Examination.class);
        Examination afterExaminationObj = objectMapper.convertValue(afterJsonNode, Examination.class);

        assertNotEquals(beforeExaminationObj.getId(), afterExaminationObj.getId());

        parser.parse(beforeJsonNode, afterJsonNode);
    }

}
