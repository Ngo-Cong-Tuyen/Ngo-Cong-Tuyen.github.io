# Truy vấn database.

### Lấy ra thông tin tất cả các quyển sách thuộc thể loại comedy hoặc drama
```sql
SELECT b.id, b.title  , c.name 
FROM book b 
INNER JOIN book_category bc ON bc.id_book = b.id
INNER JOIN category c ON bc.id_category = c.id 
WHERE c.name LIKE  'comedy'
OR c.name LIKE 'drama'  
```

![Logo TechMaster](https://techmaster.vn/resources/image/logo.png)









