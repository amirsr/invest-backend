package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Instrument}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableInstrument.builder()}.
 */
@Generated(from = "Instrument", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableInstrument implements Instrument {
  private final Integer instrumentId;
  private final String name;
  private final String symbol;
  private final String instrumentType;

  private ImmutableInstrument(
      Integer instrumentId,
      String name,
      String symbol,
      String instrumentType) {
    this.instrumentId = instrumentId;
    this.name = name;
    this.symbol = symbol;
    this.instrumentType = instrumentType;
  }

  /**
   * @return The value of the {@code instrumentId} attribute
   */
  @Override
  public Integer instrumentId() {
    return instrumentId;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code symbol} attribute
   */
  @Override
  public String symbol() {
    return symbol;
  }

  /**
   * @return The value of the {@code instrumentType} attribute
   */
  @Override
  public String instrumentType() {
    return instrumentType;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Instrument#instrumentId() instrumentId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for instrumentId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableInstrument withInstrumentId(Integer value) {
    Integer newValue = Objects.requireNonNull(value, "instrumentId");
    if (this.instrumentId.equals(newValue)) return this;
    return new ImmutableInstrument(newValue, this.name, this.symbol, this.instrumentType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Instrument#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableInstrument withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableInstrument(this.instrumentId, newValue, this.symbol, this.instrumentType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Instrument#symbol() symbol} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for symbol
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableInstrument withSymbol(String value) {
    String newValue = Objects.requireNonNull(value, "symbol");
    if (this.symbol.equals(newValue)) return this;
    return new ImmutableInstrument(this.instrumentId, this.name, newValue, this.instrumentType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Instrument#instrumentType() instrumentType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for instrumentType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableInstrument withInstrumentType(String value) {
    String newValue = Objects.requireNonNull(value, "instrumentType");
    if (this.instrumentType.equals(newValue)) return this;
    return new ImmutableInstrument(this.instrumentId, this.name, this.symbol, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableInstrument} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableInstrument
        && equalTo((ImmutableInstrument) another);
  }

  private boolean equalTo(ImmutableInstrument another) {
    return instrumentId.equals(another.instrumentId)
        && name.equals(another.name)
        && symbol.equals(another.symbol)
        && instrumentType.equals(another.instrumentType);
  }

  /**
   * Computes a hash code from attributes: {@code instrumentId}, {@code name}, {@code symbol}, {@code instrumentType}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + instrumentId.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + symbol.hashCode();
    h += (h << 5) + instrumentType.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Instrument} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return com.google.common.base.Objects.toStringHelper("Instrument")
        .omitNullValues()
        .add("instrumentId", instrumentId)
        .add("name", name)
        .add("symbol", symbol)
        .add("instrumentType", instrumentType)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Instrument} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Instrument instance
   */
  public static ImmutableInstrument copyOf(Instrument instance) {
    if (instance instanceof ImmutableInstrument) {
      return (ImmutableInstrument) instance;
    }
    return ImmutableInstrument.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableInstrument ImmutableInstrument}.
   * <pre>
   * ImmutableInstrument.builder()
   *    .instrumentId(Integer) // required {@link Instrument#instrumentId() instrumentId}
   *    .name(String) // required {@link Instrument#name() name}
   *    .symbol(String) // required {@link Instrument#symbol() symbol}
   *    .instrumentType(String) // required {@link Instrument#instrumentType() instrumentType}
   *    .build();
   * </pre>
   * @return A new ImmutableInstrument builder
   */
  public static ImmutableInstrument.Builder builder() {
    return new ImmutableInstrument.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableInstrument ImmutableInstrument}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Instrument", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_INSTRUMENT_ID = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private static final long INIT_BIT_SYMBOL = 0x4L;
    private static final long INIT_BIT_INSTRUMENT_TYPE = 0x8L;
    private long initBits = 0xfL;

    private Integer instrumentId;
    private String name;
    private String symbol;
    private String instrumentType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Instrument} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Instrument instance) {
      Objects.requireNonNull(instance, "instance");
      instrumentId(instance.instrumentId());
      name(instance.name());
      symbol(instance.symbol());
      instrumentType(instance.instrumentType());
      return this;
    }

    /**
     * Initializes the value for the {@link Instrument#instrumentId() instrumentId} attribute.
     * @param instrumentId The value for instrumentId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder instrumentId(Integer instrumentId) {
      this.instrumentId = Objects.requireNonNull(instrumentId, "instrumentId");
      initBits &= ~INIT_BIT_INSTRUMENT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Instrument#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link Instrument#symbol() symbol} attribute.
     * @param symbol The value for symbol 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder symbol(String symbol) {
      this.symbol = Objects.requireNonNull(symbol, "symbol");
      initBits &= ~INIT_BIT_SYMBOL;
      return this;
    }

    /**
     * Initializes the value for the {@link Instrument#instrumentType() instrumentType} attribute.
     * @param instrumentType The value for instrumentType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder instrumentType(String instrumentType) {
      this.instrumentType = Objects.requireNonNull(instrumentType, "instrumentType");
      initBits &= ~INIT_BIT_INSTRUMENT_TYPE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableInstrument ImmutableInstrument}.
     * @return An immutable instance of Instrument
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableInstrument build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableInstrument(instrumentId, name, symbol, instrumentType);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_INSTRUMENT_ID) != 0) attributes.add("instrumentId");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_SYMBOL) != 0) attributes.add("symbol");
      if ((initBits & INIT_BIT_INSTRUMENT_TYPE) != 0) attributes.add("instrumentType");
      return "Cannot build Instrument, some of required attributes are not set " + attributes;
    }
  }
}
