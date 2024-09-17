package entities;

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public void listenMusic(Song song){
        System.out.println(name + " is listening to " + song.getName() + " by " + song.getSinger());
    }
}
