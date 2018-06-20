package inspera.parser.domain.diff;

import java.util.List;
import java.util.Objects;

public class CandidateDifference {

    private List<CandidateIdentifier> edited;

    private List<CandidateIdentifier> added;

    private List<CandidateIdentifier> removed;

    public CandidateDifference() {
    }

    public CandidateDifference(List<CandidateIdentifier> edited, List<CandidateIdentifier> added, List<CandidateIdentifier> removed) {
        this.edited = edited;
        this.added = added;
        this.removed = removed;
    }

    public List<CandidateIdentifier> getEdited() {
        return edited;
    }

    public void setEdited(List<CandidateIdentifier> edited) {
        this.edited = edited;
    }

    public List<CandidateIdentifier> getAdded() {
        return added;
    }

    public void setAdded(List<CandidateIdentifier> added) {
        this.added = added;
    }

    public List<CandidateIdentifier> getRemoved() {
        return removed;
    }

    public void setRemoved(List<CandidateIdentifier> removed) {
        this.removed = removed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateDifference that = (CandidateDifference) o;
        return Objects.equals(edited, that.edited) &&
                Objects.equals(added, that.added) &&
                Objects.equals(removed, that.removed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edited, added, removed);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CandidateDifference{");
        sb.append("edited=").append(edited);
        sb.append(", added=").append(added);
        sb.append(", removed=").append(removed);
        sb.append('}');
        return sb.toString();
    }
}
