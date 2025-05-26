import java.util.*;
import java.util.function.Predicate;

public class ProductUtils {

    // Фильтрация с помощью предиката-интерфейса
    public static List<Product> filterProducts(List<Product> products, ProductPredicate predicate) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (predicate.test(p)) {
                result.add(p);
            }
        }
        return result;
    }

    // Фильтрация по лямбда-функции
    public static List<Product> filterProductsLambda(List<Product> products, Predicate<Product> predicate) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (predicate.test(product)) {
                result.add(product);
            }
        }
        return result;
    }    

    // Группировка по типу
    public static Map<String, List<Product>> groupByType(List<Product> products) {
        Map<String, List<Product>> grouped = new HashMap<>();
        for (Product product : products) {
            String type = product.getType();
            if (!grouped.containsKey(type)) { // Если такой тип ещё не встречался, создаём новый список
                grouped.put(type, new ArrayList<>());
            }
            grouped.get(type).add(product); // Добавляем товар в соответствующую группу
        }
        return grouped;
    }
    
    // Сортировка по цене и размеру
    public static void sortByPriceAndSize(List<Product> products) {
        Collections.sort(products, (Product p1, Product p2) -> {
            int priceCompare = Double.compare(p1.getPrice(), p2.getPrice());
            if (priceCompare != 0) {
                return priceCompare;
            }
            String size1 = p1.getSize() != null ? p1.getSize() : "";
            String size2 = p2.getSize() != null ? p2.getSize() : "";
            return size1.compareTo(size2);
        });
    }    

    // Самый дешевый и самый дорогой товар в каждом типе
    public static Map<String, Product> findCheapestInEachType(List<Product> products) {
        Map<String, List<Product>> grouped = groupByType(products); 
        Map<String, Product> result = new HashMap<>();
    
        for (Map.Entry<String, List<Product>> entry : grouped.entrySet()) {
            String type = entry.getKey();
            List<Product> productList = entry.getValue();
    
            if (productList.isEmpty()) {
                result.put(type, null);
                continue;
            }
    
            Product cheapest = productList.get(0);
            for (Product p : productList) {
                if (p.getPrice() < cheapest.getPrice()) {
                    cheapest = p;
                }
            }
            result.put(type, cheapest);
        }
        return result;
    }
    

    public static Map<String, Product> findMostExpensiveInEachType(List<Product> products) {
        Map<String, List<Product>> grouped = groupByType(products);
        Map<String, Product> result = new HashMap<>();
    
        for (Map.Entry<String, List<Product>> entry : grouped.entrySet()) {
            String type = entry.getKey();
            List<Product> productList = entry.getValue();
    
            if (productList.isEmpty()) {
                result.put(type, null);
                continue;
            }
    
            Product mostExpensive = productList.get(0);
            for (Product p : productList) {
                if (p.getPrice() > mostExpensive.getPrice()) {
                    mostExpensive = p;
                }
            }
            result.put(type, mostExpensive);
        }
        return result;
    }
    
}
