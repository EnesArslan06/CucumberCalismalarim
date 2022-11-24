package pojos;

public class JsonplaceholderPojos {
    /*https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
    Request body{
                 "userId": 21,
                "id": 201,
                "title": "Tidy your room",
                "completed": false
    }*/
    public JsonplaceholderPojos(){

    }


    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getCompleted() {
        return completed;
    }

    public JsonplaceholderPojos(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonplaceholderPojos{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
