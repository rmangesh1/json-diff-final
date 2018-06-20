package inspera.parser.handler;

import inspera.parser.domain.Metadata;
import inspera.parser.domain.diff.MetaDiff;

import java.util.List;

public interface MetaDiffHandler {

    List<MetaDiff> getMetaDifferences(Metadata beforeMetadataObj, Metadata afterMetadataObj);
}
