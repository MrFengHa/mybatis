package com.home.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/12/2 22:46
 */
public class DateTypeHandle extends BaseTypeHandler<Date> {

    /**
     * 将java类型换换成数据库需要的类型
     *
     * @param preparedStatement
     * @param i
     * @param date
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {

        preparedStatement.setLong(i, date.getTime());
    }

    /**
     * 将数据库中的类型转化成java类型
     *
     * @param resultSet 查询出的结果集
     * @param s         数据库中要转换字段的名称
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        //获取结果集中需要的数据（long）转换成Date类型  返回
        Date date = new Date(resultSet.getLong(s));
        return date;
    }

    /**
     * 将数据库中的类型转化成java类型
     *
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        //获取结果集中需要的数据（long）转换成Date类型  返回
        Date date = new Date(resultSet.getLong(i));
        return date;
    }

    /**
     * 将数据库中的类型转化成java类型
     *
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Date date = new Date(callableStatement.getLong(i));
        return date;
    }
}
