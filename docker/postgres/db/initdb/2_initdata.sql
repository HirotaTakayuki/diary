
INSERT INTO diary (id, category,title,content,date,update_datetime) VALUES
( '1','1','仕事がんばった','仕事を頑張りました。',now(),now()),
( '2','2','旅行','旅行にいきました。',now(),now())
;
INSERT INTO category_code (id, group_cd,cd,name) VALUES
( '1','01','1','仕事'),
( '2','01','2','趣味'),
( '3','01','3','その他')
;