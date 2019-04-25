//
//package searchDealerLogic;
//
//import dto.Inventory;
//import dto.Vehicle;
//import searchDealerLogic.SortLogic;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class Sort{
//    public Inventory SortBySelection(SortLogic.SortType sortType, Inventory inventory){
//        ArrayList<Vehicle> vehicles = inventory.getVehicles();
//        Inventory output = new Inventory();
//
//        switch (sortType){
//            case YEAR_ASC:
//                Collections.sort(vehicles,new SortByYearAsc());break;
//            case YEAR_DSC:
//                Collections.sort(vehicles,new SortByYearDes());break;
//            case PRICE_ASC:
//                Collections.sort(vehicles,new SortByPriceAsc());break;
//            case PRICE_DSC:
//                Collections.sort(vehicles,new SortByPriceDes());break;
//            case MILEAGE_ASC:
//                Collections.sort(vehicles,new SortByMileageAsc());break;
//            case MILEAGE_DSC:
//                Collections.sort(vehicles,new SortByMileageAsc());break;
//        }
//        output.setVehicles(vehicles);
//        return output;
//    }
//
//    //Sort by Year Ascending
//    class SortByYearAsc implements Comparator<Vehicle> {
//        @Override
//        public int compare(Vehicle v1, Vehicle v2) {
//            int i = Integer.valueOf(v1.getYear()).compareTo(Integer.valueOf(v2.getYear()));
//            if (i > 0){
//                return 1;
//            }
//            else if (i < 0){
//                return -1;
//            }
//            else
//                return 0;
//        }
//    }
//    //Sort by Year Descending
//    class SortByYearDes implements Comparator<Vehicle> {
//        @Override
//        public int compare(Vehicle v1, Vehicle v2) {
//            int i = Integer.valueOf(v1.getYear()).compareTo(Integer.valueOf(v2.getYear()));
//            if (i < 0){
//                return 1;
//            }
//            else if (i > 0){
//                return -1;
//            }
//            else
//                return 0;
//        }
//    }
//    //Sort by Price Ascending
//    class SortByPriceAsc implements Comparator<Vehicle> {
//        @Override
//        public int compare(Vehicle v1, Vehicle v2) {
//            int i = Double.valueOf(v1.getPrice()).compareTo(Double.valueOf(v2.getDiscountprice()));
//            if (i > 0){
//                return 1;
//            }
//            else if (i < 0){
//                return -1;
//            }
//            else
//                return 0;
//        }
//    }
//    //Sort by Price Descending
//    class SortByPriceDes implements Comparator<Vehicle> {
//        @Override
//        public int compare(Vehicle v1, Vehicle v2) {
//            int i = Double.valueOf(v1.getPrice()).compareTo(Double.valueOf(v2.getDiscountprice()));
//            if (i < 0){
//                return 1;
//            }
//            else if (i > 0){
//                return -1;
//            }
//            else
//                return 0;
//        }
//    }
//    //Sort by Mileage Ascending
//    class SortByMileageAsc implements Comparator<Vehicle> {
//        @Override
//        public int compare(Vehicle v1, Vehicle v2) {
//            int i = Integer.valueOf(v1.getMileage()).compareTo(Integer.valueOf(v2.getMileage()));
//            if (i > 0){
//                return 1;
//            }
//            else if (i < 0){
//                return -1;
//            }
//            else
//                return 0;
//        }
//    }
//    //Sort by Miledge Descending
//    class SortByMileageDes implements Comparator<Vehicle> {
//        @Override
//        public int compare(Vehicle v1, Vehicle v2) {
//            int i = Integer.valueOf(v1.getMileage()).compareTo(Integer.valueOf(v2.getMileage()));
//            if (i < 0){
//                return 1;
//            }
//            else if (i > 0){
//                return -1;
//            }
//            else
//                return 0;
//        }
//    }
//
//
//}
//
