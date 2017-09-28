/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giovane
 */
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
public class Sessao {
    private static SessionFactory fabricaSessao;
    private static Configuration hibernateConfig;
    // Estrutura static para garantir que a SessionFactory seja iniciada apenas uma vez
    static {
        try {
            hibernateConfig = new Configuration().configure("hibernate.cfg.xml");
            fabricaSessao = hibernateConfig.buildSessionFactory();
            atualizarBD();
        } catch (HibernateException e){
        }
    }
    // Retorna a sessão
    public static Session getSessao(){
        return fabricaSessao.openSession();
    }
 
    // Atualiza o Schema do Banco de Dados
    private static void atualizarBD(){
        SchemaUpdate se = new SchemaUpdate(hibernateConfig);
        se.execute(true, true);
    }
}