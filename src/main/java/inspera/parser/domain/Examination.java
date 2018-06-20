package inspera.parser.domain;

import java.util.List;
import java.util.Objects;

public class Examination {

    private Long id;

    private Metadata meta;

    private List<Candidate> candidates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Metadata getMeta() {
        return meta;
    }

    public void setMeta(Metadata meta) {
        this.meta = meta;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Examination that = (Examination) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(meta, that.meta) &&
                Objects.equals(candidates, that.candidates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meta, candidates);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Examination{");
        sb.append("id=").append(id);
        sb.append(", meta=").append(meta);
        sb.append(", candidates=").append(candidates);
        sb.append('}');
        return sb.toString();
    }
}
