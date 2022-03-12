package com.example.demoand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItem {
    Connection conn;
    String ConectionRes = "";
    Boolean issSu = false;

    public List<Map<String, String>> getlist() {
        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            conn = connectionHelper.conclass();
            if (conn != null) {
                String qu = "select * from Product";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(qu);
                while (resultSet.next()) {
                    Map<String, String> dtname = new HashMap<String, String>();
                    dtname.put("Prod", resultSet.getString("Title"));
                    dtname.put("Name", resultSet.getString("ProductTypeID"));
                    dtname.put("Des", resultSet.getString("ArticleNumber"));
                    dtname.put("Col", resultSet.getString("Image"));
                    data.add(dtname);
                }
                ConectionRes = "Success";
                issSu = true;
                conn.close();
            } else {
                ConectionRes = "Failed";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }
}
