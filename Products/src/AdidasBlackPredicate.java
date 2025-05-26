public class AdidasBlackPredicate implements ProductPredicate {
    @Override
    public boolean test(Product p) {
        return p.getBrand().equalsIgnoreCase("Adidas") &&
               p.getColor().equalsIgnoreCase("Черный");
    }
}
