/**
 * @author xbitt = twilkens
 * CIS171 - Spring 2023
 * Feb 1, 2023
 */

import java.util.List;
import java.util.Scanner;

import controller.ChampListHelper;
import model.ListChamp;


public class InterfaceProgram {

		static Scanner in = new Scanner(System.in);
		static ChampListHelper clh = new ChampListHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a Champion's name from LOL: ");
			String name = in.nextLine();
			System.out.print("Enter an opinionated rank of how fun the champion is: ");
			String rank = in.nextLine();
			ListChamp toAdd = new ListChamp(name, rank);
			clh.insertChamp(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the champion to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the fun rank to delete: ");
			String rank = in.nextLine();
			ListChamp toDelete = new ListChamp(name, rank);
			clh.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Champion's Name");
			System.out.println("2 : Search by Champion's Fun rank");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListChamp> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the store name: ");
				String champName = in.nextLine();
				foundItems = clh.searchForChampByName(champName);
				
			} else {
				System.out.print("Enter the item: ");
				String funRank = in.nextLine();
				foundItems = clh.searchForChampByRank(funRank);

			}

			/*if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListChamp l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				List<ListChamp> toEdit = clh.searchForChampById(idToEdit);
				System.out.println("Retrieved " + toEdit.getFunRank() + " from " + toEdit.getChampName());
				System.out.println("1 : Update Champ");
				System.out.println("2 : Update Rank");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Champion name: ");
					String newName = in.nextLine();
					toEdit.setChampName(newName);
				} else if (update == 2) {
					System.out.print("New Rank: ");
					String newRank = in.nextLine();
					toEdit.setFunRank(newRank);
				}

				clh.updateItem(toEdit);

			}*/ if(!foundItems.isEmpty()) {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();
		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the LOL champions list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the league champ program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					clh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListChamp> allChamps = clh.showAllChamps();
			for(ListChamp singleItem : allChamps) {
				System.out.println(singleItem.returnItemDetails());

			}
			

		}
}

	