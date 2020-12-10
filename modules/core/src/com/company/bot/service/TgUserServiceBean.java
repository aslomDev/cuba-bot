package com.company.bot.service;

import com.company.bot.entity.TgUser;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.Metadata;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(TgUserService.NAME)
public class TgUserServiceBean implements TgUserService {
    @Inject
    private Persistence persistence;
    @Inject private Metadata metadata;

    @Override
    public void createUserTg(long id) {
        Transaction tx = persistence.createTransaction();

        try {
            EntityManager em = persistence.getEntityManager();
            TgUser tgUser = metadata.create(TgUser.class);
            tgUser.setUserId(id);
            em.persist(tgUser);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.end();
    }
}