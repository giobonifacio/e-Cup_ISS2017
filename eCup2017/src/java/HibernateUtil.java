/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giovane
 */
import bean.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class HibernateUtil {
    private Session sessao;
    private Transaction transacao;
    private Query query;
     
    public List select(){
        List<Usuario> lista = new ArrayList();
        try {
            this.sessao = Sessao.getSessao();
            transacao = sessao.beginTransaction();
            query = sessao.createQuery("from usuario");
            lista = query.list();
            sessao.close();
        } catch (HibernateException e) { 
            JOptionPane.showMessageDialog(null, "Erro ao realizar Select.\n"+e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
           e.printStackTrace(); 
       }
       return lista;
   }
    
    public void insertUpdate(Usuario pessoa){
        try{
            this.sessao = Sessao.getSessao();
            transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(pessoa);
            transacao.commit();
            sessao.close();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (HibernateException e) { 
            JOptionPane.showMessageDialog(null, "Erro ao persistir os dados.\n"+e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    }
     
    public void delete(Usuario pessoa){
        try{
            this.sessao = Sessao.getSessao();
            transacao = sessao.beginTransaction();
            sessao.delete(pessoa);
            transacao.commit();
            sessao.close();
            JOptionPane.showMessageDialog(null, "Registro deletado com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (HibernateException e) { 
            JOptionPane.showMessageDialog(null, "Erro ao deletar registro.\n"+e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    }
}