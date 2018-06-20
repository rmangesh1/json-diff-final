package inspera.parser;

import com.fasterxml.jackson.databind.JsonNode;

public interface DiffParser {

    JsonNode parse(JsonNode before, JsonNode after);
}
