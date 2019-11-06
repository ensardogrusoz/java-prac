/*This program will contain 3 movies in a theater with 3 auditoriums that is hard coded.
The program will generate the revenue of a theater selling tickets for $15 and running these movies from 10am - 11pm,
by determining the capacity of each theater, fullness, and length of movie. */

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class TheaterGenerator {

	public static void main(String[] args) {
		Theater theater = new Theater();
		theater.schedule();
		theater.sellTickets();
	}

}

class Movie {	
	String MovieTitle;
	int duration;
	double popularity;
	
	public Movie(String t, int d, double p) {
		MovieTitle = t;
		duration = d;
		popularity = p;
	}
	
	public int getDuration() {
		return duration;
	}

	public double getPopularity() {
		return popularity;
	}
	
	public String toString() {
		String s = MovieTitle + "(" + duration + " minutes)";
		return s;
	}
}

class Auditorium {
	int id;
	int capacity;
	
	public Auditorium(int i, int cap) {
		id = i;
		capacity = cap;
	}
	
	public int getId() {
		return id;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public String toString() {
		String s = "Auditorium " + id;
		return s;
	}
}

class Showing {
	Movie movie;
	Auditorium auditorium;
	LocalTime showtime;
	
	public Showing(Movie m, Auditorium a, LocalTime s) {
		movie = m;
		auditorium = a;
		showtime = s;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public LocalTime getShowtime() {
		return showtime;
	}
	public String toString() {
		return movie + " in Auditorium" + auditorium.id + " at " + showtime; 
	}
}

class Theater {
	static Random random = new Random();
	static int timeBetweenShowings = 15;
	
	LocalTime firstShowtime;
	LocalTime lastShowtime;
	double ticketPrice;
	
	ArrayList<Movie> movies;
	ArrayList<Auditorium> auditoriums;
	ArrayList<Showing> showings;
	
	public Theater() {
		firstShowtime = LocalTime.of(10, 00);
		lastShowtime = LocalTime.of(23, 00);
		
		ticketPrice = 15.00;
		
		movies = new ArrayList <Movie>();
		Movie movie1 = new Movie("Joker",120,10);
		Movie movie2 = new Movie("Avatar",110,7);
		Movie movie3 = new Movie("Avengers",90,8);
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		auditoriums = new ArrayList <Auditorium>();
		Auditorium auditorium1 = new Auditorium(1,80);
		Auditorium auditorium2 = new Auditorium(2,120);
		Auditorium auditorium3 = new Auditorium(3,100);
		auditoriums.add(auditorium1);
		auditoriums.add(auditorium2);
		auditoriums.add(auditorium3);
		showings = new ArrayList <Showing>();	
	}
	
	public Movie randomMovie() {
		return movies.get(this.random.nextInt(3));
	}
	
	public void schedule() {
		LocalTime currentTime = firstShowtime;
		showings.clear();
		
		for(int i=0; i < auditoriums.size(); i++) {
			while(currentTime.isBefore(lastShowtime)) {
				Movie getRandomMovie = this.randomMovie();
				Auditorium getAuditorium = auditoriums.get(i);
				showings.add(new Showing(getRandomMovie, getAuditorium, currentTime));
				
				currentTime = currentTime.plus(Duration.ofMinutes(getRandomMovie.getDuration() + 15));
				if(currentTime.isBefore(firstShowtime)) {
					break;
				}
			}
			currentTime = firstShowtime;
			
			
			}
		}
		public void sellTickets() {
			double Totalrev = 0;
			for(int i=0;i<showings.size();i++) {
				double popToPercent = (showings.get(i).getMovie().getPopularity()) / 10;
				double NumofTicketsSold = (showings.get(i).getAuditorium().getCapacity()) * popToPercent;
				double revenue = NumofTicketsSold * ticketPrice;
				System.out.println("showing object: " + showings.get(i));
				System.out.println("  num of tickets sold: " + NumofTicketsSold + " revenue: $" + revenue);

				
				Totalrev += revenue;
			}
			System.out.println("Total revenue of the day: $" + Totalrev);
		}	
}

