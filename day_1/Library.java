import java.util.*;

class Library{
  private String name;
  private ArrayList<Publication> shelves;

  public Library(String name){
    this.name = name;
    this.shelves = new ArrayList<Publication>();
  }  

  public String getName(){
    return this.name;
  }

  public void addBook(Publication publication){
    shelves.add(publication);
  }

  public Publication removeBook(){
    if (bookCount() >0){
      return shelves.remove(0);
     }
    return null; 
    }

  public int bookCount(){
    return shelves.size();
    }
}