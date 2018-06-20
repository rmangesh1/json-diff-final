package inspera.parser.handler;

import inspera.parser.domain.Candidate;
import inspera.parser.domain.diff.CandidateDifference;
import inspera.parser.domain.diff.CandidateIdentifier;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CandidateDiffHandlerTest {

    private CandidateDiffHandler candidateDiffHandler = new CandidateDiffHandlerImpl();

    @Test
    public void testCandidateDiffHandlerToReturnCorrectCandidateDifferences() {
        //Given
        List<Candidate> beforeCandidates = Arrays.asList(new Candidate(1L, "C1", 10), new Candidate(2L, "C2", 20));
        List<Candidate> afterCandidates = Arrays.asList(new Candidate(1L, "C1", 20), new Candidate(3L, "C3", 20),
                new Candidate(4L, "C3", 20));

        //Excpected
        CandidateDifference expectedCandidateDifference = populateCandidateDifference();

        //When
        CandidateDifference actualCandidateDifference = candidateDiffHandler.getCandidateDifferences(beforeCandidates, afterCandidates);

        assertEquals(expectedCandidateDifference, actualCandidateDifference);

    }

    private CandidateDifference populateCandidateDifference() {
        List<CandidateIdentifier> edited = Arrays.asList(new CandidateIdentifier(1L));
        List<CandidateIdentifier> added = Arrays.asList(new CandidateIdentifier(3L), new CandidateIdentifier(4L));
        List<CandidateIdentifier> removed = Arrays.asList(new CandidateIdentifier(2L));
        return new CandidateDifference(edited, added, removed);

    }
}
