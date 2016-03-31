package gdg.activitytransitionsexample;

import android.support.annotation.DrawableRes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {

    public int resImageCover;
    public int resImageBanner;
    public String name;
    public String description;
    public String subtitle;

    public Movie(@DrawableRes int resImageCover, @DrawableRes int resImageBanner, String name, String description, String subtitle) {
        this.resImageCover = resImageCover;
        this.resImageBanner = resImageBanner;
        this.name = name;
        this.description = description;
        this.subtitle = subtitle;
    }


    public static List<Movie> createMovies() {
        List<Movie> movies = new ArrayList<>();

        Movie movieBatmanVSuperman = new Movie(R.drawable.batmanvssuperman_cover, R.drawable.batmanvssuperman_banner, "Batman v Superman: Dawn of Justice", "Behind the black cowl, Gotham City superhero Batman is really millionaire philanthropist Bruce Wayne (Michael Keaton), who turned to crimefighting after his parents were brutally murdered before his eyes. The only person to share Wayne's secret is faithful butler Alfred (Michael Gough). The principal villain in Batman is The Joker (Jack Nicholson) who'd been mob torpedo Jack Napier before he was horribly disfigured in a vat of acid. The Joker's plan to destroy Batman and gain control of Gotham", "March 2016");
        Movie hatefulEight = new Movie(R.drawable.hateful_cover, R.drawable.hateful_banner, "The Hateful Eight", "In post-Civil War Wyoming, bounty hunters try to find shelter during a blizzard but get involved in a plot of betrayal and deception. Will they survive?", "December 2015 168 minutes");
        Movie revenant = new Movie(R.drawable.revenant_cover, R.drawable.revenant_banner, "The Revenant", "Leonardo DiCaprio stars in this critically acclaimed epic adventure inspired by true events from writer-director Alejandro G. Iñárritu. While on a hunting expedition in the American wilderness, Hugh Glass (DiCaprio) is attacked by a bear and left for dead. Despite unimaginable grief and betrayal by his confidant (Tom Hardy), Glass must navigate a vicious winter in a relentless pursuit to live.", "December 2015 156 minutes");
        Movie room = new Movie(R.drawable.room_cover, R.drawable.room_banner, "Room", "After five-year-old Jack and his mother escape from the enclosed surroundings that Jack has known his entire life, the boy makes a thrilling discovery.", "October 2015 117 minutes");
        Movie startrek = new Movie(R.drawable.startrek_cover, R.drawable.startrek_banner, "Star Trek Into Darkness", "When a ruthless mastermind, Khan (Benedict Cumberbatch,) declares a one-man war on the Federation, Captain Kirk (Chris Pine), Spock (Zachary Quinto), and the crew of the U.S.S. Enterprise set out on their most explosive manhunt of all time.", "May 2013 132 minutes");
        Movie starwars = new Movie(R.drawable.starwars_cover, R.drawable.starwars_banner, "Star Wars: The Force Awakens", "Visionary director J.J. Abrams brings to life the motion picture event of a generation. As Kylo Ren and the sinister First Order rise from the ashes of the Empire, Luke Skywalker is missing when the galaxy needs him most. It's up to Rey, a desert scavenger, and Finn, a defecting stormtrooper, to join forces with Han Solo and Chewbacca in a desperate search for the one hope of restoring peace to the galaxy", "December 2015 138 minutes");


        movies.add(movieBatmanVSuperman);
        movies.add(hatefulEight);
        movies.add(revenant);
        movies.add(room);
        movies.add(startrek);
        movies.add(starwars);

        return movies;

    }
}
