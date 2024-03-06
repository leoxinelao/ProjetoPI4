
package Model;

public class FuncionarioDTO {
    
    private String nome_funcionario, cpf_funcionario, email_funcionario, senha_funcionario, grupo_funcionario, status_funcionario;
    private int id_funcionario;
    
    
    public String getEmail_funcionario() {
        return email_funcionario;
    }

    public void setEmail_funcionario(String email_funcionario) {
        this.email_funcionario = email_funcionario;
    }

    public String getSenha_funcionario() {
        return senha_funcionario;
    }

    public void setSenha_funcionario(String senha_funcionario) {
        this.senha_funcionario = senha_funcionario;
    }

    public String getGrupo_funcionario() {
        return grupo_funcionario;
    }

    public void setGrupo_funcionario(String grupo_funcionario) {
        this.grupo_funcionario = grupo_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nme_funcionari) {
        this.nome_funcionario = nme_funcionari;
    }

    public String getCpf_funcionario() {
        return cpf_funcionario;
    }

    public void setCpf_funcionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getStatus_funcionario() {
        return status_funcionario;
    }

    public void setStatus_funcionario(String status_funcionario) {
        this.status_funcionario = status_funcionario;
    }
  
    
}
