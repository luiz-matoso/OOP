import entities.Admin;
import entities.Song;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner sc;
    private Admin admin;
    private User user;

    public Main() {
        sc = new Scanner(System.in);
        List<Song> musicList = new ArrayList<>();
        admin = new Admin("Admin", musicList);
        user = new User("Luiz");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.showMainMenu();
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("=== Main Menu ===");
            System.out.println("1. Admin login");
            System.out.println("2. User login");
            System.out.println("0. Leave");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    showAdminMenu();
                    break;
                case 2:
                    showUserMenu();
                    break;
                case 0:
                    System.out.println("Leaving...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private void showAdminMenu() {
        while (true) {
            System.out.println("\n=== Admin menu ===");
            System.out.println("1. Add song");
            System.out.println("2. Back to main menu");

            int option = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addMusic();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private void addMusic() {
        System.out.println("Enter music name:");
        String title = sc.nextLine();

        System.out.println("Enter singer name:");
        String artist = sc.nextLine();

        Song song = new Song(title, artist);
        admin.addMusicToSpotify(song);
    }

    private void showUserMenu() {
        while (true) {
            System.out.println("\n=== User menu ===");
            System.out.println("1. Listen music");
            System.out.println("2. Back to main menu");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    listenToMusic();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private void listenToMusic() {
        System.out.println("Choose a song:");

        List<Song> musics = admin.getMusics();
        for (int i = 0; i < musics.size(); i++) {
            Song song = musics.get(i);
            System.out.println((i + 1) + ". " + song.getName() + " by " + song.getSinger());
        }

        int index = sc.nextInt() - 1;
        sc.nextLine();  // Consume newline

        if (index >= 0 && index < musics.size()) {
            Song selectedSong = musics.get(index);
            user.listenMusic(selectedSong);
            selectedSong.play();
        } else {
            System.out.println("Song not found.");
        }
    }
}
