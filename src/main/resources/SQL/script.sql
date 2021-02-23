/*drop table answer,link,literature,question,role,statistic,test,topic,user;*/

CREATE TABLE `Role`
(
    roleId INTEGER PRIMARY KEY AUTO_INCREMENT,
    role   varchar(50) NOT NULL
);

CREATE TABLE `User`
(
    userId    INTEGER PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50)  NOT NULL,
    lastName  VARCHAR(50)  NOT NULL,
    login     VARCHAR(50)  NOT NULL,
    password  VARCHAR(255) NOT NULL,
    roleId    INTEGER      NOT NULL,
    FOREIGN KEY (roleId) references Role (roleId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Topic`
(
    topicId     INTEGER PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL
);

CREATE TABLE `Test`
(
    testId      INTEGER PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    topicId     INTEGER      NOT NULL,
    FOREIGN KEY (topicId) references Topic (topicId) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE `Question`
(
    questionId  INTEGER PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255) NOT NULL,
    testId      INTEGER      NOT NULL,
    FOREIGN KEY (testId) references Test (testId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Statistic`
(
    statisticId INTEGER PRIMARY KEY AUTO_INCREMENT,
    date        DATE    NOT NULL,
    correct     BOOLEAN NOT NULL,
    questionId  INTEGER NOT NULL,
    userId      INTEGER NOT NULL,
    FOREIGN KEY (userId) references User (userId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (questionId) references Question (questionId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Answer`
(
    answerId    INTEGER PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(255) NOT NULL,
    correct     BOOLEAN      NOT NULL,
    questionId  INTEGER      NOT NULL,
    FOREIGN KEY (questionId) references Question (questionId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Literature`
(
    literatureId INTEGER PRIMARY KEY AUTO_INCREMENT,
    description  VARCHAR(255) NOT NULL,
    questionId   INTEGER      NOT NULL,
    FOREIGN KEY (questionId) references Question (questionId) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE `Link`
(
    linkId       INTEGER PRIMARY KEY AUTO_INCREMENT,
    link         VARCHAR(255) NOT NULL,
    literatureId INTEGER      NOT NULL,
    FOREIGN KEY (literatureId) references Literature (literatureId) ON DELETE CASCADE ON UPDATE CASCADE
);
