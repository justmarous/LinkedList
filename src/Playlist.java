import java.util.LinkedList;

public class Playlist {

    private String name;
    private LinkedList<Song> playLista ;

    public Playlist(String name, LinkedList<Song> playLista) {
        this.name = name;
        this.playLista = playLista;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Song> getPlayLista() {
        return playLista;
    }


}
