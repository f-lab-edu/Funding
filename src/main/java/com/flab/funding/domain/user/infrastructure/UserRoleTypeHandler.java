package com.flab.funding.domain.user.infrastructure;

import com.flab.funding.domain.user.entity.UserRole;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(UserRole.class)
public class UserRoleTypeHandler implements TypeHandler<UserRole> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, UserRole userRole, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, userRole.getRoleCode());
    }

    @Override
    public UserRole getResult(ResultSet resultSet, String s) throws SQLException {
        final var roleCode = resultSet.getInt(s);
        return UserRole.getRoleName(roleCode);
    }

    @Override
    public UserRole getResult(ResultSet resultSet, int i) throws SQLException {
        final var roleCode = resultSet.getInt(i);
        return UserRole.getRoleName(roleCode);
    }

    @Override
    public UserRole getResult(CallableStatement callableStatement, int i) throws SQLException {
        final var roleCode = callableStatement.getInt(i);
        return UserRole.getRoleName(roleCode);
    }


}
