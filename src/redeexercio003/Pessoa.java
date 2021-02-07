package redeexercio003;

import java.io.Serializable;

/**
 *
 * @author Edilson do Nascimento
 */
public class Pessoa implements Serializable{
    
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }   
        
    
}
