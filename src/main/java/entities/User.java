package entities;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.List;
@Gson.TypeAdapters
@Value.Immutable
public interface User {
     String userName();
     List<Integer> instrumentList();
}
