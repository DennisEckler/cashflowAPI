package dev.eckler.cashflow.transaktion;

import org.springframework.data.repository.CrudRepository;

public interface TransaktionRepository extends CrudRepository<Transaktion, Long> {

//  List<Transaktion> findAllByCategory(Category category);

//  List<Transaktion> findAllByCategoryNot(Category category);

//  @Query("select count(t) from Transaktion t WHERE YEAR(t.date) = :year AND MONTH(t.date) = :month")
//  int getNumberOfYearMonthMatches(String year, String month);
//
//  @Query("SELECT YEAR(t.date) AS year, MONTH(t.date) AS month, t.category AS category, SUM(t.amount) AS amount FROM Transaktion AS t GROUP By year, month, category ORDER By year, month, category")
//  List<OverviewEntry> getOverview();

}