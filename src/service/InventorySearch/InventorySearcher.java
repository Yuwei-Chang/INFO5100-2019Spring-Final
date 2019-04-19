package InventorySearcher;

import dto.Vehicle;
import java.util.ArrayList;

public interface InventorySearcher {
	ArrayList<Vehicle> search_inventory(ArrayList<Vehicle> inventory,
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
													  String seat_count);
}

// use InventorySearcher.search_inventory(...) to get search result: return type: ArrayList<Vehicle>
// put default value as null or "" if filters not be filled.