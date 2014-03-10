package org.jbehave.dao;

import org.hibernate.SessionFactory;
import org.jbehave.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao {

    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public PlayerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Player findPlayer() {
        sessionFactory.getCurrentSession().createQuery(
                "from Player");
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

