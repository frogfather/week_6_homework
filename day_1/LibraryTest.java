import static org.junit.Assert.assertEquals;
import org.junit.*;

public class LibraryTest{
  Library library;
  Book book;

@Before
public void before(){
  this.library = new Library("Childrens Central Library");
  this.book = new Book();
}

@Test public void hasName(){
  assertEquals("Childrens Central Library", library.getName());
}

@Test public void noBooks(){
  assertEquals(0, library.bookCount());
}

@Test public void canAddBook(){
  library.addBook(book);
  assertEquals(1,library.bookCount());
}

@Test public void canRemoveBook(){
  library.addBook(book);
  assertEquals(1,library.bookCount());
  library.removeBook();
  assertEquals(0, library.bookCount());    
}



}
