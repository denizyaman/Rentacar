package src.business;



import src.entity.Book;
import src.core.Helper;
import src.dao.BookDao;

import java.util.ArrayList;

public class BookManager {

    private final BookDao bookDao;

    public BookManager() {
        this.bookDao = new BookDao();
    }

    public boolean save(Book book) {
        return this.bookDao.save(book);
    }

    public boolean delete(int id) {
        Book existingBook = this.getById(id);

        if (existingBook == null) {
            Helper.showMsg(id + " ID'ye sahip rezervasyon bulunamadı.");
            return false;
        }

        return this.bookDao.delete(id);
    }
    public ArrayList<Book> findAll() {
        return this.bookDao.findAll();
    }

    public Book getById(int id) {
        return this.bookDao.getById(id);
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Book> books) {
        ArrayList<Object[]> bookList = new ArrayList<>();

        for (Book obj : books) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getCar().getPlate();
            rowObject[i++] = obj.getCar().getModel().getBrand().getName();
            rowObject[i++] = obj.getCar().getModel().getName();
            rowObject[i++] = obj.getName();
            rowObject[i++] = obj.getMpno();
            rowObject[i++] = obj.getMail();
            rowObject[i++] = obj.getIdno();
            rowObject[i++] = obj.getStrt_date().toString();
            rowObject[i++] = obj.getFnsh_date().toString();
            bookList.add(rowObject);
        }

        return bookList;
    }

    public ArrayList<Book> searchForTable(int carId) {
        String select = "SELECT * FROM public.book";
        ArrayList<String> whereList = new ArrayList<>();

        if (carId != 0) {
            whereList.add("book_car_id = " + carId);
        }

        String whereStr = String.join(" AND ", whereList);
        String query = select;

        if (!whereStr.isEmpty()) {
            query += " WHERE " + whereStr;
        }

        return this.bookDao.selectByQuery(query);
    }
}