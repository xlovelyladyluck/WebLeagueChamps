/**
 * @author xbitt = twilkens
 * CIS171 - Spring 2023
 * Mar 9, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Team;

public class TeamHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ListChamp");
			public void insertTeam(Team t) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				em.persist(t);
				em.getTransaction().commit();
				em.close();
			}
			
			public List<Team> showAllTeams(){
				EntityManager em = emfactory.createEntityManager();
				List<Team> allTeams = em.createQuery("SELECT t FROM Team t").getResultList();
				return allTeams;
			}
}
