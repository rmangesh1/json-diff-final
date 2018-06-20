package inspera.parser.handler;

import inspera.parser.domain.Candidate;
import inspera.parser.domain.diff.CandidateDifference;
import inspera.parser.domain.diff.CandidateIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Handler class responsible to get Candidate differences
 */
public class CandidateDiffHandlerImpl implements CandidateDiffHandler {

    private static final Logger logger = LoggerFactory.getLogger(CandidateDiffHandler.class);

    /**
     * Returns CandidateDifference between before and after candidates
     * @param beforeCandidates
     * @param afterCandidates
     * @return
     */
    @Override
    public CandidateDifference getCandidateDifferences(List<Candidate> beforeCandidates, List<Candidate> afterCandidates) {

        CandidateGroup candidateGroup = new CandidateGroup(beforeCandidates, afterCandidates);

        List<CandidateIdentifier> addedCandidateIdentifiers = candidateGroup.getAddedCandidateIdentifiers();

        List<CandidateIdentifier> removedCandidateIdentifiers = candidateGroup.getRemovedCandidateIdentifiers();

        List<CandidateIdentifier> editedCandidateIdentifiers = candidateGroup.getEditedCandidateIdentifiers();

        return new CandidateDifference(editedCandidateIdentifiers, addedCandidateIdentifiers, removedCandidateIdentifiers);
    }

}
