package inspera.parser.domain.diff;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class MetaDiff {

    private String field;

    @JsonProperty("before")
    private Object beforeValue;

    @JsonProperty("after")
    private Object afterValue;

    public MetaDiff() {
    }

    public MetaDiff(String field, Object beforeValue, Object afterValue) {
        this.field = field;
        this.beforeValue = beforeValue;
        this.afterValue = afterValue;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getBeforeValue() {
        return beforeValue;
    }

    public void setBeforeValue(Object beforeValue) {
        this.beforeValue = beforeValue;
    }

    public Object getAfterValue() {
        return afterValue;
    }

    public void setAfterValue(Object afterValue) {
        this.afterValue = afterValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaDiff metaDiff = (MetaDiff) o;
        return Objects.equals(field, metaDiff.field) &&
                Objects.equals(beforeValue, metaDiff.beforeValue) &&
                Objects.equals(afterValue, metaDiff.afterValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, beforeValue, afterValue);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MetaDiff{");
        sb.append("field='").append(field).append('\'');
        sb.append(", beforeValue=").append(beforeValue);
        sb.append(", afterValue=").append(afterValue);
        sb.append('}');
        return sb.toString();
    }
}
