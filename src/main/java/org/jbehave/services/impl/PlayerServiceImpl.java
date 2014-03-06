package org.jbehave.services.impl;

import org.jbehave.model.Player;
import org.jbehave.services.PlayerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlayerServiceImpl  implements PlayerService{

//    @Autowired(required=true)
//    private PlayerDao playerDao;

    @Transactional
    public Player getPlayer() {
//        playerDao = new HibernatePlayerDao();
//        return playerDao.findPlayer();
        return null;
    }


}
