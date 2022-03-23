public class MyGreneric <T> {
    private T x;

    public MyGreneric(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }
}
