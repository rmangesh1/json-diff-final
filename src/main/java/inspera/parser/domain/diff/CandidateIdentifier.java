package inspera.parser.domain.diff;

import java.util.Objects;

public class CandidateIdentifier {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CandidateIdentifier(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateIdentifier that = (CandidateIdentifier) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CandidateIdentifier{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
