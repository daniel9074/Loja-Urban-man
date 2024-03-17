package codigos;

public class produtoCodigo {

    private int id;
    private String nome;
    private String marca;
    private double valor;
    private String tamanho;
    private String datahora;



    public produtoCodigo() {
    }

    public produtoCodigo(int id, String nome, String marca, double valor, String tamanho, String datahora) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.valor = valor;
        this.tamanho = tamanho;
        this.datahora = datahora;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    
    
    
}
