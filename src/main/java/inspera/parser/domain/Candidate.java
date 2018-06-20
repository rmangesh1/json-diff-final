package inspera.parser.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Candidate {

    private Long id;

    @JsonProperty("candidateName")
    private String name;

    private Integer extraTime;

    public Candidate() {
    }

    public Candidate(Long id, String name, Integer extraTime) {
        this.id = id;
        this.name = name;
        this.extraTime = extraTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(Integer extraTime) {
        this.extraTime = extraTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(id, candidate.id) &&
                Objects.equals(name, candidate.name) &&
                Objects.equals(extraTime, candidate.extraTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, extraTime);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candidate{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", extraTime=").append(extraTime);
        sb.append('}');
        return sb.toString();
    }
}
