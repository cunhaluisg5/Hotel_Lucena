package br.rio.puc.inf.les.dao;

import br.rio.puc.inf.les.model.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.rio.puc.inf.les.util.PersistenceUtil;

public class ItemDAO {

    public static ItemDAO usuarioDAO;

    public static ItemDAO getInstance() {
        if (usuarioDAO == null) {
            usuarioDAO = new ItemDAO();
        }
        return usuarioDAO;
    }
    
    public Item buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Item a where a.nomeItem =:nome ");
        query.setParameter("nome", nome);

        List<Item> item = query.getResultList();
        if (item != null && item.size() > 0) {
            return item.get(0);
        }

        return null;
    }

    public List<Item> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Item As a");
        return query.getResultList();
    }

    public List<Item> buscarItemeInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from Item a group by a.nomeItem");
        return query.getResultList();
    }

        public List<Item> buscarItemeTypeInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from Item a group by a.typeItem");
        return query.getResultList();
    }

        public void remover(Item usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(usuario)) {
            usuario = em.merge(usuario);
        }
        em.remove(usuario);
        em.getTransaction().commit();
    }

    public Item persistir(Item usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            usuario = em.merge(usuario);
            em.getTransaction().commit();
            System.out.println("Registro Item gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from Item ");
       query.executeUpdate();
       em.getTransaction().commit();
    }

}
