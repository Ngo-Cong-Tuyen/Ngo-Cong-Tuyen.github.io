public class Film {

    private int id;
    private String title;
    private String director;
    private int length;
    private int release_year;

    public Film(int id, String title, String director, int length, int release_year) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.length = length;
        this.release_year = release_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    @Override
    public String toString() {
        return  id +" - "+ title+" - " + director +" - "+ length +" - "+ release_year;
    }
}
