package day_0724.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 나중에는 이 클래스가 데이터베이스에 데이터를 관리하는 역할로 변경할 예정.
 * 현재는 이 곳이 데이터베이스라는 생각으로..
 * 
 * 3가지 버전으로 만들어 볼 것.
 * 
 * 오늘의 실습1 : 객체 배열로 데이터 저장
 * 오늘의 실습2 : ArrayList 또는 Linked List<Book> 저장 -> 최대 갯수의 제한이 없어진다.
 * 오늘의 실습3 : Map을 활용하여 데이터 저장 -> 최대 갯수의 제한이 없어진다.
 */
public class BookManagerImpl implements IBookManager{

    private static BookManagerImpl bookManager = null;
    
    private static final int SIZE = 100; // 책을 관리할 수 있는 사이즈
    private static int TOP = 0;
    private final Book[] books = new Book[SIZE];
    // private List<Book> books;
    // private Map<String, Book> books;
    
    // 클래스내에 생성자가 하나라도 존재하면 컴파일러는 기본생성자를 끼워넣지 않음.
    private BookManagerImpl() {}
    
    public static BookManagerImpl getInstance() {
        if(bookManager == null) {
            bookManager = new BookManagerImpl();
        }
        
        return bookManager;
    }
    
    @Override
    public void add(Book book) {
        if(TOP + 1 == SIZE) { 
            System.out.println("책 공간이 없습니다.");
            return;
        }
        
        books[TOP++] = book;
    }

    @Override
    public void remove(String isbn) {
        if(TOP == 0) {
            System.out.println("보관중인 책이 없음으로, 삭제할 수 없습니다.");
            return;
        }

        for(int i = 0; i < TOP; i++) {
            Book book = books[i];
            
            if(book.getIsbn().equals(isbn)) {
                
                for(int j = TOP; j < i; j--) { // 책 다시 정리
                    books[j - 1] = books[j];
                }
                
                TOP--;
                break;
            }
        }
    }

    @Override
    public Book[] getList() {
        return Arrays.copyOfRange(books, 0, TOP);
    }

    @Override
    public Book searchByIsbn(String isbn) {
        Book book = null;
        for(int i = 0; i < TOP; i++) {
            book = books[i];
            
            if(book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        
        return null;
    }

    @Override
    public Book[] searchByTitle(String title) {
        List<Book> totalList = new ArrayList<>();
        
        for(int i = 0; i < TOP; i++) {
            Book book = books[i];
            
            if(book.getTitle().contains(title)) {
                totalList.add(book);
            }
        }
        return totalList.toArray(Book[]::new);
    }

    @Override
    public Magazine[] getMagazines() {
        List<Magazine> currentMagazineList = new ArrayList<>();
        
        for(int i = 0; i < TOP; i++) {
            if(books[i] instanceof Magazine) {
                currentMagazineList.add((Magazine)books[i]);
            }
        }
        
        return currentMagazineList.toArray(Magazine[]::new);
    }

    @Override
    public Book[] getBooks() {
        List<Book> currentBookList = new ArrayList<>();
        
        for(int i = 0; i < TOP; i++) {
            if((books[i] instanceof Magazine)) {
                currentBookList.add(books[i]);
            }
        }
        
        return currentBookList.toArray(Book[]::new);
    }

    @Override
    public int getTotalPrice() {
        int totalPrice = 0;
        for(int i = 0; i < TOP; i++) {
            totalPrice += books[i].getPrice();
        }
        return totalPrice;
    }

    @Override
    public double getPriceAvg() {

        return (double)getTotalPrice() / TOP;
    }

    @Override // 판매
    public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
        Book currentBook = searchByIsbn(isbn);
        
        int currentQuantity  = currentBook.getQuantity();
        if(currentQuantity < quantity) { 
            System.out.println("수량이 부족합니다.");
            return;
        }
        
        currentBook.setQuantity(currentQuantity - quantity);
    }

    @Override // 구매
    public void buy(String isbn, int quantity) throws ISBNNotFoundException {
        Book currentBook = searchByIsbn(isbn);
        int currentQuantity  = currentBook.getQuantity();
        
        currentBook.setQuantity(currentQuantity + quantity);
    }
}
