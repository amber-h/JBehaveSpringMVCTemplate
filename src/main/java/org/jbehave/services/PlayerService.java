package org.jbehave.services;

import org.jbehave.dao.PlayerDao;
import org.jbehave.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlayerService {

    private PlayerDao playerDao;

    @Autowired(required=true)
    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Transactional
    public Player getPlayer() {
        return playerDao.findPlayer();
    }


}
