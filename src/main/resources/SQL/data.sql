
INSERT INTO Role(roleId, role)
VALUES (1, 'ADMIN'),
       (2, 'TUTOR'),
       (3, 'USER');

INSERT INTO User(userId, firstName, lastName, login, password, roleId)
VALUES (1, 'Admin', 'Admin', 'admin', 'admin', 1),
       (2, 'Tutor', 'Tutor', 'tutor', 'tutor', 2),
       (3, 'User', 'User', 'user', 'user', 3),
       (4, 'Qwerty', 'Qwerty', 'qwerty', 'qwerty', 3);

INSERT INTO Topic (topicId, description, name)
VALUES (1, 'People', 'People'),
       (2, 'Animal', 'Animal'),
       (3, 'Arthropods', 'Arthropods');

INSERT INTO Test(testId, name, description, topicId)
VALUES (1, 'People', 'Info about People', 1),
       (2, 'Animal', 'Info about Animal', 2),
       (3, 'Arthropods', 'Info about Arthropods', 3);

INSERT INTO Question(questionId, description, testId)
VALUES (1, 'People', 1),
       (2, 'Animal', 2),
       (3, 'Arthropods', 3);

INSERT INTO Literature(literatureId, description, questionId)
VALUES (1, 'Обществоведение', 1),
       (2, 'Человек и Мир', 2),
       (3, 'Их боялись даже чеченцы...', 3);

INSERT INTO Link(linkId, link, literatureId)
VALUES (1, 'https://megaresheba.ru/gdz/obshhestvoznanie/5-klass/bogolyubov', 1),
       (2, 'https://megaresheba.ru/chelovek_i_mir/5-klass', 2),
       (3,
        'https://pikabu.ru/story/ikh_boyalis_dazhe_chechentsyi_samaya_otmorozhennaya_opg_za_vsyu_istoriyu_sovremennoy_rossii_6143655',
        3);

INSERT INTO Answer(answerId, description, correct, questionId)
VALUES (1, 'Да', true, 1),
       (2, 'Да', true, 2),
       (3, 'Да', true, 3);

INSERT INTO Statistic(statisticId, date, correct, questionId, userId)
VALUES (1,'2021-02-07',true,1,3),
       (2,'2021-02-07',true,2,3),
       (3,'2021-02-07',true,3,3),
       (4,'2021-02-07',false,1,4),
       (5,'2021-02-07',false,2,4),
       (6,'2021-02-07',false,3,4);