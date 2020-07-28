public class Song {

    private int duration; //in seconds
    private String title;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Song(int duration, String title) {
        this.duration = duration;
        this.title = title;
    }
}
