package entities;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.stream.*;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

/**
 * A {@code TypeAdapterFactory} that handles all of the immutable types generated under {@code User}.
 * @see ImmutableUser
 */
@SuppressWarnings({"all", "MethodCanBeStatic"})
@Generated("org.immutables.processor.ProxyProcessor")
@org.immutables.value.Generated(from = "entities", generator = "Gsons")
public final class GsonAdaptersUser implements TypeAdapterFactory {
  @SuppressWarnings({"unchecked", "raw"}) // safe unchecked, types are verified in runtime
  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (UserTypeAdapter.adapts(type)) {
      return (TypeAdapter<T>) new UserTypeAdapter(gson);
    }
    return null;
  }

  @Override
  public String toString() {
    return "GsonAdaptersUser(User)";
  }

  @org.immutables.value.Generated(from = "User", generator = "Gsons")
  @SuppressWarnings({"unchecked", "raw"}) // safe unchecked, types are verified in runtime
  private static class UserTypeAdapter extends TypeAdapter<User> {
    public final Integer instrumentListTypeSample = null;
    private final TypeAdapter<Integer> instrumentListTypeAdapter;

    UserTypeAdapter(Gson gson) {
      this.instrumentListTypeAdapter = gson.getAdapter( Integer.class);
    } 

    static boolean adapts(TypeToken<?> type) {
      return User.class == type.getRawType()
          || ImmutableUser.class == type.getRawType();
    }

    @Override
    public void write(JsonWriter out, User value) throws IOException {
      if (value == null) {
        out.nullValue();
      } else {
        writeUser(out, value);
      }
    }

    @Override
    public User read(JsonReader in) throws IOException {
      return readUser(in);
    }

    private void writeUser(JsonWriter out, User instance)
        throws IOException {
      out.beginObject();
      out.name("userName");
      out.value(instance.userName());
      List<Integer> instrumentListElements = instance.instrumentList();
      out.name("instrumentList");
      out.beginArray();
      for (Integer e : instrumentListElements) {
        instrumentListTypeAdapter.write(out, e);
      }
      out.endArray();
      out.endObject();
    }

    private  User readUser(JsonReader in)
        throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return null;
      }
      ImmutableUser.Builder builder = ImmutableUser.builder();
      in.beginObject();
      while (in.hasNext()) {
        eachAttribute(in, builder);
      }
      in.endObject();
      return builder.build();
    }

    private void eachAttribute(JsonReader in, ImmutableUser.Builder builder)
        throws IOException {
      String attributeName = in.nextName();
      switch (attributeName.charAt(0)) {
      case 'u':
        if ("userName".equals(attributeName)) {
          readInUserName(in, builder);
          return;
        }
        break;
      case 'i':
        if ("instrumentList".equals(attributeName)) {
          readInInstrumentList(in, builder);
          return;
        }
        break;
      default:
      }
      in.skipValue();
    }

    private void readInUserName(JsonReader in, ImmutableUser.Builder builder)
        throws IOException {
      builder.userName(in.nextString());
    }

    private void readInInstrumentList(JsonReader in, ImmutableUser.Builder builder)
        throws IOException {
      if (in.peek() == JsonToken.BEGIN_ARRAY) {
        in.beginArray();
        while(in.hasNext()) {
          builder.addInstrumentList(in.nextInt());
        }
        in.endArray();
      } else if (in.peek() == JsonToken.NULL) {
        in.nextNull();
      } else {
        builder.addInstrumentList(in.nextInt());
      }
    }
  }
}
