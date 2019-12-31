/*
 * Copyright (c) 2015 - 2018. Shanghai Zhenhui Information Technology Co,. ltd.
 *  All rights are reserved.
 */

package tech.markfredchen.persistence.mybatis.plus.persistence.typehanlder;

import com.alibaba.fastjson.JSONObject;
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
 * @date 07/06/2017
 */
@MappedTypes(JSONObject.class)
public class JSONObjectTypeHandler extends BaseTypeHandler<JSONObject> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JSONObject jsonObject, JdbcType jdbcType) throws SQLException {
        ps.setString(i, jsonObject.toJSONString());
    }

    @Override
    public JSONObject getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getNullableJSONObject(rs.getString(columnName));
    }

    @Override
    public JSONObject getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getNullableJSONObject(rs.getString(columnIndex));
    }

    @Override
    public JSONObject getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getNullableJSONObject(cs.getString(columnIndex));
    }

    private JSONObject getNullableJSONObject(String result) {
        if (!StringUtils.isEmpty(result)) {
            return JSONObject.parseObject(result);
        } else {
            return null;
        }
    }
}
