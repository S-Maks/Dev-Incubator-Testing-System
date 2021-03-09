INSERT INTO Topic (topicId, description, name)
VALUES (4, 'Тесты по математике','Математика');

INSERT INTO Test(testId, name, description, topicId)
VALUES (4, 'Натуральные числа', 'Вариант 1', 4),
       (5, 'Натуральные числа', 'Вариант 2', 4);

INSERT INTO Question(questionId, description, testId)
VALUES (4, 'Какое число следует при счете за числом 40099?', 4),
       (5, 'Какое число предшествует числу 103 000?', 4),
       (6, 'Как называется высший разряд в записи шестизначного числа?', 4),
       (7, 'Какое число следует при счете за числом 300 909?', 5),
       (8, 'Какое число предшествует числу 15 900?', 5),
       (9, 'Как называется высший разряд в записи пятизначного числа?', 5);

INSERT INTO Answer(description, correct, questionId)
VALUES ('50 000', false, 4),
       ('40 100 +++', true, 4),
       ('41 100', false, 4),
       ('41 000', false, 4),

       ('103 001', false, 5),
       ('102 990', false, 5),
       ('102 009', false, 5),
       ('102 999 +++', true, 5),

       ('Единицы тысяч', false, 6),
       ('Единицы миллионов', false, 6),
       ('Сотни тысяч ++++', true, 6),
       ('Десятки тысяч', false, 6),

       ('301 000', false, 7),
       ('300 100', false, 7),
       ('300 910 +++', true, 7),
       ('301 910', false, 7),

       ('15 901', false, 8),
       ('15 899 +++', true, 8),
       ('15 800', false, 8),
       ('14 899', false, 8),

       ('Десятки тысяч +++', true, 9),
       ('Единицы тысяч', false, 9),
       ('Единицы миллионов', false, 9),
       ('Сотни тысяч', false, 9);

INSERT INTO literature(literatureId, description, questionId)
VALUES (4, '4 Натураьные числа', 4),
       (5, '5 Число Е', 5),
       (6, '6 Таблица простых чисел', 6),
       (7, '7 Признаки делимости на 2', 7),
       (8, '8 Признаки делимости на 3', 8),
       (9, '9 Признаки делимости на 4', 9),

       (10, '4 Сложение в столбик', 4),
       (11, '5 Признаки делимости на 6', 5),
       (12, '6 Признаки делимости на 9', 6),
       (13, '7 Виды дробей', 7),
       (14, '8 Согкращение дроби', 8),
       (15, '9 Умножение дробей', 9);

INSERT INTO link(link, literatureId)
VALUES ('https://ru.onlinemschool.com/math/library/numbers/integers/', 4),
       ('https://ru.onlinemschool.com/math/library/numbers/e/', 5),
       ('https://ru.onlinemschool.com/math/library/numbers/prime-number/', 6),
       ('https://ru.onlinemschool.com/math/library/divisibility_rule/#h1', 7),
       ('https://ru.onlinemschool.com/math/library/divisibility_rule/#h2', 8),
       ('https://ru.onlinemschool.com/math/library/divisibility_rule/#h3', 9),

       ('https://ru.onlinemschool.com/math/library/numbers/column-addition/', 10),
       ('https://ru.onlinemschool.com/math/library/divisibility_rule/#h5', 11),
       ('https://ru.onlinemschool.com/math/library/divisibility_rule/#h6', 12),
       ('https://ru.onlinemschool.com/math/library/fraction/fractions_forms/', 13),
       ('https://ru.onlinemschool.com/math/library/fraction/simplify/', 14),
       ('https://ru.onlinemschool.com/math/library/fraction/multiplication/', 15);




