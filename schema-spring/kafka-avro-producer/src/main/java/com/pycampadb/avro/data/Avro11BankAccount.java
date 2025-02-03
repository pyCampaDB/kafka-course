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
public class Avro11BankAccount extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6048365370518604848L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Avro11BankAccount\",\"namespace\":\"com.pycampadb.avro.data\",\"fields\":[{\"name\":\"bankName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"accountHolderName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"accountNumber\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"bankClearingCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"currencyCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Avro11BankAccount> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Avro11BankAccount> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Avro11BankAccount> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Avro11BankAccount> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Avro11BankAccount> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Avro11BankAccount to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Avro11BankAccount from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Avro11BankAccount instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Avro11BankAccount fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private String bankName;
  private String accountHolderName;
  private String accountNumber;
  private String bankClearingCode;
  private String currencyCode;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Avro11BankAccount() {}

  /**
   * All-args constructor.
   * @param bankName The new value for bankName
   * @param accountHolderName The new value for accountHolderName
   * @param accountNumber The new value for accountNumber
   * @param bankClearingCode The new value for bankClearingCode
   * @param currencyCode The new value for currencyCode
   */
  public Avro11BankAccount(String bankName, String accountHolderName, String accountNumber, String bankClearingCode, String currencyCode) {
    this.bankName = bankName;
    this.accountHolderName = accountHolderName;
    this.accountNumber = accountNumber;
    this.bankClearingCode = bankClearingCode;
    this.currencyCode = currencyCode;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public Object get(int field$) {
    switch (field$) {
    case 0: return bankName;
    case 1: return accountHolderName;
    case 2: return accountNumber;
    case 3: return bankClearingCode;
    case 4: return currencyCode;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: bankName = value$ != null ? value$.toString() : null; break;
    case 1: accountHolderName = value$ != null ? value$.toString() : null; break;
    case 2: accountNumber = value$ != null ? value$.toString() : null; break;
    case 3: bankClearingCode = value$ != null ? value$.toString() : null; break;
    case 4: currencyCode = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'bankName' field.
   * @return The value of the 'bankName' field.
   */
  public String getBankName() {
    return bankName;
  }


  /**
   * Sets the value of the 'bankName' field.
   * @param value the value to set.
   */
  public void setBankName(String value) {
    this.bankName = value;
  }

  /**
   * Gets the value of the 'accountHolderName' field.
   * @return The value of the 'accountHolderName' field.
   */
  public String getAccountHolderName() {
    return accountHolderName;
  }


  /**
   * Sets the value of the 'accountHolderName' field.
   * @param value the value to set.
   */
  public void setAccountHolderName(String value) {
    this.accountHolderName = value;
  }

  /**
   * Gets the value of the 'accountNumber' field.
   * @return The value of the 'accountNumber' field.
   */
  public String getAccountNumber() {
    return accountNumber;
  }


  /**
   * Sets the value of the 'accountNumber' field.
   * @param value the value to set.
   */
  public void setAccountNumber(String value) {
    this.accountNumber = value;
  }

  /**
   * Gets the value of the 'bankClearingCode' field.
   * @return The value of the 'bankClearingCode' field.
   */
  public String getBankClearingCode() {
    return bankClearingCode;
  }


  /**
   * Sets the value of the 'bankClearingCode' field.
   * @param value the value to set.
   */
  public void setBankClearingCode(String value) {
    this.bankClearingCode = value;
  }

  /**
   * Gets the value of the 'currencyCode' field.
   * @return The value of the 'currencyCode' field.
   */
  public String getCurrencyCode() {
    return currencyCode;
  }


  /**
   * Sets the value of the 'currencyCode' field.
   * @param value the value to set.
   */
  public void setCurrencyCode(String value) {
    this.currencyCode = value;
  }

  /**
   * Creates a new Avro11BankAccount RecordBuilder.
   * @return A new Avro11BankAccount RecordBuilder
   */
  public static com.pycampadb.avro.data.Avro11BankAccount.Builder newBuilder() {
    return new com.pycampadb.avro.data.Avro11BankAccount.Builder();
  }

  /**
   * Creates a new Avro11BankAccount RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Avro11BankAccount RecordBuilder
   */
  public static com.pycampadb.avro.data.Avro11BankAccount.Builder newBuilder(com.pycampadb.avro.data.Avro11BankAccount.Builder other) {
    if (other == null) {
      return new com.pycampadb.avro.data.Avro11BankAccount.Builder();
    } else {
      return new com.pycampadb.avro.data.Avro11BankAccount.Builder(other);
    }
  }

  /**
   * Creates a new Avro11BankAccount RecordBuilder by copying an existing Avro11BankAccount instance.
   * @param other The existing instance to copy.
   * @return A new Avro11BankAccount RecordBuilder
   */
  public static com.pycampadb.avro.data.Avro11BankAccount.Builder newBuilder(com.pycampadb.avro.data.Avro11BankAccount other) {
    if (other == null) {
      return new com.pycampadb.avro.data.Avro11BankAccount.Builder();
    } else {
      return new com.pycampadb.avro.data.Avro11BankAccount.Builder(other);
    }
  }

  /**
   * RecordBuilder for Avro11BankAccount instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Avro11BankAccount>
    implements org.apache.avro.data.RecordBuilder<Avro11BankAccount> {

    private String bankName;
    private String accountHolderName;
    private String accountNumber;
    private String bankClearingCode;
    private String currencyCode;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pycampadb.avro.data.Avro11BankAccount.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.bankName)) {
        this.bankName = data().deepCopy(fields()[0].schema(), other.bankName);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.accountHolderName)) {
        this.accountHolderName = data().deepCopy(fields()[1].schema(), other.accountHolderName);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.accountNumber)) {
        this.accountNumber = data().deepCopy(fields()[2].schema(), other.accountNumber);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.bankClearingCode)) {
        this.bankClearingCode = data().deepCopy(fields()[3].schema(), other.bankClearingCode);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.currencyCode)) {
        this.currencyCode = data().deepCopy(fields()[4].schema(), other.currencyCode);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing Avro11BankAccount instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pycampadb.avro.data.Avro11BankAccount other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.bankName)) {
        this.bankName = data().deepCopy(fields()[0].schema(), other.bankName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.accountHolderName)) {
        this.accountHolderName = data().deepCopy(fields()[1].schema(), other.accountHolderName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.accountNumber)) {
        this.accountNumber = data().deepCopy(fields()[2].schema(), other.accountNumber);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bankClearingCode)) {
        this.bankClearingCode = data().deepCopy(fields()[3].schema(), other.bankClearingCode);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.currencyCode)) {
        this.currencyCode = data().deepCopy(fields()[4].schema(), other.currencyCode);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'bankName' field.
      * @return The value.
      */
    public String getBankName() {
      return bankName;
    }


    /**
      * Sets the value of the 'bankName' field.
      * @param value The value of 'bankName'.
      * @return This builder.
      */
    public com.pycampadb.avro.data.Avro11BankAccount.Builder setBankName(String value) {
      validate(fields()[0], value);
      this.bankName = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'bankName' field has been set.
      * @return True if the 'bankName' field has been set, false otherwise.
      */
    public boolean hasBankName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'bankName' field.
      * @return This builder.
      */
    public com.pycampadb.avro.data.Avro11BankAccount.Builder clearBankName() {
      bankName = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'accountHolderName' field.
      * @return The value.
      */
    public String getAccountHolderName() {
      return accountHolderName;
    }


    /**
      * Sets the value of the 'accountHolderName' field.
      * @param value The value of 'accountHolderName'.
      * @return This builder.
      */
    public com.pycampadb.avro.data.Avro11BankAccount.Builder setAccountHolderName(String value) {
      validate(fields()[1], value);
      this.accountHolderName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'accountHolderName' field has been set.
      * @return True if the 'accountHolderName' field has been set, false otherwise.
      */
    public boolean hasAccountHolderName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'accountHolderName' field.
      * @return This builder.
      */
    public com.pycampadb.avro.data.Avro11BankAccount.Builder clearAccountHolderName() {
      accountHolderName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'accountNumber' field.
      * @return The value.
      */
    public String getAccountNumber() {
      return accountNumber;
    }


    /**
      * Sets the value of the 'accountNumber' field.
      * @param value The value of 'accountNumber'.
      * @return This builder.
      */
    public com.pycampadb.avro.data.Avro11BankAccount.Builder setAccountNumber(String value) {
      validate(fields()[2], value);
      this.accountNumber = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'accountNumber' field has been set.
      * @return True if the 'accountNumber' field has been set, false otherwise.
      */
    public boolean hasAccountNumber() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'accountNumber' field.
      * @return This builder.
      */
    public com.pycampadb.avro.data.Avro11BankAccount.Builder clearAccountNumber() {
      accountNumber = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'bankClearingCode' field.
      * @return The value.
      */
    public String getBankClearingCode() {
      return bankClearingCode;
    }


    /**
      * Sets the value of the 'bankClearingCode' field.
      * @param value The value of 'bankClearingCode'.
      * @return This builder.
      */
    public com.pycampadb.avro.data.Avro11BankAccount.Builder setBankClearingCode(String value) {
      validate(fields()[3], value);
      this.bankClearingCode = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'bankClearingCode' field has been set.
      * @return True if the 'bankClearingCode' field has been set, false otherwise.
      */
    public boolean hasBankClearingCode() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'bankClearingCode' field.
      * @return This builder.
      */
    public com.pycampadb.avro.data.Avro11BankAccount.Builder clearBankClearingCode() {
      bankClearingCode = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'currencyCode' field.
      * @return The value.
      */
    public String getCurrencyCode() {
      return currencyCode;
    }


    /**
      * Sets the value of the 'currencyCode' field.
      * @param value The value of 'currencyCode'.
      * @return This builder.
      */
    public com.pycampadb.avro.data.Avro11BankAccount.Builder setCurrencyCode(String value) {
      validate(fields()[4], value);
      this.currencyCode = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'currencyCode' field has been set.
      * @return True if the 'currencyCode' field has been set, false otherwise.
      */
    public boolean hasCurrencyCode() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'currencyCode' field.
      * @return This builder.
      */
    public com.pycampadb.avro.data.Avro11BankAccount.Builder clearCurrencyCode() {
      currencyCode = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Avro11BankAccount build() {
      try {
        Avro11BankAccount record = new Avro11BankAccount();
        record.bankName = fieldSetFlags()[0] ? this.bankName : (String) defaultValue(fields()[0]);
        record.accountHolderName = fieldSetFlags()[1] ? this.accountHolderName : (String) defaultValue(fields()[1]);
        record.accountNumber = fieldSetFlags()[2] ? this.accountNumber : (String) defaultValue(fields()[2]);
        record.bankClearingCode = fieldSetFlags()[3] ? this.bankClearingCode : (String) defaultValue(fields()[3]);
        record.currencyCode = fieldSetFlags()[4] ? this.currencyCode : (String) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Avro11BankAccount>
    WRITER$ = (org.apache.avro.io.DatumWriter<Avro11BankAccount>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Avro11BankAccount>
    READER$ = (org.apache.avro.io.DatumReader<Avro11BankAccount>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.bankName);

    out.writeString(this.accountHolderName);

    out.writeString(this.accountNumber);

    out.writeString(this.bankClearingCode);

    out.writeString(this.currencyCode);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.bankName = in.readString();

      this.accountHolderName = in.readString();

      this.accountNumber = in.readString();

      this.bankClearingCode = in.readString();

      this.currencyCode = in.readString();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.bankName = in.readString();
          break;

        case 1:
          this.accountHolderName = in.readString();
          break;

        case 2:
          this.accountNumber = in.readString();
          break;

        case 3:
          this.bankClearingCode = in.readString();
          break;

        case 4:
          this.currencyCode = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










