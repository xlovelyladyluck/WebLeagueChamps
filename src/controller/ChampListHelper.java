/**
 * @author xbitt = twilkens
 * CIS171 - Spring 2023
 * Feb 1, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListChamp;

/**
 * @author xbitt
 *
 */
public class ChampListHelper {

static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LeagueOfLegendsChamps");
	
	public void insertChamp(ListChamp li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListChamp> showAllChamps(){
		EntityManager em = emfactory.createEntityManager();
		List<ListChamp> allChamps = em.createQuery("SELECT i FROM ListChamp i").getResultList();
		return allChamps;
	}
	
	public void deleteItem(ListChamp toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListChamp> typedQuery = em.createQuery("select li from ListChamp li where li.champName =:selectedName and li.funRank =:selectedRank", ListChamp.class);
		typedQuery.setParameter("selectedName", toDelete.getChampName());
		typedQuery.setParameter("selectedRank", toDelete.getFunRank());
		
		typedQuery.setMaxResults(1);
		ListChamp result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	public void updateItem(ListChamp toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListChamp> searchForChampByName(String champName){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListChamp> typedQuery = em.createQuery("select li from ListChamp li where li.champName =:selectedName", ListChamp.class);
		typedQuery.setParameter("selectedName", champName);
		
		List<ListChamp> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public List<ListChamp> searchForChampByRank(String funRank){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListChamp> typedQuery = em.createQuery("select li from ListChamp li where li.funRank =:selectedRank", ListChamp.class);
		typedQuery.setParameter("selectedItem", funRank);
		
		List<ListChamp> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
