package com.flab.funding.domain.funding.infrastructure;

import com.flab.funding.domain.funding.model.OrderStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(OrderStatus.class)
public class FundingStatusTypeHandler implements TypeHandler<OrderStatus> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, OrderStatus fundingStatus, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, fundingStatus.getStatusCode());
    }

    @Override
    public OrderStatus getResult(ResultSet resultSet, String s) throws SQLException {
        final var statusCode = resultSet.getInt(s);
        return OrderStatus.getStatusName(statusCode);
    }

    @Override
    public OrderStatus getResult(ResultSet resultSet, int i) throws SQLException {
        final var statusCode = resultSet.getInt(i);
        return OrderStatus.getStatusName(statusCode);
    }

    @Override
    public OrderStatus getResult(CallableStatement callableStatement, int i) throws SQLException {
        final var statusCode = callableStatement.getInt(i);
        return OrderStatus.getStatusName(statusCode);
    }


}
