/*
 * Copyright (c) 2015 - 2018. Shanghai Zhenhui Information Technology Co,. ltd.
 *  All rights are reserved.
 */

package tech.markfredchen.persistence.mybatis.plus.persistence.typehanlder;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author markfredchen
 * @date 2017/3/9
 */
@MappedTypes(ZonedDateTime.class)
public class ZonedDateTimeTypeHandler extends BaseTypeHandler<ZonedDateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ZonedDateTime parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setTimestamp(i, Timestamp.from(parameter.toInstant()));
    }

    @Override
    public ZonedDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Date date = rs.getDate(columnName);
        return getNullableZonedDateTime(date);
    }

    @Override
    public ZonedDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Date date = rs.getDate(columnIndex);
        return getNullableZonedDateTime(date);
    }

    @Override
    public ZonedDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Date date = cs.getDate(columnIndex);
        return getNullableZonedDateTime(date);
    }

    private ZonedDateTime getNullableZonedDateTime(Date result) {
        if (result != null) {
            java.util.Date date = new java.util.Date(result.getTime());
            return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        } else {
            return null;
        }
    }
}
