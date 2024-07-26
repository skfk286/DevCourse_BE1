package day_0726.ws;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookManagerImpl implements IBookManager {
    private static final String FILE_NAME = "book.dat";

    private Map<String, Book> books = new HashMap<>();
    private static IBookManager instance = new BookManagerImpl();

    private BookManagerImpl() { // 외부에서 객체 생성을 하지 못하도록 접근 제어자를  private으로 만든 생성자
        loadData();
    }

    public static IBookManager getInstance() {
        return instance;
    }

    @Override
    public void add(Book book) {
        books.put(book.getIsbn(), book);    // 리스트 마지막에 추가
    }

    @Override
    public void remove(String isbn) {
        books.remove(isbn);
    }

    @Override
    public Book[] getList() {
        return books.values().toArray(new Book[books.size()]);            // 컬렉션 내용을 배열로 복사 후 배열 리턴
    }

    @Override
    public Book searchByIsbn(String isbn) {
        return books.get(isbn);
    }

    @Override
    public Book[] searchByTitle(String title) {
        // 제목을 포함하는 도서의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
        ArrayList<Book> temp = new ArrayList<Book>();
        for (Book book : books.values()) {
            if (book.getTitle().contains(title))
                temp.add(book);
        }
        return temp.toArray(new Book[temp.size()]);            // 컬랙션의 내용을 배열로 복사 후 리턴
    }

    @Override
    public Magazine[] getMagazines() {
        // 잡지의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
        ArrayList<Magazine> temp = new ArrayList<Magazine>();
        for (Book book : books.values()) {
            if (book instanceof Magazine)
                temp.add((Magazine) book);
        }
        return temp.toArray(new Magazine[temp.size()]);// 컬랙션의 내용을 배열로 복사 후 리턴
    }

    @Override
    public Book[] getBooks() {
        // 일반 도서의 개수를 알 수 없으므로 컬렉션을 활용하여 저장 후 마지막에 배열로 바꾸어 반환한다.
        ArrayList<Book> temp = new ArrayList<Book>();
        for (Book book : books.values()) {
            if (!(book instanceof Magazine))
                temp.add(book);
        }
        return temp.toArray(new Book[temp.size()]);            // 컬랙션의 내용을 배열로 복사 후 리턴
    }

    @Override
    public int getTotalPrice() {
        int total = 0;
        for (Book book : books.values()) {
            total += book.getPrice();
        }
        return total;
    }

    @Override
    public double getPriceAvg() {
        return (double) getTotalPrice() / books.size();
    }

    @Override
    public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
        Book book = searchByIsbn(isbn);                // 고유번호 도서 조회
        if (book == null) throw new ISBNNotFoundException(isbn); // 고유번호 도서 조회 실패시 ISBNNotFoundException 사용자 정의 예외 발생시킴

        int res = book.getQuantity() - quantity;    // 판매 후 새로운 재고 수량 계산
        if (res < 0) throw new QuantityException();    // 재고수량 부족시 QuantityException 사용자 정의 예외 발생시킴

        book.setQuantity(res);                        // 판매후 남은 재고수량으로 재고 수량 변경
    }

    @Override
    public void buy(String isbn, int quantity) throws ISBNNotFoundException {
        Book book = searchByIsbn(isbn);                        // 고유번호 도서 조회
        if (book == null) throw new ISBNNotFoundException(isbn); // 고유번호 도서 조회 실패시 ISBNNotFoundException 사용자 정의 예외 발생시킴

        book.setQuantity(book.getQuantity() + quantity);    // 구매 후의 새로운 재고 수량 계산하여 재고 수량 변경
    }

    /**
     * File OutPutStream 을 이용하여 book 저장
     *
     * @throws IOException
     */
    @Override
    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream(FILE_NAME)))) {
            oos.writeObject(books);
            System.out.println("성공적으로 도서를 저장했습니다.(book.dat)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * File InputStream 을 이용하여 book 을 읽어온다.
     */
    @Override
    public void loadData() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return; // 내부에 파일을 타고 들어가서 파일을 찾아낸다.

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (Map<String, Book>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}