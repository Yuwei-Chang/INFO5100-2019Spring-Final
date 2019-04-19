package searchDealerLogic;

public interface SortLogic{
  public enum SortType implements SortLogic {
    PRICE_ASC, PRICE_DSC, YEAR_ASC, YEAR_DSC, MILEAGE_ASC, MILEAGE_DSC
  }
}
