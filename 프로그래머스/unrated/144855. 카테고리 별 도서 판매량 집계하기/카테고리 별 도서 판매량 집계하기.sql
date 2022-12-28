-- 코드를 입력하세요
SELECT category, SUM(sales) AS TOTAL_SALES FROM book NATURAL JOIN book_sales WHERE sales_date BETWEEN '2022-01-01' AND '2022-01-31' GROUP BY category ORDER BY category;