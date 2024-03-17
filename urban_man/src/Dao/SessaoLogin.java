 
package Dao;

 
public class SessaoLogin {
    
    
     private static SessaoLogin instance;

    private String nomeFuncionario;
    private String cargoFuncionario;

    private SessaoLogin() {
       
    }

    public static SessaoLogin getInstance() {
        if (instance == null) {
            instance = new SessaoLogin();
        }
        return instance;
    }

    // Outros métodos...

    public void setNomeFuncionario(String nome) {
        this.nomeFuncionario = nome;
    }

    public void setCargoFuncionario(String cargo) {
        this.cargoFuncionario = cargo;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }
}
    

