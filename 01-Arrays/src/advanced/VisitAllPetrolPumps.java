package advanced;

public class VisitAllPetrolPumps {

	public static void main(String[] args) {
		PetrolPump[] arr = new PetrolPump[3];
		arr[0] = new PetrolPump(6, 4);
		arr[1] = new PetrolPump(3, 6);
		arr[2] = new PetrolPump(7, 3);
		System.out.println(printTour(arr, 3));
	}

	// The function returns starting point otherwise returns -1
	public static int printTour(PetrolPump[] arr, int n) {
		// Consider first petrol pump as a starting point
		int start = 0;
		int end = 1;

		int currPetrol = arr[start].petrol - arr[start].distance;

		while (end != start || currPetrol < 0) {
			// If curremt amount of petrol in truck becomes less than 0, then
			// remove the starting petrol pump from tour
			while (currPetrol < 0 && start != end) {
				// Remove starting petrol pump. Change start
				currPetrol -= arr[start].petrol - arr[start].distance;
				start = (start + 1) % n;

				// If 0 is being considered as start again, then there is no
				// possible solution
				if (start == 0)
					return -1;
			}

			// Add a petrol pump to current tour
			currPetrol += arr[end].petrol - arr[end].distance;

			end = (end + 1) % n;
		}

		// Return starting point
		return start;
	}

	static class PetrolPump {
		int petrol;
		int distance;

		public PetrolPump(int petrol, int distance) {
			super();
			this.petrol = petrol;
			this.distance = distance;
		}

	}

}
