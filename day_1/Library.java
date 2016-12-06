class Library{
  private String name;
  private Book[] shelves;

  public Library(String name){
    this.name = name;
    this.shelves = new Book[10];
  }  

  public String getName(){
    return this.name;
  }

  public void addBook(Book book){
    int bookCount = bookCount();
    if (libraryFull() == false){
      shelves[bookCount] = book;
    }
  }

  public void removeBook(){
    int bookCount = bookCount();
    if (bookCount > 0){
      shelves[bookCount-1] = null;
    }
  }

  public boolean libraryFull(){
    return bookCount() == shelves.length;
  }

  public int bookCount(){
    int count =0;
    for (Book book : shelves){
      if (book != null) count++;
    }
    return count;
  }
}