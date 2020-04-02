package entities;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.stream.*;
import java.io.IOException;
import javax.annotation.Generated;

/**
 * A {@code TypeAdapterFactory} that handles all of the immutable types generated under {@code Instrument}.
 * @see ImmutableInstrument
 */
@SuppressWarnings({"all", "MethodCanBeStatic"})
@Generated("org.immutables.processor.ProxyProcessor")
@org.immutables.value.Generated(from = "entities", generator = "Gsons")
public final class GsonAdaptersInstrument implements TypeAdapterFactory {
  @SuppressWarnings({"unchecked", "raw"}) // safe unchecked, types are verified in runtime
  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (InstrumentTypeAdapter.adapts(type)) {
      return (TypeAdapter<T>) new InstrumentTypeAdapter(gson);
    }
    return null;
  }

  @Override
  public String toString() {
    return "GsonAdaptersInstrument(Instrument)";
  }

  @org.immutables.value.Generated(from = "Instrument", generator = "Gsons")
  @SuppressWarnings({"unchecked", "raw"}) // safe unchecked, types are verified in runtime
  private static class InstrumentTypeAdapter extends TypeAdapter<Instrument> {
    public final Integer instrumentIdTypeSample = null;
    private final TypeAdapter<Integer> instrumentIdTypeAdapter;

    InstrumentTypeAdapter(Gson gson) {
      this.instrumentIdTypeAdapter = gson.getAdapter( Integer.class);
    } 

    static boolean adapts(TypeToken<?> type) {
      return Instrument.class == type.getRawType()
          || ImmutableInstrument.class == type.getRawType();
    }

    @Override
    public void write(JsonWriter out, Instrument value) throws IOException {
      if (value == null) {
        out.nullValue();
      } else {
        writeInstrument(out, value);
      }
    }

    @Override
    public Instrument read(JsonReader in) throws IOException {
      return readInstrument(in);
    }

    private void writeInstrument(JsonWriter out, Instrument instance)
        throws IOException {
      out.beginObject();
      out.name("instrumentId");
      instrumentIdTypeAdapter.write(out, instance.instrumentId());
      out.name("name");
      out.value(instance.name());
      out.name("symbol");
      out.value(instance.symbol());
      out.name("instrumentType");
      out.value(instance.instrumentType());
      out.endObject();
    }

    private  Instrument readInstrument(JsonReader in)
        throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return null;
      }
      ImmutableInstrument.Builder builder = ImmutableInstrument.builder();
      in.beginObject();
      while (in.hasNext()) {
        eachAttribute(in, builder);
      }
      in.endObject();
      return builder.build();
    }

    private void eachAttribute(JsonReader in, ImmutableInstrument.Builder builder)
        throws IOException {
      String attributeName = in.nextName();
      switch (attributeName.charAt(0)) {
      case 'i':
        if ("instrumentId".equals(attributeName)) {
          readInInstrumentId(in, builder);
          return;
        }
        if ("instrumentType".equals(attributeName)) {
          readInInstrumentType(in, builder);
          return;
        }
        break;
      case 'n':
        if ("name".equals(attributeName)) {
          readInName(in, builder);
          return;
        }
        break;
      case 's':
        if ("symbol".equals(attributeName)) {
          readInSymbol(in, builder);
          return;
        }
        break;
      default:
      }
      in.skipValue();
    }

    private void readInInstrumentId(JsonReader in, ImmutableInstrument.Builder builder)
        throws IOException {
      Integer value = instrumentIdTypeAdapter.read(in);
      builder.instrumentId(value);
    }

    private void readInName(JsonReader in, ImmutableInstrument.Builder builder)
        throws IOException {
      builder.name(in.nextString());
    }

    private void readInSymbol(JsonReader in, ImmutableInstrument.Builder builder)
        throws IOException {
      builder.symbol(in.nextString());
    }

    private void readInInstrumentType(JsonReader in, ImmutableInstrument.Builder builder)
        throws IOException {
      builder.instrumentType(in.nextString());
    }
  }
}
