CREATE DATABASE  IF NOT EXISTS `tlias` ;
USE `tlias`;


create table dept
(
    id          int unsigned primary key auto_increment comment '主キーID',
    name        varchar(10) not null unique comment '部門名',
    create_time datetime    not null comment '作成時間',
    update_time datetime    not null comment '更新時間'
) comment '部門リスト';

insert into dept (id, name, create_time, update_time)
values (1, '教務部', now(), now()),
       (2, '研究部', now(), now()),
       (3, '指導部', now(), now()),
       (4, '渉外部', now(), now()),
       (5, '管理部', now(), now());

create table emp
(
    id          int unsigned primary key auto_increment comment 'ID',
    username    varchar(32)      not null unique comment 'ユーザーネーム',
    password    varchar(32) default '123456' comment 'パスワード',
    name        varchar(10)      not null comment '名前',
    gender      tinyint unsigned not null comment '性别, 説明: 1 男, 2 女',
    image       varchar(300) comment 'アイコン',
    job         tinyint unsigned comment '職位, 说明: 1 担任,2 講師, 3 教務主任, 4 主幹教諭, 5 渉外',
    entrydate   date comment '入職時間',
    dept_id     int unsigned comment '部門ID',
    create_time datetime         not null comment '作成時間',
    update_time datetime         not null comment '更新時間'
) comment '教諭リスト';

INSERT INTO emp
(id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time)
VALUES (1, 'arai-kazutaka', '123456', '新井一太夏', 1, '001.jpg', 4, '2002-05-15', 2, now(), now()),
       (2, 'fukushima-saku', '123456', '福島然久', 2, '002.jpg', 2, '2005-08-23', 3, now(), now()),
       (3, 'naito-ben', '123456', '内藤勉', 1, '003.jpg', 1, '2008-10-10', 1, now(), now()),
       (4, 'baba-riki', '123456', '馬場鯉希', 2, '004.jpg', 1, '2010-12-01', 5, now(), now()),
       (5, 'matsui-shin', '123456', '松井晋', 1, '005.jpg', 3, '2004-04-20', 2, now(), now()),
       (6, 'shiba-yutaka', '123456', '清波悠', 1, '006.jpg', 2, '2007-07-07', 4, now(), now()),
       (7, 'nakahara-hayashi', '123456', '中原駿', 1, '007.jpg', 5, '2012-01-15', 3, now(), now()),
       (8, 'yayamori-ryou', '123456', '良盛菱', 1, '008.jpg', 2, '2014-03-25', 2, now(), now()),
       (9, 'aita-rinryu', '123456', '會田麟竜', 1, '009.jpg', 1, '2019-06-10', 5, now(), now()),
       (10, 'oonakado-tsuna', '123456', '大名門紘', 2, '010.jpg', 4, '2001-11-18', 4, now(), now()),
       (11, 'tomo-oomega', '123456', '伴太芽', 2, '011.jpg', 3, '2013-02-28', 1, now(), now()),
       (12, 'haeiwa-nachi', '123456', '榮岩梛千', 2, '012.jpg', 5, '2009-04-02', 3, now(), now()),
       (13, 'mutou-yasuhiro', '123456', '武藤康弘', 1, '013.jpg', 2, '2011-07-14', 2, now(), now()),
       (14, 'nakayoku-shou', '123456', '中能章', 1, '014.jpg', 2, '2003-10-05', 1, now(), now()),
       (15, 'kanou-norinao', '123456', '官能範尚', 1, '015.jpg', 1, '2006-12-30', 4, now(), now()),
       (16, 'asano-ken', '123456', '浅野健', 1, '016.jpg', 3, '2008-02-14', 5, now(), now()),
       (17, 'doudo-atsuyasu', '123456', '堂土渥恭', 1, '017.jpg', 4, '2015-05-28', 4, now(), now()),
       (18, 'kamiya-shigetaka', '123456', '神谷昌高', 1, '018.jpg', 4, '2000-08-18', 2, now(), now()),
       (19, 'magashiki-soushi', '123456', '間ヶ敷壮至', 2, '019.jpg', 3, '2007-09-20', 1, now(), now()),
       (20, 'yutaka-yutaka', '123456', '豊緑', 1, '020.jpg', 5, '2012-11-12', 3, now(), now()),
       (21, 'mi-teiru', '123456', '美悌瑠', 1, '021.jpg', 2, '2016-04-03', 2, now(), now()),
       (22, 'gou-yuuki', '123456', '郷悠貴', 1, '022.jpg', 2, '2010-09-21', 4, now(), now()),
       (23, 'yotakaki-uchi-sukekiyo', '123456', '夜鷹木内扶浄', 2, '023.jpg', 3, '2019-01-05', 1, now(), now()),
       (24, 'tenman-ya-shiki-yukinaga', '123456', '天満屋敷之祥', 1, '024.jpg', 4, '2004-12-18', 5, now(), now()),
       (25, 'ryo-seiryou', '123456', '寮世諒', 2, '025.jpg', 3, '2013-06-30', 3, now(), now()),
       (26, 'sakano-satoru', '123456', '坂ノ坊悟', 1, '026.jpg', 4, '2009-08-10', 2, now(), now()),
       (27, 'oohori-yoshiyuki', '123456', '大堀佳之', 1, '027.jpg', 1, '2006-03-25', 4, now(), now()),
       (28, 'ueda-masaya', '123456', '上枝将矢', 2, '028.jpg', 1, '2012-04-15', 1, now(), now()),
       (29, 'nakajima-rensei', '123456', '中島連殺', 2, '029.jpg', 5, '2017-09-07', 3, now(), now()),
       (30, 'inoshira-reito', '123456', '井城羚人', 1, '030.jpg', 2, '2018-11-23', 2, now(), now()),
       (31, 'yoshiura-toshinori', '123456', '義浦肇基', 1, '031.jpg', 2, '2010-01-30', 1, now(), now()),
       (32, 'niizumi-minato', '123456', '新泉湊', 1, '032.jpg', 3, '2005-07-12', 4, now(), now()),
       (33, 'inoue-tadashige', '123456', '井上忠重', 1, '033.jpg', 4, '2006-09-08', 5, now(), now()),
       (34, 'sakurai-masatoshi', '123456', '桜井将寿', 1, '034.jpg', 5, '2011-12-02', 2, now(), now()),
       (35, 'terauji-ryuusou', '123456', '寺内隆惣', 1, '035.jpg', 1, '2014-05-16', 3, now(), now()),
       (36, 'moriyoshi-kazuhiko', '123456', '森好和彦', 1, '036.jpg', 3, '2019-08-29', 1, now(), now()),
       (37, 'kita-akabane-gesshin', '123456', '北赤羽月心', 1, '037.jpg', 3, '2017-10-05', 4, now(), now()),
       (38, 'adachi-tooru', '123456', '足立徹', 1, '038.jpg', 2, '2008-03-12', 2, now(), now()),
       (39, 'ookubo-haruto', '123456', '大久保陽斗', 2, '039.jpg', 4, '2015-06-18', 5, now(), now()),
       (40, 'sakou-gou', '123456', '佐甲剛', 2, '040.jpg', 1, '2012-09-20', 1, now(), now()),
       (41, 'ikou-kenji', '123456', '胃甲健司', 1, '041.jpg', 2, '2007-02-28', 3, now(), now()),
       (42, 'maruyama-souta', '123456', '丸山颯太', 1, '042.jpg', 5, '2010-11-15', 2, now(), now()),
       (43, 'kago-akira', '123456', '篭亮', 1, '043.jpg', 3, '2013-04-10', 1, now(), now()),
       (44, 'sadatou-kojou', '123456', '貞任己有紹', 1, '044.jpg', 3, '2018-07-22', 4, now(), now()),
       (45, 'kawano-ooki', '123456', '河野オオキ', 1, '045.jpg', 1, '2001-10-09', 5, now(), now()),
       (46, 'sakimoto-sukeyoshi', '123456', '崎本佑美', 2, '046.jpg', 4, '2006-11-30', 2, now(), now()),
       (47, 'manza-takuhiro', '123456', '万座琢浩', 2, '047.jpg', 1, '2014-02-18', 3, now(), now()),
       (48, 'rai-tsuyoshi', '123456', '莱健', 1, '048.jpg', 2, '2019-05-05', 1, now(), now()),
       (49, 'koike-haruka', '123456', '小池悠', 1, '049.jpg', 5, '2008-08-21', 4, now(), now()),
       (50, 'eboshida-tsuguha', '123456', '烏帽子田緒葉', 2, '050.jpg', 3, '2011-03-14', 2, now(), now()),
       (51, 'nakano-shouya-shurinosuke', '123456', '中之庄谷修理亮', 1, '051.jpg', 1, '2015-09-10', 3, now(), now()),
       (52, 'iri-seiyuu', '123456', '入正祐', 1, '052.jpg', 4, '2018-12-05', 2, now(), now()),
       (53, 'hirohata-haruto', '123456', '弘畑陽大', 2, '053.jpg', 1, '2013-06-30', 1, now(), now()),
       (54, 'ochi-mikiha', '123456', '尾知樹陽', 2, '054.jpg', 2, '2007-09-14', 4, now(), now()),
       (55, 'kuniyori-hiromitsu', '123456', '國寄展実', 1, '055.jpg', 4, '2011-11-28', 5, now(), now()),
       (56, 'koike-shigeru', '123456', '小池董', 1, '056.jpg', 5, '2005-04-10', 2, now(), now()),
       (57, 'nishimura-tokisame', '123456', '西村途紀鮫', 1, '057.jpg', 3, '2002-07-15', 1, now(), now()),
       (58, 'shibata-torajirou', '123456', '柴田虎治郎', 1, '058.jpg', 2, '2008-01-28', 3, now(), now()),
       (59, 'fuchihata-haruo', '123456', '淵端遥生', 2, '059.jpg', 3, '2014-04-22', 2, now(), now()),
       (60, 'teraura-tatsuki', '123456', '寺浦樹', 1, '060.jpg', 2, '2016-09-18', 4, now(), now()),
       (61, 'kaisawa-akimitsu', '123456', '貝沢昭三', 1, '061.jpg', 4, '2003-12-10', 5, now(), now()),
       (62, 'fuyu-kishin', '123456', '冬輝鎮', 1, '062.jpg', 1, '2006-02-05', 2, now(), now()),
       (63, 'gou-goushin', '123456', '呉剛進', 1, '063.jpg', 2, '2009-11-20', 3, now(), now()),
       (64, 'nakatsuma-nijiaki', '123456', '仲妻ニジアキ', 1, '064.jpg', 3, '2017-04-14', 1, now(), now()),
       (65, 'ookouchi-tomokazu', '123456', '大河内友和', 1, '065.jpg', 4, '2018-08-30', 5, now(), now()),
       (66, 'miura-kyoushi', '123456', '三浦恭至', 1, '066.jpg', 2, '2004-01-12', 2, now(), now()),
       (67, 'ogura-arikage', '123456', '小倉在景', 1, '067.jpg', 1, '2007-03-25', 4, now(), now()),
       (68, 'takeda-yori', '123456', '竹田賴', 1, '068.jpg', 5, '2011-05-18', 1, now(), now()),
       (69, 'sawada-mitsutaka', '123456', '沢田盈太茄', 1, '069.jpg', 3, '2016-10-10', 3, now(), now()),
       (70, 'matsuoka-yuuma', '123456', '松岡湧麻', 1, '070.jpg', 2, '2002-12-28', 2, now(), now()),
       (71, 'shigaki-ryoushin', '123456', '志垣梁芯', 1, '071.jpg', 4, '2005-09-15', 5, now(), now()),
       (72, 'masuno-tera', '123456', '益野寺', 1, '072.jpg', 4, '2010-02-01', 1, now(), now()),
       (73, 'shidatsu-kirinobu', '123456', '志達霧申', 1, '073.jpg', 3, '2015-07-18', 4, now(), now()),
       (74, 'satsukari-souma', '123456', '札苅創萬', 1, '074.jpg', 2, '2018-10-02', 2, now(), now()),
       (75, 'takekoshi-eisuke', '123456', '竹腰映祐', 1, '075.jpg', 2, '2013-01-15', 3, now(), now()),
       (76, 'hasegawa-akika', '123456', '長谷川晄化', 1, '076.jpg', 1, '2016-04-20', 1, now(), now()),
       (77, 'kuritani-minetomo', '123456', '繰谷厳朝', 1, '077.jpg', 5, '2019-07-07', 5, now(), now()),
       (78, 'amaki-hisayoshi', '123456', '天木陽佐良', 1, '078.jpg', 1, '2014-09-28', 2, now(), now()),
       (79, 'hirokami-kiharu', '123456', '広神季明', 1, '079.jpg', 4, '2011-03-18', 4, now(), now()),
       (80, 'hoyou-takuki', '123456', '保要高記', 2, '080.jpg', 3, '2016-06-22', 3, now(), now()),
       (81, 'kouge-tetsu', '123456', '剛家徹', 1, '081.jpg', 1, '2010-11-05', 2, now(), now()),
       (82, 'tateda-naoki', '123456', '立田直樹', 2, '082.jpg', 4, '2013-02-10', 5, now(), now()),
       (83, 'kakeyama-keita', '123456', '掛山景泰', 2, '083.jpg', 3, '2018-05-28', 1, now(), now()),
       (84, 'yoshikawa-takuya', '123456', '吉川拓哉', 1, '084.jpg', 2, '2004-08-15', 4, now(), now()),
       (85, 'amishiro-kaito', '123456', '網代海翔', 1, '085.jpg', 2, '2009-10-18', 2, now(), now()),
       (86, 'izumitani-tadashi', '123456', '泉渓忠', 1, '086.jpg', 3, '2015-01-05', 1, now(), now()),
       (87, 'ike-shigetake', '123456', '池重武', 1, '087.jpg', 3, '2012-02-21', 3, now(), now()),
       (88, 'kurioka-fumiyoshi', '123456', '栗岡フミヨシ', 1, '088.jpg', 5, '2017-05-14', 5, now(), now()),
       (89, 'tomiki-haruki', '123456', '冨木悠希', 2, '089.jpg', 4, '2011-08-30', 2, now(), now()),
       (90, 'kodato-raia', '123456', '古田土来空', 1, '090.jpg', 4, '2018-11-02', 4, now(), now()),
       (91, 'jinyong', '123456', '金庸', 1, '091.jpg', 2, '2013-02-28', 1, now(), now()),
       (92, 'mimou-kouhi', '123456', '水毛生倖檜', 1, '092.jpg', 2, '2016-04-10', 3, now(), now());
