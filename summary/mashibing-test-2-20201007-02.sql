INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`, `s_score`, `s_score`) VALUES ('02', '钱电', '1990-12-21', '男', 70, 60);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`, `s_score`, `s_score`) VALUES ('04', '李云', '1990-08-06', '男', 50, 30);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`, `s_score`, `s_score`) VALUES ('01', '赵雷', '1990-01-01', '男', 80, 90);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`, `s_score`, `s_score`) VALUES ('05', '周梅', '1991-12-01', '女', 76, 87);
INSERT INTO `mashibing-test-2`(`s_id`, `c_id`, `s_score`) VALUES ('02', '01', 70);
INSERT INTO `mashibing-test-2`(`s_id`, `c_id`, `s_score`) VALUES ('04', '01', 50);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('01', '赵雷', 89.67);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('02', '钱电', 70.00);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('03', '孙风', 80.00);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('05', '周梅', 81.50);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('07', '郑竹', 93.50);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('01', '赵雷', 89.67);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('02', '钱电', 70.00);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('03', '孙风', 80.00);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('05', '周梅', 81.50);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('07', '郑竹', 93.50);
INSERT INTO `mashibing-test-2`(`s_name`, `s_id`, ``) VALUES ('李云', '04', 33);
INSERT INTO `mashibing-test-2`(`s_name`, `s_id`, ``) VALUES ('吴兰', '06', 33);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `avg_score`) VALUES ('04', '李云', 33.33);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `avg_score`) VALUES ('06', '吴兰', 32.50);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `avg_score`) VALUES ('08', '王菊', 0.00);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('01', '赵雷', 269, 3);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('02', '钱电', 210, 3);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('03', '孙风', 240, 3);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('04', '李云', 100, 3);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('05', '周梅', 163, 2);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('06', '吴兰', 65, 2);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('07', '郑竹', 187, 2);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('08', '王菊', NULL, 0);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('01', '赵雷', 3, 269);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('02', '钱电', 3, 210);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('03', '孙风', 3, 240);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('04', '李云', 3, 100);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('05', '周梅', 2, 163);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('06', '吴兰', 2, 65);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('07', '郑竹', 2, 187);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``, ``) VALUES ('08', '王菊', 0, NULL);
INSERT INTO `mashibing-test-2`(``) VALUES (1);
INSERT INTO `mashibing-test-2`(``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``) VALUES (1, 'SIMPLE', 't1', NULL, 'ALL', 'PRIMARY', NULL, NULL, NULL, 3, 33.33, 'Using where');
INSERT INTO `mashibing-test-2`(``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``) VALUES (1, 'SIMPLE', 'c1', NULL, 'eq_ref', 'PRIMARY', 'PRIMARY', '62', 'db_test.t1.t_id', 1, 100.00, 'Using index');
INSERT INTO `mashibing-test-2`(``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``) VALUES (1, 'SIMPLE', 's1', NULL, 'index', 'PRIMARY', 'PRIMARY', '124', NULL, 18, 10.00, 'Using where; Using index; Using join buffer (hash join)');
INSERT INTO `mashibing-test-2`(``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``) VALUES (1, 'SIMPLE', 'stu', NULL, 'eq_ref', 'PRIMARY', 'PRIMARY', '62', 'db_test.s1.s_id', 1, 100.00, NULL);
INSERT INTO `mashibing-test-2`(``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``) VALUES (1, 'PRIMARY', 'course', NULL, 'ALL', 'PRIMARY', NULL, NULL, NULL, 3, 33.33, 'Using where');
INSERT INTO `mashibing-test-2`(``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``) VALUES (1, 'PRIMARY', 'b', NULL, 'index', 'PRIMARY', 'PRIMARY', '124', NULL, 18, 10.00, 'Using where; Using index; Using join buffer (hash join)');
INSERT INTO `mashibing-test-2`(``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``) VALUES (1, 'PRIMARY', 'a', NULL, 'eq_ref', 'PRIMARY', 'PRIMARY', '62', 'db_test.b.s_id', 1, 100.00, NULL);
INSERT INTO `mashibing-test-2`(``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``, ``) VALUES (3, 'SUBQUERY', 'teacher', NULL, 'ALL', NULL, NULL, NULL, NULL, 3, 33.33, 'Using where');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('06', '吴兰', '1992-03-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('08', '王菊', '1990-01-20', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('01', '赵雷', '1990-01-01', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('02', '钱电', '1990-12-21', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('03', '孙风', '1990-05-20', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('04', '李云', '1990-08-06', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('05', '周梅', '1991-12-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('06', '吴兰', '1992-03-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('05', '周梅', '1991-12-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('06', '吴兰', '1992-03-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('07', '郑竹', '1989-07-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('01', '赵雷', '1990-01-01', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('02', '钱电', '1990-12-21', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('03', '孙风', '1990-05-20', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('04', '李云', '1990-08-06', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('05', '周梅', '1991-12-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('06', '吴兰', '1992-03-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('07', '郑竹', '1989-07-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('01', '赵雷', '1990-01-01', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('02', '钱电', '1990-12-21', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('03', '孙风', '1990-05-20', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('04', '李云', '1990-08-06', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('05', '周梅', '1991-12-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('06', '吴兰', '1992-03-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('07', '郑竹', '1989-07-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('02', '钱电', '1990-12-21', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('03', '孙风', '1990-05-20', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('04', '李云', '1990-08-06', '男');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('06', '吴兰', '1992-03-01', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`) VALUES ('08', '王菊', '1990-01-20', '女');
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`, ``) VALUES ('04', '李云', '1990-08-06', '男', 33.3333);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, `s_birth`, `s_sex`, ``) VALUES ('06', '吴兰', '1992-03-01', '女', 32.5000);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('04', '李云', 33);
INSERT INTO `mashibing-test-2`(`s_id`, `s_name`, ``) VALUES ('06', '吴兰', 33);
