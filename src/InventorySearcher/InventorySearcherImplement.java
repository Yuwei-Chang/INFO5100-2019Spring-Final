package InventorySearcher;

import java.util.ArrayList;
import dto.Vehicle;

public class InventorySearcherImplement implements InventorySearcher{

	public  ArrayList<Vehicle> search_inventory(ArrayList<Vehicle> inventory,
													  String _new,
													  String _used,
													  String min_year,
													  String max_year,
													  String max_mileage,
													  String min_price,
													  String max_price,
													  String model,
													  String make,
													  String type,
													  String seat_count) {

		ArrayList<Vehicle> inventory_result = new ArrayList<>();

		for (int i = 0; i < inventory.size(); i++) {
			if (this.fit_category(inventory.get(i), _new, _used)
					&& this.fit_year(inventory.get(i), min_year, max_year)
					&& this.fit_mileage(inventory.get(i), max_mileage)
					&& this.fit_price(inventory.get(i), min_price, max_price)
					&& this.fit_model(inventory.get(i), model)
					&& this.fit_make(inventory.get(i), make)
					&& this.fit_type(inventory.get(i), type)
					&& this.fit_seat_count(inventory.get(i), seat_count)) {

				inventory_result.add(inventory.get(i));
			}
		}
		return inventory_result;
	}

	public boolean fit_category(Vehicle vehicle, String _new, String _used){
		boolean is_new = (_new.equals("new"));
		boolean is_used = (_used.equals("used"));
		if !(is_new ^ is_used) return true;
		return ((vehicle.getCategory().equals("new") && is_new) || (vehicle.getCategory().equals("used") && is_used))
	}

	public boolean fit_year(Vehicle vehicle, String min_year, String max_year) {
		int year = Integer.parseInt(vehicle.getYear());
		if ((min_year == null || min_year.length() == 0) && (max_year == null || max_year.length() == 0)) return true;
		if (min_year == null || min_year.length() == 0) return year <= Integer.parseInt(max_year);
		if (max_year == null || max_year.length() == 0) return year >= Integer.parseInt(min_year);
		return (year <= Integer.parseInt(max_year) && year >= Integer.parseInt(min_year));
	}

	public boolean fit_mileage(Vehicle vehicle, String max_mileage) {
		int mileage = Integer.parseInt(vehicle.getMilaege());
		if (max_mileage == null|| max_mileage.length() == 0) return true;
		return (Integer.parseInt(max_mileage) >= mileage);
	}

	public boolean fit_price(Vehicle vehicle, String min_price, String max_price) {
		int price = Integer.parseInt(vehicle.getPrice());
		if ((min_price == null || min_price.length() == 0) && (max_price == null || max_price.length() == 0)) return true;
		if (min_price == null || min_price.length() == 0) return price <= Integer.parseInt(max_price);
		if (max_price == null || max_price.length() == 0) return price >= Integer.parseInt(min_price);
		return (price <= Integer.parseInt(max_price) && price >= Integer.parseInt(min_price));
	}

	public boolean fit_model(Vehicle vehicle, String model) {
		String v_model = vehicle.getModel();
		if (model == null || model.length() == 0) return true;
		return model.equals(v_model);
	}

	public boolean fit_make(Vehicle vehicle, String make) {
		String v_make = vehicle.getMake();
		if (make == null || make.length() == 0) return true;
		return make.equals(v_make);
	}

	public boolean fit_type(Vehicle vehicle, String type) {
		String v_type = vehicle.getType();
		if (type == null || type.length() == 0) return true;
		return type.equals(v_type);
	}

	public boolean fit_seat_count(Vehicle vehicle, String seat_count) {
		String v_seat = vehicle.getSeatCount();
		if (seat_count == null || seat_count.length() == 0) return true;
		return seat_count.equals(v_seat);
	}

//	for testing;
	public static void main(String[] arg) {

	System.out.println(123);

	}

}