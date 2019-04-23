package finalprojectgroup2test2;

import dto.Vehicle;
import java.util.ArrayList;

public interface InventorySearcher {
	ArrayList<Vehicle> searchInventory(ArrayList<Vehicle> inventory, FilterContent filterContent);
}

// use InventorySearcher.search_inventory(...) to get search result: return type: ArrayList<Vehicle>
// put default value as null or "" if filters not be filled.