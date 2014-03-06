package org.jbehave.services.impl;

import org.jbehave.dao.PlayerDao;
import org.jbehave.model.Player;
import org.jbehave.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlayerServiceImpl  implements PlayerService{

    @Autowired(required=true)
    private PlayerDao playerDao;

    @Transactional
    public Player getPlayer() {
        playerDao = new PlayerDao();
        return playerDao.findPlayer();
    }


}
