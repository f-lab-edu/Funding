package com.flab.funding.domain.funding.infrastructure;

import com.flab.funding.domain.funding.model.FundingStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(FundingStatus.class)
public class FundingStatusTypeHandler implements TypeHandler<FundingStatus> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, FundingStatus fundingStatus, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, fundingStatus.getStatusCode());
    }

    @Override
    public FundingStatus getResult(ResultSet resultSet, String s) throws SQLException {
        final var statusCode = resultSet.getInt(s);
        return FundingStatus.getStatusName(statusCode);
    }

    @Override
    public FundingStatus getResult(ResultSet resultSet, int i) throws SQLException {
        final var statusCode = resultSet.getInt(i);
        return FundingStatus.getStatusName(statusCode);
    }

    @Override
    public FundingStatus getResult(CallableStatement callableStatement, int i) throws SQLException {
        final var statusCode = callableStatement.getInt(i);
        return FundingStatus.getStatusName(statusCode);
    }


}
