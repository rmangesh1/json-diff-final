package inspera.parser.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Metadata {

    private String title;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public Metadata() {
    }

    public Metadata(String title, LocalDateTime startTime, LocalDateTime endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metadata metadata = (Metadata) o;
        return Objects.equals(title, metadata.title) &&
                Objects.equals(startTime, metadata.startTime) &&
                Objects.equals(endTime, metadata.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, startTime, endTime);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Metadata{");
        sb.append("title='").append(title).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append('}');
        return sb.toString();
    }
}
