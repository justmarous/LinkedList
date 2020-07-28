import org.w3c.dom.ls.LSOutput;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlaylistSongs {

    public static ArrayList<Album> albums = new ArrayList<Album>();
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Playlist> playlists = new ArrayList<Playlist>();
    public static void main(String[] args)
    {
        initSetup();
        control();
    }

    public static void initSetup()
    {
        Song song1 = new Song(302,"Openair");
        Song song2 = new Song(313,"Amazing rich");
        Song song3 = new Song(331, "Poorly doubious");
        Song song4 = new Song(240, "I touch no more");
        Song song5 = new Song(203, "End here");

        Song song6 = new Song(900,"Amazement");
        Song song7 = new Song(839,"Doubts");

        LinkedList<Song> album1Songs = new LinkedList<Song>();
        album1Songs.add(song1);
        album1Songs.add(song2);
        album1Songs.add(song3);
        album1Songs.add(song4);
        album1Songs.add(song5);

        LinkedList<Song> album2Songs = new LinkedList<Song>();
        album2Songs.add(song6);
        album2Songs.add(song7);

        Album album1 = new Album(album1Songs,"Rediscovered attention");
        Album album2 = new Album(album2Songs,"Attention");

        albums.add(album1);
        albums.add(album2);

        LinkedList<Song> playlista1 = new LinkedList<>();
        playlista1.add(song1);
        playlista1.add(song2);
        playlista1.add(song3);
        playlista1.add(song4);
        playlista1.add(song5);
        playlista1.add(song6);
        playlista1.add(song7);

        Playlist playAll = new Playlist("PlayAll",playlista1);

        LinkedList<Song> myFav = new LinkedList<>();
        myFav.add(song2);
        myFav.add(song3);
        myFav.add(song6);
        myFav.add(song7);

        Playlist myFavorite = new Playlist("My Fav",myFav);

        playlists.add(playAll);
        playlists.add(myFavorite);

    }


    public static void control()
    {

        System.out.println("Do you want to play the album or playlist? \n\t0 -> album\n\t1 -> playlist");
        int played = scanner.nextInt();

        switch (played)
        {
            case 0:
                playAlbum();
                break;
            case 1:
                playPlaylist();
                break;
        }
    }

    public static void playPlaylist()
    {
        System.out.println("Choose the playlist you wish to play:");

        for(int i = 0;i<playlists.size();i++)
        {
            System.out.println(i+" -> "+playlists.get(i).getName());
        }

        int choice = scanner.nextInt();

        System.out.println("You have picked album: "+playlists.get(choice).getName()+"\n");

        listen(playlists.get(choice).getPlayLista());
    }

    public static void playAlbum()
    {
        System.out.println("Choose the album you wish to play:");

        for(int i = 0;i<albums.size();i++)
        {
            System.out.println(i+" -> "+albums.get(i).getName());
        }

        int choice = scanner.nextInt();

        System.out.println("You have picked album: "+albums.get(choice).getName()+"\n");

        listen(albums.get(choice).getSongsOnAlbum());

    }

    public static void printInstructionPlayer()
    {
        System.out.println("What do you do?");

        System.out.println("0 -> print instruction again");
        System.out.println("1 -> play next");
        System.out.println("2 -> play previous");
        System.out.println("3 -> quit player");
    }

    public static void listen(LinkedList<Song> songList)
    {
        printInstructionPlayer();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Song> listIterator = songList.listIterator();

        System.out.println("Now listening to: "+listIterator.next().getTitle());

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Turning the music off");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward)
                    {
                        if(listIterator.hasNext())
                            listIterator.next();
                        goingForward = true;
                    }
                    if(listIterator.hasNext())
                        System.out.println("Now listening to: "+listIterator.next().getTitle());
                    else {
                        System.out.println("Reached the end of the playlist.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward)
                    {
                        if(listIterator.hasPrevious()) listIterator.previous();
                        goingForward=false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now listening to: "+listIterator.previous().getTitle());
                    }
                    else {
                        System.out.println("We are on the beginning of the playlist!");
                        listIterator.next();
                        goingForward = true;
                    }
                    break;
                case 3:
                    printInstructionPlayer();
                    break;
                case 4:
                    System.out.println("Removing song");
                    listIterator.remove();
            }
        }
    }

}
