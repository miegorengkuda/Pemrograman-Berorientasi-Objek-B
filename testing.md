Dokumentasi Tugas atau Project mata kuliah Pemrograman Berorientasi Objek (B)

Dafa Kumara Sahasika (5025241112)

## Testing dan Debugging
Testing adalah salah satu aktivitas yang harus dilakukan sebagai bagian dari tahap pembangunan perangkat lunak. 
Tujuannya adalah untuk mencari sebanyak-banyaknya kesalahan, error maupun defect. 
Testing dilakukan dengan mengacu pada test plan dan test cases.

Debugging adalah aktivitas yang dilakukan untuk mencari posisi kesalahan dan memperbaikinya apabila dari hasil testing diperoleh indikasi adanya error atau defect.

<img width="709" height="639" alt="Screenshot 2025-11-04 002216" src="https://github.com/user-attachments/assets/8da7c0a3-4172-440d-a118-4c7fc61af53a" />


- Buat objek SalesItem di object bench, misalnya: SalesItem item1 = new SalesItem('Baso', 20000);
- Tambahkan komentar: salesite1.addComment('budi', 'enak', 5);
- Tampilkan info: salesIte1.showInfo();
- Uji batas rating (1–5) dan larangan komentar ganda dari author yang sama.

Ini adalah hasil testingnya di `SalesItemTest`

<img width="1168" height="338" alt="image" src="https://github.com/user-attachments/assets/0c2c5065-05b3-4d5d-b194-abc7f3a5cbf3" />


<img width="1002" height="643" alt="Screenshot 2025-11-04 002204" src="https://github.com/user-attachments/assets/23ace8d8-a30f-499b-bfb5-768765322a31" />


`SalesItem.java`
```java
import java.util.ArrayList;

public class SalesItem
{
    private String name;
    private int price;
    private ArrayList<Comment> comments;
    public SalesItem(String name, int price)
    {
        this.name = name;
        this.price = price;
        comments = new ArrayList<Comment>();
    }
    public boolean addComment(String author, String text, int rating)
    {
        if(rating < 1 || rating > 5) {
            return false;
        }
        for(Comment comment : comments) {
            if(comment.getAuthor().equals(author)) {
                return false;
            }
        }
        Comment newComment = new Comment(author, text, rating);
        comments.add(newComment);
        return true;
    }
    public boolean removeComment(Comment comment)
    {
        return comments.remove(comment);
    }
    public int getNumberOfComments()
    {
        return comments.size();
    }
    public void showInfo()
    {
        System.out.println("=================================");
        System.out.println("Item: " + name);
        System.out.println("Price: " + price);
        System.out.println("Number of comments: " + getNumberOfComments());
        for(Comment comment : comments) {
            comment.print();
            System.out.println();
        }
    }
    public Comment findMostHelpfulComment()
    {
        if(comments.isEmpty()) {
            return null;
        }
        Comment best = comments.get(0);
        for(Comment current : comments) {
            if(current.getVoteBalance() > best.getVoteBalance()) {
                best = current;
            }
        }
        return best;
    }
}
```

`Comment.java`
```java
public class Comment
{
    private String author;
    private String text;
    private int rating;
    private int upvotes;
    private int downvotes;
    public Comment(String author, String text, int rating)
    {
        this.author = author;
        this.text = text;
        this.rating = rating;
        upvotes = 0;
        downvotes = 0;
    }
    public String getAuthor()
    {
        return author;
    }
    public void upvote()
    {
        upvotes++;
    }
    public void downvote()
    {
        downvotes++;
    }
    public int getVoteBalance()
    {
        return upvotes - downvotes;
    }
    public void print()
    {
        System.out.println("Author: " + author);
        System.out.println("Rating: " + rating);
        System.out.println("Comment: " + text);
        System.out.println("Votes: " + getVoteBalance());
    }
}
```
