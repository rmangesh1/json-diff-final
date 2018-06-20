package inspera.parser.handler;

import inspera.parser.domain.Candidate;
import inspera.parser.domain.diff.CandidateDifference;

import java.util.List;

public interface CandidateDiffHandler {

    CandidateDifference getCandidateDifferences(List<Candidate> beforeCandidates, List<Candidate> afterCandidates);
}
