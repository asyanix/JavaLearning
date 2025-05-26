public class NikeWhitePredicate implements ProductPredicate {
    @Override
    public boolean test(Product p) {
        return p.getBrand().equalsIgnoreCase("Nike") &&
               p.getColor().equalsIgnoreCase("Белый");
    }
}
