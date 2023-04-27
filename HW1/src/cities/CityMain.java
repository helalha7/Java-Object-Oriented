package cities;

public class CityMain {

	public static void main(String[] args) {
		City karmiel = new City("Karmiel");
		City metula = new City("Metula");
		City telAviv = new City("Tel-Aviv");
		City jerusalem = new City("Jerusalem");

		new Road(karmiel, metula, 50);
		new Road(karmiel, telAviv, 100);
		new Road(telAviv, jerusalem, 80);
		new Road(jerusalem, metula, 175);

		System.out.println(karmiel.nearestCity());

	}

}
