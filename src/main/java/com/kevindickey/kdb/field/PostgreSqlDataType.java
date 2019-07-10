package com.kevindickey.kdb.field;

public enum PostgreSqlDataType implements DataType {
    BIG_INT("BIGINT"),
    BIG_SERIAL("BIGSERIAL"),
    BIT("BIT"),
    BIT_VARYING("BIT VARYING"),
    BOOLEAN("BOOLEAN"),
    BOX("BOX"),
    BYTEA("BYTEA"),
    CHARACTER("CHARACTER"),
    CHARACTER_VARYING("VARCHAR"),
    CIDR("CIDR"),
    CIRCLE("CIRCLE"),
    DATE("DATE"),
    DOUBLE_PRECISION("DOUBLE PRECISION"),
    INET("INET"),
    INTEGER("INTEGER"),
    INTERVAL("INTERVAL"),
    JSON("JSON"),
    JSONB("JSONB"),
    LINE("LINE"),
    LSEG("LSEG"),
    MACADRR("MACADRR"),
    MACADRR8("MACADRR8"),
    MONEY("MONEY"),
    NUMERIC("NUMERIC"),
    PATH("PATH"),
    PG_LSN("PG_LSN"),
    POINT("POINT"),
    POLYGON("POLYGON"),
    REAL("REAL"),
    SMALL_INT("SMALLINT"),
    SMALL_SERIAL("SMALLSERIAL"),
    SERIAL("SERIAL"),
    TEXT("TEXT"),
    TIME("TIME"),
    TIME_Z("TIME"),
    TIMESTAMP("TIMESTAMP"),
    TIMESTAMP_Z("TIMESTAMP"),
    TSQUERY("TSQUERY"),
    TSVECTOR("TSVECTOR"),
    TXID_SNAPSHOT("TXID_SNAPSHOT"),
    UUID("UUID"),
    XML("XML");


    private String dataType;

    PostgreSqlDataType() { }
 
    PostgreSqlDataType(String dataType) {
        this.dataType = dataType;
    }
 
    public String getDataType() {
        return dataType;
    }
}