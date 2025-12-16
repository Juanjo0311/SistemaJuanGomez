package dao;

import bean.JjmVendedor;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class VendedorDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(JjmVendedor.class);
        criteria.add(Restrictions.eq("jjm_id_vendedor", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNome(String jjm_nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JjmVendedor.class);
        criteria.add(Restrictions.like("jjm_nome", "%" + jjm_nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listDatadeCadastroDaTaylor(Date datadecadastro) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JjmVendedor.class);
        criteria.add(Restrictions.ge("jjm_data_cadrastro", datadecadastro));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeDataTrabalhoTaylor(String jjm_nome, Date datadecadastro) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JjmVendedor.class);
        criteria.add(Restrictions.like("jjm_nome", "%" + jjm_nome + "%"));
        criteria.add(Restrictions.ge("jjm_data_cadrastro", datadecadastro));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JjmVendedor.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        VendedorDAO usuariosDAO = new VendedorDAO();
        usuariosDAO.listAll();
        System.out.println("teste ok");
    }
}
