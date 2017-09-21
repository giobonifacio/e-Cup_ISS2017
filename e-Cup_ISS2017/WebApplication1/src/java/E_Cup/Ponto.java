/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E_Cup;

/**
 *
 * @author mariana
 */
public class Ponto {
    private int ID;
    private String descricao;
    private int valor;
    
    public enum TiposPontuacao{
        GOL(0), LANCELIVRE(1), DENTROGARRAFAO(2),FORAGARRAFAO(3);
        
        public int valorEscolha;
        TiposPontuacao(int val){
            valorEscolha = val;
        }
        
        public int getEscolha(){
            return valorEscolha;
        }
    }
    
    public void setPonto(TiposPontuacao tipo){
        ID = tipo.getEscolha();
    }
    
    public int getPonto(){
        return ID;
    }
    
    public void inserirPonto(){}
    
}
