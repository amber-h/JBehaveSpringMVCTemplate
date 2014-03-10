package org.jbehave.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jbehave.model.Player;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlayerDaoTest {

    PlayerDao playerDao;

    @Mock
    SessionFactory sessionFactory;
    @Mock
    Session sessionMock;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
//        playerDao = new PlayerDao(sessionFactory);
    }

    @Ignore
    @Test
    public void shouldFindPlayer() throws Exception {
        when(sessionFactory.getCurrentSession()).thenReturn(sessionMock);
        // when(sessionMock.createQuery(...)).thenReturn(...);
//        Player player = playerDao.findPlayer();

    }
}
