package inspera.parser.handler;

import inspera.parser.domain.Candidate;
import inspera.parser.domain.diff.CandidateIdentifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static inspera.parser.util.ListUtils.removeAll;
import static inspera.parser.util.ListUtils.retainAll;

/**
 * Non anemic model to get candidate modifications
 */
public class CandidateGroup {

    private List<Candidate> beforeCandidates;

    private List<Candidate> afterCandidates;

    private List<Long> beforeCandidateIds;

    private List<Long> afterCandidateIds;

    public CandidateGroup(List<Candidate> beforeCandidates, List<Candidate> afterCandidates) {
        this.beforeCandidates = beforeCandidates;
        this.afterCandidates = afterCandidates;
        this.beforeCandidateIds = getCandidateIds(beforeCandidates);
        this.afterCandidateIds = getCandidateIds(afterCandidates);
    }

    /**
     * Returns list of added candidate identifiers
     * @return
     */
    public List<CandidateIdentifier> getAddedCandidateIdentifiers() {
        return getCandidateIdentifiers(afterCandidateIds, beforeCandidateIds);
    }

    /**
     * Returns list of removed candidate identifiers
     * @return
     */
    public List<CandidateIdentifier> getRemovedCandidateIdentifiers() {
        return getCandidateIdentifiers(beforeCandidateIds, afterCandidateIds);
    }

    /**
     * Returns list of edited candidate identifiers
     * @return
     */
    public List<CandidateIdentifier> getEditedCandidateIdentifiers() {
        List<CandidateIdentifier> editedCandidateIdentifiers = new ArrayList<>();

        List<Long> commonCandidateIds = retainAll(beforeCandidateIds, afterCandidateIds);

        Map<Long, Candidate> beforeCandidateMap = getCandidateMap(beforeCandidates);
        Map<Long, Candidate> afterCandidateMap = getCandidateMap(afterCandidates);

        commonCandidateIds.forEach(id -> {
            if(!beforeCandidateMap.get(id).equals(afterCandidateMap.get(id)))
                editedCandidateIdentifiers.add(new CandidateIdentifier(id));
        });

        return editedCandidateIdentifiers;
    }

    /**
     * Returns map of candidate id to candidate
     * @param candidates
     * @return
     */
    private Map<Long, Candidate> getCandidateMap(List<Candidate> candidates) {
        return candidates.stream().collect(Collectors.toMap(Candidate::getId, c -> c));
    }

    /**
     * Returns list of added/removed candidate identifiers
     * @param candidateIds
     * @param candidateIdsToBeRemoved
     * @return
     */
    private List<CandidateIdentifier> getCandidateIdentifiers(List<Long> candidateIds, List<Long> candidateIdsToBeRemoved) {
        List<CandidateIdentifier> candidateIdentifiers = new ArrayList<>();

        List<Long> resultCandidateIds = removeAll(candidateIds, candidateIdsToBeRemoved);
        resultCandidateIds.forEach(id -> {
            candidateIdentifiers.add(new CandidateIdentifier(id));
        });

        return candidateIdentifiers;
    }

    /**
     * Returns list of candidate ids from candidates
     * @param candidates
     * @return
     */
    private List<Long> getCandidateIds(List<Candidate> candidates) {
        return candidates.stream().map(Candidate::getId).sorted().collect(Collectors.toList());
    }
}
