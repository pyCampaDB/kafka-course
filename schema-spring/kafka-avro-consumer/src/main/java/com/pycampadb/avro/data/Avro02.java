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

/** Sample logical types */
@org.apache.avro.specific.AvroGenerated
public class Avro02 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8583452400494098626L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Avro02\",\"namespace\":\"com.pycampadb.avro.data\",\"doc\":\"Sample logical types\",\"fields\":[{\"name\":\"myDecimal\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":20,\"scale\":5}},{\"name\":\"myUUID\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"myDate\",\"type\":{\"type\":\"int\",\"logicalType\":\"date\"}},{\"name\":\"myTimeMillis\",\"type\":{\"type\":\"int\",\"logicalType\":\"time-millis\"}},{\"name\":\"myTimestampMillis\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.DateConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.UUIDConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimeMillisConversion());
  }

  private static final BinaryMessageEncoder<Avro02> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Avro02> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Avro02> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Avro02> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Avro02> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Avro02 to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Avro02 from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Avro02 instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Avro02 fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.math.BigDecimal myDecimal;
  private java.util.UUID myUUID;
  private java.time.LocalDate myDate;
  private java.time.LocalTime myTimeMillis;
  private java.time.Instant myTimestampMillis;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Avro02() {}

  /**
   * All-args constructor.
   * @param myDecimal The new value for myDecimal
   * @param myUUID The new value for myUUID
   * @param myDate The new value for myDate
   * @param myTimeMillis The new value for myTimeMillis
   * @param myTimestampMillis The new value for myTimestampMillis
   */
  public Avro02(java.math.BigDecimal myDecimal, java.util.UUID myUUID, java.time.LocalDate myDate, java.time.LocalTime myTimeMillis, java.time.Instant myTimestampMillis) {
    this.myDecimal = myDecimal;
    this.myUUID = myUUID;
    this.myDate = myDate;
    this.myTimeMillis = myTimeMillis.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.myTimestampMillis = myTimestampMillis.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  @Override
  public SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public Object get(int field$) {
    switch (field$) {
    case 0: return myDecimal;
    case 1: return myUUID;
    case 2: return myDate;
    case 3: return myTimeMillis;
    case 4: return myTimestampMillis;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      new org.apache.avro.Conversions.DecimalConversion(),
      new org.apache.avro.Conversions.UUIDConversion(),
      new org.apache.avro.data.TimeConversions.DateConversion(),
      new org.apache.avro.data.TimeConversions.TimeMillisConversion(),
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: myDecimal = (java.math.BigDecimal)value$; break;
    case 1: myUUID = (java.util.UUID)value$; break;
    case 2: myDate = (java.time.LocalDate)value$; break;
    case 3: myTimeMillis = (java.time.LocalTime)value$; break;
    case 4: myTimestampMillis = (java.time.Instant)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'myDecimal' field.
   * @return The value of the 'myDecimal' field.
   */
  public java.math.BigDecimal getMyDecimal() {
    return myDecimal;
  }


  /**
   * Sets the value of the 'myDecimal' field.
   * @param value the value to set.
   */
  public void setMyDecimal(java.math.BigDecimal value) {
    this.myDecimal = value;
  }

  /**
   * Gets the value of the 'myUUID' field.
   * @return The value of the 'myUUID' field.
   */
  public java.util.UUID getMyUUID() {
    return myUUID;
  }


  /**
   * Sets the value of the 'myUUID' field.
   * @param value the value to set.
   */
  public void setMyUUID(java.util.UUID value) {
    this.myUUID = value;
  }

  /**
   * Gets the value of the 'myDate' field.
   * @return The value of the 'myDate' field.
   */
  public java.time.LocalDate getMyDate() {
    return myDate;
  }


  /**
   * Sets the value of the 'myDate' field.
   * @param value the value to set.
   */
  public void setMyDate(java.time.LocalDate value) {
    this.myDate = value;
  }

  /**
   * Gets the value of the 'myTimeMillis' field.
   * @return The value of the 'myTimeMillis' field.
   */
  public java.time.LocalTime getMyTimeMillis() {
    return myTimeMillis;
  }


  /**
   * Sets the value of the 'myTimeMillis' field.
   * @param value the value to set.
   */
  public void setMyTimeMillis(java.time.LocalTime value) {
    this.myTimeMillis = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'myTimestampMillis' field.
   * @return The value of the 'myTimestampMillis' field.
   */
  public java.time.Instant getMyTimestampMillis() {
    return myTimestampMillis;
  }


  /**
   * Sets the value of the 'myTimestampMillis' field.
   * @param value the value to set.
   */
  public void setMyTimestampMillis(java.time.Instant value) {
    this.myTimestampMillis = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Creates a new Avro02 RecordBuilder.
   * @return A new Avro02 RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new Avro02 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Avro02 RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * Creates a new Avro02 RecordBuilder by copying an existing Avro02 instance.
   * @param other The existing instance to copy.
   * @return A new Avro02 RecordBuilder
   */
  public static Builder newBuilder(Avro02 other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * RecordBuilder for Avro02 instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Avro02>
    implements org.apache.avro.data.RecordBuilder<Avro02> {

    private java.math.BigDecimal myDecimal;
    private java.util.UUID myUUID;
    private java.time.LocalDate myDate;
    private java.time.LocalTime myTimeMillis;
    private java.time.Instant myTimestampMillis;

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
      if (isValidValue(fields()[0], other.myDecimal)) {
        this.myDecimal = data().deepCopy(fields()[0].schema(), other.myDecimal);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.myUUID)) {
        this.myUUID = data().deepCopy(fields()[1].schema(), other.myUUID);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.myDate)) {
        this.myDate = data().deepCopy(fields()[2].schema(), other.myDate);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.myTimeMillis)) {
        this.myTimeMillis = data().deepCopy(fields()[3].schema(), other.myTimeMillis);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.myTimestampMillis)) {
        this.myTimestampMillis = data().deepCopy(fields()[4].schema(), other.myTimestampMillis);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing Avro02 instance
     * @param other The existing instance to copy.
     */
    private Builder(Avro02 other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.myDecimal)) {
        this.myDecimal = data().deepCopy(fields()[0].schema(), other.myDecimal);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.myUUID)) {
        this.myUUID = data().deepCopy(fields()[1].schema(), other.myUUID);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.myDate)) {
        this.myDate = data().deepCopy(fields()[2].schema(), other.myDate);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.myTimeMillis)) {
        this.myTimeMillis = data().deepCopy(fields()[3].schema(), other.myTimeMillis);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.myTimestampMillis)) {
        this.myTimestampMillis = data().deepCopy(fields()[4].schema(), other.myTimestampMillis);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'myDecimal' field.
      * @return The value.
      */
    public java.math.BigDecimal getMyDecimal() {
      return myDecimal;
    }


    /**
      * Sets the value of the 'myDecimal' field.
      * @param value The value of 'myDecimal'.
      * @return This builder.
      */
    public Builder setMyDecimal(java.math.BigDecimal value) {
      validate(fields()[0], value);
      this.myDecimal = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'myDecimal' field has been set.
      * @return True if the 'myDecimal' field has been set, false otherwise.
      */
    public boolean hasMyDecimal() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'myDecimal' field.
      * @return This builder.
      */
    public Builder clearMyDecimal() {
      myDecimal = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'myUUID' field.
      * @return The value.
      */
    public java.util.UUID getMyUUID() {
      return myUUID;
    }


    /**
      * Sets the value of the 'myUUID' field.
      * @param value The value of 'myUUID'.
      * @return This builder.
      */
    public Builder setMyUUID(java.util.UUID value) {
      validate(fields()[1], value);
      this.myUUID = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'myUUID' field has been set.
      * @return True if the 'myUUID' field has been set, false otherwise.
      */
    public boolean hasMyUUID() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'myUUID' field.
      * @return This builder.
      */
    public Builder clearMyUUID() {
      myUUID = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'myDate' field.
      * @return The value.
      */
    public java.time.LocalDate getMyDate() {
      return myDate;
    }


    /**
      * Sets the value of the 'myDate' field.
      * @param value The value of 'myDate'.
      * @return This builder.
      */
    public Builder setMyDate(java.time.LocalDate value) {
      validate(fields()[2], value);
      this.myDate = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'myDate' field has been set.
      * @return True if the 'myDate' field has been set, false otherwise.
      */
    public boolean hasMyDate() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'myDate' field.
      * @return This builder.
      */
    public Builder clearMyDate() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'myTimeMillis' field.
      * @return The value.
      */
    public java.time.LocalTime getMyTimeMillis() {
      return myTimeMillis;
    }


    /**
      * Sets the value of the 'myTimeMillis' field.
      * @param value The value of 'myTimeMillis'.
      * @return This builder.
      */
    public Builder setMyTimeMillis(java.time.LocalTime value) {
      validate(fields()[3], value);
      this.myTimeMillis = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'myTimeMillis' field has been set.
      * @return True if the 'myTimeMillis' field has been set, false otherwise.
      */
    public boolean hasMyTimeMillis() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'myTimeMillis' field.
      * @return This builder.
      */
    public Builder clearMyTimeMillis() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'myTimestampMillis' field.
      * @return The value.
      */
    public java.time.Instant getMyTimestampMillis() {
      return myTimestampMillis;
    }


    /**
      * Sets the value of the 'myTimestampMillis' field.
      * @param value The value of 'myTimestampMillis'.
      * @return This builder.
      */
    public Builder setMyTimestampMillis(java.time.Instant value) {
      validate(fields()[4], value);
      this.myTimestampMillis = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'myTimestampMillis' field has been set.
      * @return True if the 'myTimestampMillis' field has been set, false otherwise.
      */
    public boolean hasMyTimestampMillis() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'myTimestampMillis' field.
      * @return This builder.
      */
    public Builder clearMyTimestampMillis() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Avro02 build() {
      try {
        Avro02 record = new Avro02();
        record.myDecimal = fieldSetFlags()[0] ? this.myDecimal : (java.math.BigDecimal) defaultValue(fields()[0]);
        record.myUUID = fieldSetFlags()[1] ? this.myUUID : (java.util.UUID) defaultValue(fields()[1]);
        record.myDate = fieldSetFlags()[2] ? this.myDate : (java.time.LocalDate) defaultValue(fields()[2]);
        record.myTimeMillis = fieldSetFlags()[3] ? this.myTimeMillis : (java.time.LocalTime) defaultValue(fields()[3]);
        record.myTimestampMillis = fieldSetFlags()[4] ? this.myTimestampMillis : (java.time.Instant) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Avro02>
    WRITER$ = (org.apache.avro.io.DatumWriter<Avro02>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Avro02>
    READER$ = (org.apache.avro.io.DatumReader<Avro02>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










