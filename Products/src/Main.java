import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Мяч", "Nike", null, "Белый", 1029.99),
            new Product("Мяч", "FIFA", null, "Оранжевый", 4029.99),
            new Product("Кроссовки", "Adidas", "42", "Черный", 3999.99),
            new Product("Кроссовки", "Nike", "43", "Белый", 2109.99),
            new Product("Одежда", "Puma", "M", "Красный", 5399.99),
            new Product("Одежда", "Adidas", "M", "Черный", 2999.99),
            new Product("Ракетка", "Wilson", null, "Черный", 7999.99),
            new Product("Ракетка", "UFO", null, "Желтый", 2099.99),
            new Product("Аксессуар", "Nike", null, "Белый", 199.99),
            new Product("Аксессуар", "Puma", null, "Красный", 99.99),
            new Product("Одежда", "Nike", "L", "Белый", 4999.99)
        );

        // Группировка по типу и сортировка внутри группы
        Map<String, List<Product>> grouped = ProductUtils.groupByType(products);
        for (Map.Entry<String, List<Product>> entry : grouped.entrySet()) {
            System.out.println("\nТип: " + entry.getKey());
            List<Product> list = entry.getValue();
            ProductUtils.sortByPriceAndSize(list);
            list.forEach(System.out::println);
        }

        // Фильтрация по интерфейсу-предикату
        List<Product> nikeWhite = ProductUtils.filterProducts(products, new NikeWhitePredicate());
        System.out.println("\nNike + Белый (через класс-предикат):");
        nikeWhite.forEach(System.out::println);

        List<Product> adidasBlack = ProductUtils.filterProducts(products, new AdidasBlackPredicate());
        System.out.println("\n\nAdidas + Черный (через класс-предикат):");
        adidasBlack.forEach(System.out::println);

        // Фильтрация по лямбде
        List<Product> pumaRed = ProductUtils.filterProductsLambda(products,
            p -> p.getBrand().equalsIgnoreCase("Puma") && p.getColor().equalsIgnoreCase("Красный"));
        System.out.println("\nPuma + Красный (через лямбда-функцию):");
        pumaRed.forEach(System.out::println);

        System.out.println("\nСамый дешевый товар по типу:");
        ProductUtils.findCheapestInEachType(products).forEach((type, product) ->
            System.out.println(type + ": " + product));

        System.out.println("\nСамый дорогой товар по типу:");
        ProductUtils.findMostExpensiveInEachType(products).forEach((type, product) ->
            System.out.println(type + ": " + product));
    }
}

