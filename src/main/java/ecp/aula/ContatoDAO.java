package ecp.aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    //Inserir dados no banco de dados
    public void inserir(Contato contato){
        String sql = "INSERT INTO pessoa(nome,idade,telefone,email) VALUES(?,?,?,?)";
        try{
            Connection conn = Conexao.createConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setInt(2, contato.getIdade());
            stmt.setString(3, contato.getTelefone());
            stmt.setString(4, contato.getEmail());
            stmt.execute();
            stmt.close();
            conn.close();
            System.out.println("Inserido");

        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    //Listar todas infos do banco de dados
    public List<Contato> findAll(){
        String sql = "SELECT * FROM pessoa";
        List<Contato> contatos = new ArrayList<>();
        try{
            Connection conn = Conexao.createConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rst = stmt.executeQuery();
            while (rst.next()){
                Contato contato = new Contato();
                contato.setId(rst.getInt("id"));
                contato.setNome(rst.getString("nome"));
                contato.setIdade(rst.getInt("idade"));
                contato.setTelefone(rst.getString("telefone"));
                contato.setEmail(rst.getString("email"));
                contatos.add(contato);
            }
            stmt.close();
            conn.close();
            rst.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contatos;

    }
    //Atualizar info do banco de dados
    public void update(Contato contato){
        String sql = "UPDATE pessoa SET nome = ?, idade = ?, telefone = ?, email = ?" +
                "WHERE id = ?";
        try{
            Connection conn = Conexao.createConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setInt(2, contato.getIdade());
            stmt.setString(3, contato.getTelefone());
            stmt.setString(4, contato.getEmail());
            stmt.setInt(5, contato.getId());
            stmt.execute();
            stmt.close();
            conn.close();
            System.out.println("Atualizado");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //Deletar baseado na PK
    public void delete(int id){
        String sql = "DELETE FROM pessoa WHERE id = ?";
        try{
            Connection conn = Conexao.createConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            conn.close();
            System.out.println("Deletado");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
