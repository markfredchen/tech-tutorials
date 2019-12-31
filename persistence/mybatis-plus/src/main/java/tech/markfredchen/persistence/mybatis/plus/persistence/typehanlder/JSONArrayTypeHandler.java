/*
 * Copyright (c) 2015 - 2019. Shanghai Zhenhui Information Technology Co,. ltd.
 * All rights are reserved.
 *
 */

package tech.markfredchen.persistence.mybatis.plus.persistence.typehanlder;

import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author markfredchen
 * @since 2019-01-16
 */
@MappedTypes(JSONArray.class)
public class JSONArrayTypeHandler extends BaseTypeHandler<JSONArray> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JSONArray parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toJSONString());
    }

    @Override
    public JSONArray getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getNullableJSONArray(rs.getString(columnName));
    }

    @Override
    public JSONArray getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getNullableJSONArray(rs.getString(columnIndex));
    }

    @Override
    public JSONArray getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getNullableJSONArray(cs.getString(columnIndex));
    }

    private JSONArray getNullableJSONArray(String result) {
        if (!StringUtils.isEmpty(result)) {
            return JSONArray.parseArray(result);
        } else {
            return null;
        }
    }
}
