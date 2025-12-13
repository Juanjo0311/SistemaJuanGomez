/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.JjmClientes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u1845853
 */
public class ClientesDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JjmClientes.class);
        criteria.add(Restrictions.eq("jjm_id_cliente", codigo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
     public Object listNomes(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JjmClientes.class);
        criteria.add(Restrictions.like("jjm_nome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
        
        public Object listAtivo(String ativo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JjmClientes.class);
        criteria.add(Restrictions.eq("jjm_ativo", ativo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeAtivo(String nome, String ativo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JjmClientes.class);
        criteria.add(Restrictions.like("jjm_nome", "%" + nome + "%"));
        criteria.add(Restrictions.eq("jjm_ativo", ativo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JjmClientes.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        ClientesDAO usuariosDAO = new ClientesDAO();
        usuariosDAO.listAll();
    }
}
