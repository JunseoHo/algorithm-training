-- 코드를 입력하세요
SELECT book_id, author_name, TO_CHAR(published_date,'YYYY-MM-DD') FROM book NATURAL JOIN author WHERE category = '경제' ORDER BY published_date ASC;