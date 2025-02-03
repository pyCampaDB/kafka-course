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
public class BookAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3062515912896278893L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BookAvro\",\"namespace\":\"com.pycampadb.avro.data\",\"fields\":[{\"name\":\"title\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"author\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"price\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<BookAvro> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<BookAvro> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<BookAvro> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<BookAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<BookAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this BookAvro to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a BookAvro from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a BookAvro instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static BookAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private String title;
  private String author;
  private int price;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public BookAvro() {}

  /**
   * All-args constructor.
   * @param title The new value for title
   * @param author The new value for author
   * @param price The new value for price
   */
  public BookAvro(String title, String author, Integer price) {
    this.title = title;
    this.author = author;
    this.price = price;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public Object get(int field$) {
    switch (field$) {
    case 0: return title;
    case 1: return author;
    case 2: return price;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: title = value$ != null ? value$.toString() : null; break;
    case 1: author = value$ != null ? value$.toString() : null; break;
    case 2: price = (Integer)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'title' field.
   * @return The value of the 'title' field.
   */
  public String getTitle() {
    return title;
  }


  /**
   * Sets the value of the 'title' field.
   * @param value the value to set.
   */
  public void setTitle(String value) {
    this.title = value;
  }

  /**
   * Gets the value of the 'author' field.
   * @return The value of the 'author' field.
   */
  public String getAuthor() {
    return author;
  }


  /**
   * Sets the value of the 'author' field.
   * @param value the value to set.
   */
  public void setAuthor(String value) {
    this.author = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public int getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(int value) {
    this.price = value;
  }

  /**
   * Creates a new BookAvro RecordBuilder.
   * @return A new BookAvro RecordBuilder
   */
  public static com.pycampadb.avro.data.BookAvro.Builder newBuilder() {
    return new com.pycampadb.avro.data.BookAvro.Builder();
  }

  /**
   * Creates a new BookAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new BookAvro RecordBuilder
   */
  public static com.pycampadb.avro.data.BookAvro.Builder newBuilder(com.pycampadb.avro.data.BookAvro.Builder other) {
    if (other == null) {
      return new com.pycampadb.avro.data.BookAvro.Builder();
    } else {
      return new com.pycampadb.avro.data.BookAvro.Builder(other);
    }
  }

  /**
   * Creates a new BookAvro RecordBuilder by copying an existing BookAvro instance.
   * @param other The existing instance to copy.
   * @return A new BookAvro RecordBuilder
   */
  public static com.pycampadb.avro.data.BookAvro.Builder newBuilder(com.pycampadb.avro.data.BookAvro other) {
    if (other == null) {
      return new com.pycampadb.avro.data.BookAvro.Builder();
    } else {
      return new com.pycampadb.avro.data.BookAvro.Builder(other);
    }
  }

  /**
   * RecordBuilder for BookAvro instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BookAvro>
    implements org.apache.avro.data.RecordBuilder<BookAvro> {

    private String title;
    private String author;
    private int price;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pycampadb.avro.data.BookAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.title)) {
        this.title = data().deepCopy(fields()[0].schema(), other.title);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.author)) {
        this.author = data().deepCopy(fields()[1].schema(), other.author);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.price)) {
        this.price = data().deepCopy(fields()[2].schema(), other.price);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing BookAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pycampadb.avro.data.BookAvro other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.title)) {
        this.title = data().deepCopy(fields()[0].schema(), other.title);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.author)) {
        this.author = data().deepCopy(fields()[1].schema(), other.author);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.price)) {
        this.price = data().deepCopy(fields()[2].schema(), other.price);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'title' field.
      * @return The value.
      */
    public String getTitle() {
      return title;
    }


    /**
      * Sets the value of the 'title' field.
      * @param value The value of 'title'.
      * @return This builder.
      */
    public com.pycampadb.avro.data.BookAvro.Builder setTitle(String value) {
      validate(fields()[0], value);
      this.title = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'title' field has been set.
      * @return True if the 'title' field has been set, false otherwise.
      */
    public boolean hasTitle() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'title' field.
      * @return This builder.
      */
    public com.pycampadb.avro.data.BookAvro.Builder clearTitle() {
      title = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'author' field.
      * @return The value.
      */
    public String getAuthor() {
      return author;
    }


    /**
      * Sets the value of the 'author' field.
      * @param value The value of 'author'.
      * @return This builder.
      */
    public com.pycampadb.avro.data.BookAvro.Builder setAuthor(String value) {
      validate(fields()[1], value);
      this.author = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'author' field has been set.
      * @return True if the 'author' field has been set, false otherwise.
      */
    public boolean hasAuthor() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'author' field.
      * @return This builder.
      */
    public com.pycampadb.avro.data.BookAvro.Builder clearAuthor() {
      author = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public int getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.pycampadb.avro.data.BookAvro.Builder setPrice(int value) {
      validate(fields()[2], value);
      this.price = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.pycampadb.avro.data.BookAvro.Builder clearPrice() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public BookAvro build() {
      try {
        BookAvro record = new BookAvro();
        record.title = fieldSetFlags()[0] ? this.title : (String) defaultValue(fields()[0]);
        record.author = fieldSetFlags()[1] ? this.author : (String) defaultValue(fields()[1]);
        record.price = fieldSetFlags()[2] ? this.price : (Integer) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<BookAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<BookAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<BookAvro>
    READER$ = (org.apache.avro.io.DatumReader<BookAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.title);

    out.writeString(this.author);

    out.writeInt(this.price);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.title = in.readString();

      this.author = in.readString();

      this.price = in.readInt();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.title = in.readString();
          break;

        case 1:
          this.author = in.readString();
          break;

        case 2:
          this.price = in.readInt();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










