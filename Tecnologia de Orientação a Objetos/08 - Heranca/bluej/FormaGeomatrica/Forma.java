

public class Forma
{
    private String nome;
    
    public Forma(){}
    
    public Forma(String nome){
        setNome(nome);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
}
