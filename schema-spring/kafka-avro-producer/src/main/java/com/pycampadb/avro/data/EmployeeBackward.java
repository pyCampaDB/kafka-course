/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pycampadb.avro.data;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EmployeeBackward extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4000297623293617654L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EmployeeBackward\",\"namespace\":\"com.pycampadb.avro.data\",\"fields\":[{\"name\":\"firstName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"maritalStatus\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"UNKNOWN\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EmployeeBackward> ENCODER =
          new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EmployeeBackward> DECODER =
          new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EmployeeBackward> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EmployeeBackward> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EmployeeBackward> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EmployeeBackward to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EmployeeBackward from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EmployeeBackward instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EmployeeBackward fromByteBuffer(
          java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private String firstName;
  private String lastName;
  private String maritalStatus;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EmployeeBackward() {}

  /**
   * All-args constructor.
   * @param firstName The new value for firstName
   * @param lastName The new value for lastName
   * @param maritalStatus The new value for maritalStatus
   */
  public EmployeeBackward(String firstName, String lastName, String maritalStatus) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.maritalStatus = maritalStatus;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public Object get(int field$) {
    switch (field$) {
      case 0: return firstName;
      case 1: return lastName;
      case 2: return maritalStatus;
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
      case 2: maritalStatus = value$ != null ? value$.toString() : null; break;
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
   * Gets the value of the 'maritalStatus' field.
   * @return The value of the 'maritalStatus' field.
   */
  public String getMaritalStatus() {
    return maritalStatus;
  }


  /**
   * Sets the value of the 'maritalStatus' field.
   * @param value the value to set.
   */
  public void setMaritalStatus(String value) {
    this.maritalStatus = value;
  }

  /**
   * Creates a new EmployeeBackward RecordBuilder.
   * @return A new EmployeeBackward RecordBuilder
   */
  public static com.pycampadb.avro.data.EmployeeBackward.Builder newBuilder() {
    return new com.pycampadb.avro.data.EmployeeBackward.Builder();
  }

  /**
   * Creates a new EmployeeBackward RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EmployeeBackward RecordBuilder
   */
  public static com.pycampadb.avro.data.EmployeeBackward.Builder newBuilder(com.pycampadb.avro.data.EmployeeBackward.Builder other) {
    if (other == null) {
      return new com.pycampadb.avro.data.EmployeeBackward.Builder();
    } else {
      return new com.pycampadb.avro.data.EmployeeBackward.Builder(other);
    }
  }

  /**
   * Creates a new EmployeeBackward RecordBuilder by copying an existing EmployeeBackward instance.
   * @param other The existing instance to copy.
   * @return A new EmployeeBackward RecordBuilder
   */
  public static com.pycampadb.avro.data.EmployeeBackward.Builder newBuilder(com.pycampadb.avro.data.EmployeeBackward other) {
    if (other == null) {
      return new com.pycampadb.avro.data.EmployeeBackward.Builder();
    } else {
      return new com.pycampadb.avro.data.EmployeeBackward.Builder(other);
    }
  }

  /**
   * RecordBuilder for EmployeeBackward instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EmployeeBackward>
          implements org.apache.avro.data.RecordBuilder<EmployeeBackward> {

    private String firstName;
    private String lastName;
    private String maritalStatus;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pycampadb.avro.data.EmployeeBackward.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.firstName)) {
        this.firstName = data().deepCopy(fields()[0].schema(), other.firstName);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.lastName)) {
        this.lastName = data().deepCopy(fields()[1].schema(), other.lastName);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.maritalStatus)) {
        this.maritalStatus = data().deepCopy(fields()[2].schema(), other.maritalStatus);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing EmployeeBackward instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pycampadb.avro.data.EmployeeBackward other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.firstName)) {
        this.firstName = data().deepCopy(fields()[0].schema(), other.firstName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.lastName)) {
        this.lastName = data().deepCopy(fields()[1].schema(), other.lastName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.maritalStatus)) {
        this.maritalStatus = data().deepCopy(fields()[2].schema(), other.maritalStatus);
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
    public com.pycampadb.avro.data.EmployeeBackward.Builder setFirstName(String value) {
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
    public com.pycampadb.avro.data.EmployeeBackward.Builder clearFirstName() {
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
    public com.pycampadb.avro.data.EmployeeBackward.Builder setLastName(String value) {
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
    public com.pycampadb.avro.data.EmployeeBackward.Builder clearLastName() {
      lastName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
     * Gets the value of the 'maritalStatus' field.
     * @return The value.
     */
    public String getMaritalStatus() {
      return maritalStatus;
    }


    /**
     * Sets the value of the 'maritalStatus' field.
     * @param value The value of 'maritalStatus'.
     * @return This builder.
     */
    public com.pycampadb.avro.data.EmployeeBackward.Builder setMaritalStatus(String value) {
      validate(fields()[2], value);
      this.maritalStatus = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
     * Checks whether the 'maritalStatus' field has been set.
     * @return True if the 'maritalStatus' field has been set, false otherwise.
     */
    public boolean hasMaritalStatus() {
      return fieldSetFlags()[2];
    }


    /**
     * Clears the value of the 'maritalStatus' field.
     * @return This builder.
     */
    public com.pycampadb.avro.data.EmployeeBackward.Builder clearMaritalStatus() {
      maritalStatus = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EmployeeBackward build() {
      try {
        EmployeeBackward record = new EmployeeBackward();
        record.firstName = fieldSetFlags()[0] ? this.firstName : (String) defaultValue(fields()[0]);
        record.lastName = fieldSetFlags()[1] ? this.lastName : (String) defaultValue(fields()[1]);
        record.maritalStatus = fieldSetFlags()[2] ? this.maritalStatus : (String) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EmployeeBackward>
          WRITER$ = (org.apache.avro.io.DatumWriter<EmployeeBackward>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
          throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EmployeeBackward>
          READER$ = (org.apache.avro.io.DatumReader<EmployeeBackward>)MODEL$.createDatumReader(SCHEMA$);

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

    out.writeString(this.maritalStatus);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
          throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.firstName = in.readString();

      this.lastName = in.readString();

      this.maritalStatus = in.readString();

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
            this.maritalStatus = in.readString();
            break;

          default:
            throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










