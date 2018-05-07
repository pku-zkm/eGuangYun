package com.yun.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class YunDAO {

    public YunDAO() {
        conn = DBConnection.getInstance().getConnection();
    }

    public Yun QueryByName(String name){
        Yun yun = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM YUN WHERE NAME = ");
        stringBuilder.append(name);
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(stringBuilder.toString());
            if (resultSet.next()) {
                yun = recordToYun(resultSet);
            }
            return yun;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Yun recordToYun(ResultSet resultSet) {
        Yun yun = new Yun();
        try {
            yun.setName(resultSet.getString("NAME"));
            yun.setShe(resultSet.getString("SHE"));
            yun.setTone(resultSet.getString("TONE"));
            yun.setVolume(resultSet.getInt("VOLUME"));
            yun.setPic(resultSet.getBytes("PIC"));
            return yun;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    Connection conn;
}
