import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates the Observer design pattern, where collections
 * are used to manage a list of observers.
 */

// The Observer interface
interface Observer {
    void update(String news);
}

// The Subject (or Observable) class
class NewsAgency { // This is the "Subject"
    private final List<Observer> observers = new ArrayList<>();
    private String news;

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void setNews(String news) {
        this.news = news;
        System.out.println("\nNews Agency received new update: '" + news + "'. Notifying channels...");
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this.news);
        }
    }
}

// Concrete Observer classes
class NewsChannel implements Observer {
    private final String channelName;

    public NewsChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void update(String news) {
        System.out.println("[" + this.channelName + "] Breaking News: " + news);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        // Create the subject (the news agency)
        NewsAgency agency = new NewsAgency();

        // Create observers (the news channels)
        Observer channel1 = new NewsChannel("TV9");
        Observer channel2 = new NewsChannel("NTV");
        Observer channel3 = new NewsChannel("ABN");

        // Register the observers with the subject
        // Mana NewsAgency lo, observers list (ArrayList) lo ee channels ni add chestunnam.
        agency.addObserver(channel1);
        agency.addObserver(channel2);
        agency.addObserver(channel3);

        // Now, when the news agency gets an update, it automatically notifies all registered channels.
        agency.setNews("Massive discounts on Java courses!");

        // Let's remove one observer
        System.out.println("\nNTV unsubscribed.");
        agency.removeObserver(channel2);

        // Set new news again, and see who gets notified
        agency.setNews("New Java version released!");
    }
}
