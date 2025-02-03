/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pycampadb.avro.data;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class EmployeeForwardV2 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4694085912989056141L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EmployeeForwardV2\",\"namespace\":\"com.pycampadb.avro.data\",\"fields\":[{\"name\":\"firstName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"email\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EmployeeForwardV2> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EmployeeForwardV2> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EmployeeForwardV2> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EmployeeForwardV2> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EmployeeForwardV2> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EmployeeForwardV2 to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EmployeeForwardV2 from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EmployeeForwardV2 instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EmployeeForwardV2 fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private String firstName;
  private String lastName;
  private String email;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EmployeeForwardV2() {}

  /**
   * All-args constructor.
   * @param firstName The new value for firstName
   * @param lastName The new value for lastName
   * @param email The new value for email
   */
  public EmployeeForwardV2(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  @Override
  public SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public Object get(int field$) {
    switch (field$) {
    case 0: return firstName;
    case 1: return lastName;
    case 2: return email;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: firstName = value$ != null ? value$.toString() : null; break;
    case 1: lastName = value$ != null ? value$.toString() : null; break;
    case 2: email = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'firstName' field.
   * @return The value of the 'firstName' field.
   */
  public String getFirstName() {
    return firstName;
  }


  /**
   * Sets the value of the 'firstName' field.
   * @param value the value to set.
   */
  public void setFirstName(String value) {
    this.firstName = value;
  }

  /**
   * Gets the value of the 'lastName' field.
   * @return The value of the 'lastName' field.
   */
  public String getLastName() {
    return lastName;
  }


  /**
   * Sets the value of the 'lastName' field.
   * @param value the value to set.
   */
  public void setLastName(String value) {
    this.lastName = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public String getEmail() {
    return email;
  }


  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(String value) {
    this.email = value;
  }

  /**
   * Creates a new EmployeeForwardV2 RecordBuilder.
   * @return A new EmployeeForwardV2 RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new EmployeeForwardV2 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EmployeeForwardV2 RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * Creates a new EmployeeForwardV2 RecordBuilder by copying an existing EmployeeForwardV2 instance.
   * @param other The existing instance to copy.
   * @return A new EmployeeForwardV2 RecordBuilder
   */
  public static Builder newBuilder(EmployeeForwardV2 other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * RecordBuilder for EmployeeForwardV2 instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EmployeeForwardV2>
    implements org.apache.avro.data.RecordBuilder<EmployeeForwardV2> {

    private String firstName;
    private String lastName;
    private String email;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.firstName)) {
        this.firstName = data().deepCopy(fields()[0].schema(), other.firstName);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.lastName)) {
        this.lastName = data().deepCopy(fields()[1].schema(), other.lastName);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.email)) {
        this.email = data().deepCopy(fields()[2].schema(), other.email);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing EmployeeForwardV2 instance
     * @param other The existing instance to copy.
     */
    private Builder(EmployeeForwardV2 other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.firstName)) {
        this.firstName = data().deepCopy(fields()[0].schema(), other.firstName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.lastName)) {
        this.lastName = data().deepCopy(fields()[1].schema(), other.lastName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.email)) {
        this.email = data().deepCopy(fields()[2].schema(), other.email);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'firstName' field.
      * @return The value.
      */
    public String getFirstName() {
      return firstName;
    }


    /**
      * Sets the value of the 'firstName' field.
      * @param value The value of 'firstName'.
      * @return This builder.
      */
    public Builder setFirstName(String value) {
      validate(fields()[0], value);
      this.firstName = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'firstName' field has been set.
      * @return True if the 'firstName' field has been set, false otherwise.
      */
    public boolean hasFirstName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'firstName' field.
      * @return This builder.
      */
    public Builder clearFirstName() {
      firstName = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'lastName' field.
      * @return The value.
      */
    public String getLastName() {
      return lastName;
    }


    /**
      * Sets the value of the 'lastName' field.
      * @param value The value of 'lastName'.
      * @return This builder.
      */
    public Builder setLastName(String value) {
      validate(fields()[1], value);
      this.lastName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'lastName' field has been set.
      * @return True if the 'lastName' field has been set, false otherwise.
      */
    public boolean hasLastName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'lastName' field.
      * @return This builder.
      */
    public Builder clearLastName() {
      lastName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public String getEmail() {
      return email;
    }


    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public Builder setEmail(String value) {
      validate(fields()[2], value);
      this.email = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public Builder clearEmail() {
      email = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EmployeeForwardV2 build() {
      try {
        EmployeeForwardV2 record = new EmployeeForwardV2();
        record.firstName = fieldSetFlags()[0] ? this.firstName : (String) defaultValue(fields()[0]);
        record.lastName = fieldSetFlags()[1] ? this.lastName : (String) defaultValue(fields()[1]);
        record.email = fieldSetFlags()[2] ? this.email : (String) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EmployeeForwardV2>
    WRITER$ = (org.apache.avro.io.DatumWriter<EmployeeForwardV2>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EmployeeForwardV2>
    READER$ = (org.apache.avro.io.DatumReader<EmployeeForwardV2>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.firstName);

    out.writeString(this.lastName);

    out.writeString(this.email);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.firstName = in.readString();

      this.lastName = in.readString();

      this.email = in.readString();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.firstName = in.readString();
          break;

        case 1:
          this.lastName = in.readString();
          break;

        case 2:
          this.email = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










