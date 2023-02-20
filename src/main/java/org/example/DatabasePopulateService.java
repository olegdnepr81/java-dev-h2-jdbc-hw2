package org.example;

import org.example.db.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) throws IOException, SQLException {
        Connection conn = Database.getInstance().getConnection();
        Statement stat = conn.createStatement();
        String sql = String.join("\n",
                Files.readAllLines(Paths.get("sql/populate_db.sql")));
        stat.executeUpdate(sql);

    }
}
