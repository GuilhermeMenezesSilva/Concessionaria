package br.com.fiap.dao;

import br.com.fiap.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

  public void inserir(Cliente cliente) throws SQLException {
    Connection con = ConnectionFactory.getConnection();

    String sql =
      "INSERT INTO DDD_CONCESSIONARIA_TB_CLIENTES (id, nome, email, telefone) " +
      "VALUES (SEQ_CLIENTE.nextVal, ?, ?, ?)";
    PreparedStatement stm = con.prepareStatement(sql);
    stm.setString(1, cliente.nome());
    stm.setString(2, cliente.email());
    stm.setString(3, cliente.telefone());

    stm.execute();
    con.close();
  }

  public List<Cliente> buscar() {
    return new ArrayList<Cliente>();
  }
}
