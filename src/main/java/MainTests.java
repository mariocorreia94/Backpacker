import backpacker.project.utils.GoogleMapsAPI;

public class MainTests {

    public static void main(String[] args) {

        String origin = "faro";
        String destiny = "lisboa";
        GoogleMapsAPI googleMapsAPI = new GoogleMapsAPI(origin,destiny);

        System.out.println("Distancia: " + googleMapsAPI.calculateDistance() + " km");

    }

}
