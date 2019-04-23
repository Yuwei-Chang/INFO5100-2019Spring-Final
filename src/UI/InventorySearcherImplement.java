package finalprojectgroup2test2;

import java.util.ArrayList;
import dto.Vehicle;

public class InventorySearcherImplement implements InventorySearcher{
	// input attributes undecided; 1: ArrayList<Vehicle> 2: Inventory object; depends on io team;
	// Arraylist vehicle for now.

	public boolean fitCategory(Vehicle vehicle, boolean needNew, boolean needUsed){
		boolean isNew = needNew;
		boolean isUsed = needUsed;
		if (isNew && isUsed) {
			return true;
		}
		else {
			return ((vehicle.getCategory().equals("new") && isNew) || (vehicle.getCategory().equals("used") && isUsed));
		}
	}

	public boolean fitYear(Vehicle vehicle, int minYear, int maxYear) {
		int year = Integer.parseInt(vehicle.getYear());
		if ((minYear == 0) && (maxYear == 3000 )) return true;
		if (minYear == 0) return year <= maxYear;
		if (maxYear == 3000) return year >= minYear;
		return (year <= maxYear) && (year >= minYear);
	}

	public boolean fitMileage(Vehicle vehicle, double maxMileage) {
		double mileage = Integer.parseInt(vehicle.getMileage().replace("$","").replace(",",""));
		if (maxMileage == 0) return true;
		return maxMileage >= mileage;
	}

	public boolean fitPrice(Vehicle vehicle, String minPrice, String maxPrice) {
		int price = Integer.parseInt(vehicle.getPrice().replace("$","").replace(",",""));
		if ((minPrice == null || minPrice.length() == 0) && (maxPrice == null || maxPrice.length() == 0)) return true;
		if (minPrice == null || minPrice.length() == 0) return price <= Integer.parseInt(maxPrice);
		if (maxPrice == null || maxPrice.length() == 0) return price >= Integer.parseInt(minPrice);
		return (price <= Integer.parseInt(maxPrice) && price >= Integer.parseInt(minPrice));
	}

	public boolean fitModel(Vehicle vehicle, String model) {
		String vehicleModel = vehicle.getModel();
		if (model == null || model.length() == 0) return true;
		return model.equals(vehicleModel);
	}

	public boolean fitMake(Vehicle vehicle, String make) {
		String vehicleMake = vehicle.getMake();
		if (make == null || make.length() == 0) return true;
		return make.equals(vehicleMake);
	}

	public boolean fitType(Vehicle vehicle, String type) {
		String vehicleType = vehicle.getType();
		if (type == null || type.length() == 0) return true;
		return type.equals(vehicleType);
	}

	public boolean fitSeatCount(Vehicle vehicle, String seatCount) {
		String vehicleSeatCount = vehicle.getSeatCount();
		if (seatCount == null || seatCount.length() == 0) return true;
		return seatCount.equals(vehicleSeatCount);
	}

//	for testing;
	public static void main(String[] arg) {

	System.out.println(123);

	}

	@Override
	public ArrayList<Vehicle> searchInventory(ArrayList<Vehicle> inventory, FilterContent filterContent) {
		ArrayList<Vehicle> inventoryResult = new ArrayList<>();

		for (int i = 0; i < inventory.size(); i++) {
			if (this.fitCategory(inventory.get(i), filterContent.needsNew, filterContent.needsUsed)
					&& this.fitYear(inventory.get(i), filterContent.getLowYear(), filterContent.getHighYear())
					&& this.fitMileage(inventory.get(i), filterContent.getMileage())
					&& this.fitPrice(inventory.get(i), filterContent.getLowPrice(), filterContent.getHighPrice())
					&& this.fitModel(inventory.get(i), filterContent.getModel())
					&& this.fitMake(inventory.get(i), filterContent.getMake())
					&& this.fitType(inventory.get(i), filterContent.getType())
					&& this.fitSeatCount(inventory.get(i), filterContent.getSeatCount())) {

				inventoryResult.add(inventory.get(i));
			}
		}
		return inventoryResult;
	}
}