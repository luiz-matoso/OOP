package entities;

import java.util.List;

public class Admin extends User{

    private List<Song> musics;

    public Admin(String name, List<Song> musics) {
        super(name);
        this.musics = musics;
    }

    public void addMusicToSpotify(Song song){
        musics.add(song);
        System.out.println("Music add sucessfully!" + song.getName());
    }

    public List<Song> getMusics(){
        return musics;
    }
}
