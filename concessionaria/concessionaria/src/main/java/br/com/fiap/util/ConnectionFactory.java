package br.com.fiap.util;

import br.com.fiap.App;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

  public static Connection getConnection() throws SQLException, IOException {
    Properties properties = new Properties();
    InputStream resourceAsStream =
      App.class.getResourceAsStream("application.properties");
    properties.load(resourceAsStream);

    String url = properties.getProperty("database.url");
    String user = properties.getProperty("database.user");
    String password = properties.getProperty("database.password");

    return DriverManager.getConnection(url, user, password);
  }
}
