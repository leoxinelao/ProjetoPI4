package DAO;

import Model.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> lista = new ArrayList<>();

        public void cadastrarFuncionario(FuncionarioDTO objfuncionariodto) {
        String sql = "insert into funcionario (nome_funcionario, email_funcionario, cpf_funcionario, senha_funcionario, grupo_funcionario, status_funcionario) values (?,?,?,?,?,?)";

        conn = new ConexaoDao().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome_funcionario());
            pstm.setString(2, objfuncionariodto.getEmail_funcionario());
            pstm.setString(3, objfuncionariodto.getCpf_funcionario());
            pstm.setString(4, objfuncionariodto.getSenha_funcionario());
            pstm.setString(5, objfuncionariodto.getGrupo_funcionario());
            pstm.setString(6, objfuncionariodto.getStatus_funcionario());

            pstm.execute();
            pstm.close();
          JOptionPane.showMessageDialog(null, "Funcionario Cadastrado!");
        } catch (SQLException erro) {
            if (erro.getSQLState().equals("23000")){
                JOptionPane.showMessageDialog(null, "Login já cadastrado!");
                return;
            } 
            JOptionPane.showMessageDialog(null, "funcionarioDAO Cadastrar" + erro);
        }

    }

    public ArrayList<FuncionarioDTO> PesquisarFuncionario(String nome) {
        String sql = "SELECT * FROM funcionario WHERE nome_funcionario = ?";
        conn = new ConexaoDao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
                objFuncionarioDTO.setId_funcionario(rs.getInt("id_funcionario"));
                objFuncionarioDTO.setNome_funcionario(rs.getString("nome_funcionario"));
                objFuncionarioDTO.setEmail_funcionario(rs.getNString("email_funcionario"));
                objFuncionarioDTO.setStatus_funcionario(rs.getNString("status_funcionario"));
                

                lista.add(objFuncionarioDTO);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Funcionario pesquisar: " + erro);
        }
        return lista;

    }
    public ArrayList<FuncionarioDTO> Pesquisar() {
        String sql = "Select * from funcionario";
        conn = new ConexaoDao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
                objFuncionarioDTO.setId_funcionario(rs.getInt("id_funcionario"));
                objFuncionarioDTO.setNome_funcionario(rs.getString("nome_funcionario"));
                objFuncionarioDTO.setEmail_funcionario(rs.getNString("email_funcionario"));
                objFuncionarioDTO.setStatus_funcionario(rs.getNString("status_funcionario"));

                lista.add(objFuncionarioDTO);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Funcionario pesquisar: " + erro);
        }
        return lista;
    }
    public void alterarFuncionario(FuncionarioDTO objfuncionariodto){
        String sql = "update funcionario set nome_funcionario = ?, cpf_funcionario = ?, grupo_funcionario = ?, senha_funcionario = ? where id_funcionario = ?";
     
         conn = new ConexaoDao().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome_funcionario());
            pstm.setString(2, objfuncionariodto.getCpf_funcionario());
            pstm.setString(3, objfuncionariodto.getGrupo_funcionario());
            pstm.setString(4, objfuncionariodto.getSenha_funcionario());
            pstm.setInt(5, objfuncionariodto.getId_funcionario());

            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Funcionario alterado!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "funcionarioDAO Alterar" + erro);
        }
    }
    public void statusFuncionario(FuncionarioDTO objfuncionariodto){
        String sql = "update funcionario set status_funcionario = ? where id_funcionario = ?";
     
         conn = new ConexaoDao().conectaBD();
         
        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getStatus_funcionario());
            pstm.setInt(2, objfuncionariodto.getId_funcionario());

            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Status alterado!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "funcionarioDAO Status" + erro);
        }
    }
    public ResultSet autenticacaoUsuario(FuncionarioDTO funcionarioDTO){
        conn = new ConexaoDao().conectaBD();
        
        try {
            String sql = "select * from funcionario where email_funcionario = ? and senha_funcionario = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionarioDTO.getEmail_funcionario());
            pstm.setString(2, funcionarioDTO.getSenha_funcionario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"funcionarioDAO: "+ erro);
            return null;
        }
        
    }
      public void excluirFuncionario(FuncionarioDTO objfuncionariodto){
          String sql = "delete from funcionario where id_funcionario = ? ";
          
         conn = new ConexaoDao().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
           
            
            pstm.setInt(1, objfuncionariodto.getId_funcionario());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "funcionarioDAO Excluir" + erro);
        }
      }
}
