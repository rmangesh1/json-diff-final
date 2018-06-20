package inspera.parser.domain.diff;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class ExaminationDifference {

    @JsonProperty("meta")
    private List<MetaDiff> metaDiff;

    @JsonProperty("candidates")
    private CandidateDifference candidateDifference;

    public ExaminationDifference() {
    }

    public ExaminationDifference(List<MetaDiff> metaDiff, CandidateDifference candidateDifference) {
        this.metaDiff = metaDiff;
        this.candidateDifference = candidateDifference;
    }

    public List<MetaDiff> getMetaDiff() {
        return metaDiff;
    }

    public void setMetaDiff(List<MetaDiff> metaDiff) {
        this.metaDiff = metaDiff;
    }

    public CandidateDifference getCandidateDifference() {
        return candidateDifference;
    }

    public void setCandidateDifference(CandidateDifference candidateDifference) {
        this.candidateDifference = candidateDifference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExaminationDifference that = (ExaminationDifference) o;
        return Objects.equals(metaDiff, that.metaDiff) &&
                Objects.equals(candidateDifference, that.candidateDifference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metaDiff, candidateDifference);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExaminationDifference{");
        sb.append("metaDiff=").append(metaDiff);
        sb.append(", candidateDifference=").append(candidateDifference);
        sb.append('}');
        return sb.toString();
    }
}
