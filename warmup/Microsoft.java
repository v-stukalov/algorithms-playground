package warmup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Microsoft {

    static class Sale {
        int id;
        String name;
        String region;
        BigDecimal salesForTheMonth;

        public Sale(int id, String name, String region, Integer salesForTheMonth) {
            this.id = id;
            this.name = name;
            this.region = region;
            this.salesForTheMonth = BigDecimal.valueOf(salesForTheMonth);
        }
    }

    public static Map<String, List<String>> distinguishedSellersPerRegion(List<Sale> sales, Map<String, BigDecimal> stats, List<Double> thresholds) {
        int i = 0;
        for (Map.Entry<String, BigDecimal> entry : stats.entrySet()) {
            entry.setValue(entry.getValue().multiply(BigDecimal.valueOf(thresholds.get(i++))));
        }

        Map<String, List<String>> map = new HashMap<>();

        for (Sale sale : sales) {
            String region = sale.region;
            BigDecimal total = stats.get(region);
            BigDecimal salesmanTotal = sale.salesForTheMonth;
            if (!map.containsKey(region)) {
                map.put(region, new ArrayList<>());
            }
            if (salesmanTotal.compareTo(total) > 0) {
                map.get(region).add(sale.name);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        List<Double> thresholds = List.of(.25, .05, .1, .25, .20, .1);

        Sale johnDallas = new Sale(1, "John", "Dallas", 2000);
        Sale megDallas = new Sale(2, "Meg", "Dallas", 330);
        Sale mattFortWorth = new Sale(1, "Matt", "FortWorth", 2000);
        Sale mattDallas = new Sale(2, "Matt", "Dallas", 2400);
        Sale johnIrving = new Sale(1, "John", "Irving", 2000);
        Sale megCoppell = new Sale(2, "Meg", "Coppell", 2400);
        List<Sale> sales = List.of(johnDallas, megDallas, mattFortWorth, mattDallas, johnIrving, megCoppell);

        Map<String, BigDecimal> stats = new HashMap<>();
        stats.put("Dallas", BigDecimal.valueOf(88000));
        stats.put("FortWorth", BigDecimal.valueOf(54000));
        stats.put("Denton", BigDecimal.valueOf(6300));
        stats.put("Lewisville", BigDecimal.valueOf(4700));
        stats.put("Coppell", BigDecimal.valueOf(2350));
        stats.put("Irving", BigDecimal.valueOf(4250));

        System.out.println(distinguishedSellersPerRegion(sales, stats, thresholds));
    }
}
