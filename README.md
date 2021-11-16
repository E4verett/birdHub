# birdHub
软件工程鸟类识别
要记录一整天中网站访问量和图片上传量

在数据库中插入或更新记录需要实现：有则插入，无则修改（更新当天某栏的数量）

实现方式（需要设置唯一索引）：

```mysql
INSERT INTO visit (`time`,`count`) VALUES ('2021-11-16', 2) ON DUPLICATE KEY UPDATE count = count + 1;
```
