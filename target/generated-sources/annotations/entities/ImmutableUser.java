package entities;

import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link User}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUser.builder()}.
 */
@Generated(from = "User", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableUser implements User {
  private final String userName;
  private final ImmutableList<Integer> instrumentList;

  private ImmutableUser(
      String userName,
      ImmutableList<Integer> instrumentList) {
    this.userName = userName;
    this.instrumentList = instrumentList;
  }

  /**
   * @return The value of the {@code userName} attribute
   */
  @Override
  public String userName() {
    return userName;
  }

  /**
   * @return The value of the {@code instrumentList} attribute
   */
  @Override
  public ImmutableList<Integer> instrumentList() {
    return instrumentList;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link User#userName() userName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for userName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUser withUserName(String value) {
    String newValue = Objects.requireNonNull(value, "userName");
    if (this.userName.equals(newValue)) return this;
    return new ImmutableUser(newValue, this.instrumentList);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link User#instrumentList() instrumentList}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableUser withInstrumentList(int... elements) {
    ImmutableList<Integer> newValue = ImmutableList.copyOf(Ints.asList(elements));
    return new ImmutableUser(this.userName, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link User#instrumentList() instrumentList}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of instrumentList elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableUser withInstrumentList(Iterable<Integer> elements) {
    if (this.instrumentList == elements) return this;
    ImmutableList<Integer> newValue = ImmutableList.copyOf(elements);
    return new ImmutableUser(this.userName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUser} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUser
        && equalTo((ImmutableUser) another);
  }

  private boolean equalTo(ImmutableUser another) {
    return userName.equals(another.userName)
        && instrumentList.equals(another.instrumentList);
  }

  /**
   * Computes a hash code from attributes: {@code userName}, {@code instrumentList}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + userName.hashCode();
    h += (h << 5) + instrumentList.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code User} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return com.google.common.base.Objects.toStringHelper("User")
        .omitNullValues()
        .add("userName", userName)
        .add("instrumentList", instrumentList)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link User} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable User instance
   */
  public static ImmutableUser copyOf(User instance) {
    if (instance instanceof ImmutableUser) {
      return (ImmutableUser) instance;
    }
    return ImmutableUser.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUser ImmutableUser}.
   * <pre>
   * ImmutableUser.builder()
   *    .userName(String) // required {@link User#userName() userName}
   *    .addInstrumentList|addAllInstrumentList(int) // {@link User#instrumentList() instrumentList} elements
   *    .build();
   * </pre>
   * @return A new ImmutableUser builder
   */
  public static ImmutableUser.Builder builder() {
    return new ImmutableUser.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUser ImmutableUser}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "User", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_USER_NAME = 0x1L;
    private long initBits = 0x1L;

    private String userName;
    private ImmutableList.Builder<Integer> instrumentList = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code User} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(User instance) {
      Objects.requireNonNull(instance, "instance");
      userName(instance.userName());
      addAllInstrumentList(instance.instrumentList());
      return this;
    }

    /**
     * Initializes the value for the {@link User#userName() userName} attribute.
     * @param userName The value for userName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder userName(String userName) {
      this.userName = Objects.requireNonNull(userName, "userName");
      initBits &= ~INIT_BIT_USER_NAME;
      return this;
    }

    /**
     * Adds one element to {@link User#instrumentList() instrumentList} list.
     * @param element A instrumentList element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addInstrumentList(int element) {
      this.instrumentList.add(element);
      return this;
    }

    /**
     * Adds elements to {@link User#instrumentList() instrumentList} list.
     * @param elements An array of instrumentList elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addInstrumentList(int... elements) {
      this.instrumentList.addAll(Ints.asList(elements));
      return this;
    }


    /**
     * Sets or replaces all elements for {@link User#instrumentList() instrumentList} list.
     * @param elements An iterable of instrumentList elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder instrumentList(Iterable<Integer> elements) {
      this.instrumentList = ImmutableList.builder();
      return addAllInstrumentList(elements);
    }

    /**
     * Adds elements to {@link User#instrumentList() instrumentList} list.
     * @param elements An iterable of instrumentList elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllInstrumentList(Iterable<Integer> elements) {
      this.instrumentList.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableUser ImmutableUser}.
     * @return An immutable instance of User
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUser build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUser(userName, instrumentList.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_USER_NAME) != 0) attributes.add("userName");
      return "Cannot build User, some of required attributes are not set " + attributes;
    }
  }
}
