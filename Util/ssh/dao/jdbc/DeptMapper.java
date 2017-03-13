package com.wangxin.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeptMapper implements RowMapper {
	//һ�м�¼����һ�Σ�����¼ӳ���entity����
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		Dept dept = new Dept();
		dept.setId(rs.getInt("id"));
		dept.setName(rs.getString("name"));
		dept.setCity(rs.getString("city"));
		return dept;
	}

}
