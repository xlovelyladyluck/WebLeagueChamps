/**
 * @author xbitt = twilkens
 * CIS171 - Spring 2023
 * Feb 1, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ListChamp")
public class ListChamp {
	@Id
	@GeneratedValue
	@Column(name="CHAMPNAME")
	private String champName;
	@Column(name="FUNRANK")
	private String funRank;
	@Column(name="ID")
	private int id;
	
	
	public ListChamp() {
		super();
	}
	
	public ListChamp(String champName, String funRank) {
		this.champName = champName;
		this.funRank = funRank;
	}
	
	
	public String getChampName() {
		return champName;
	}

	public void setChampName(String champName) {
		this.champName = champName;
	}

	public String getFunRank() {
		return funRank;
	}

	public void setFunRank(String funRank) {
		this.funRank = funRank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String returnItemDetails() {
		return this.champName+ " is ranked with the fun scaling of :"+this.funRank;
	}
	
	
	
}
