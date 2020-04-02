package entities;

import org.immutables.gson.Gson;
import org.immutables.value.Value;
@Gson.TypeAdapters
@Value.Immutable
public interface Instrument {
    public Integer instrumentId();
    public String name();
    public String symbol ();
    public String instrumentType  ();
}
