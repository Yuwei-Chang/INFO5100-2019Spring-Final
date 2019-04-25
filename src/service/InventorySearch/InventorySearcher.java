package service.InventorySearch;



import UI.FilterContent;
import dto.Vehicle;
import java.util.ArrayList;
import java.util.List;

public interface InventorySearcher {
	ArrayList<Vehicle> searchInventory(List<Vehicle> inventory, FilterContent filterContent);
}

// use InventorySearcher.search_inventory(...) to get search result: return type: ArrayList<Vehicle>
// put default value as null or "" if filters not be filled.