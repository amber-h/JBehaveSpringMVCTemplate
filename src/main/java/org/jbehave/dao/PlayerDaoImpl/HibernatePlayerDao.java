package org.jbehave.dao.PlayerDaoImpl;

import org.hibernate.SessionFactory;
import org.jbehave.dao.PlayerDao;
import org.jbehave.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernatePlayerDao implements PlayerDao {

    @Autowired(required=true)
    private SessionFactory sessionFactory;

    public Player findPlayer() {
//        sessionFactory.getCurrentSession().createQuery(
//                "from Player");
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
    }
}
