import java.util.LinkedList;

public class Album {

    private LinkedList<Song> songsOnAlbum;
    private String name;

    public LinkedList<Song> getSongsOnAlbum() {
        return songsOnAlbum;
    }

    public String getName() {
        return name;
    }

    public Album(LinkedList<Song> songsOnAlbum, String name) {
        this.songsOnAlbum = songsOnAlbum;
        this.name = name;
    }

    public void printSongs()
    {
        System.out.println(this.name);
        for(int j=0;j<songsOnAlbum.size();j++)
            {
                System.out.println(j+" "+songsOnAlbum.get(j).getTitle()+" - "+songsOnAlbum.get(j).getDuration());
            }
    }
}
