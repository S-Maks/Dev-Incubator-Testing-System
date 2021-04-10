CREATE PROCEDURE `getStat` ()
    LANGUAGE SQL
    DETERMINISTIC
    SQL SECURITY DEFINER
    COMMENT 'A procedure'
BEGIN
    SELECT user.login, t.name testName, q.description questionDescription, COUNT(*) HowMuchTimes, ROUND(SUM(statistic.correct)/COUNT(*)*100,2) correctPercent
    FROM statistic
             JOIN user ON statistic.userId = user.userId
             JOIN question q on statistic.questionId = q.questionId
             JOIN test t on q.testId = t.testId
    GROUP BY statistic.questionId, user.userId;
END;

CREATE PROCEDURE `getStatByUserId` (IN userIdInt INT)
    LANGUAGE SQL
    DETERMINISTIC
    SQL SECURITY DEFINER
    COMMENT 'A procedure'
BEGIN
SELECT t.name testName, q.description questionDescription, COUNT(*) HowMuchTimes, ROUND(SUM(statistic.correct)/COUNT(*)*100,2) correctPercent
FROM statistic
         JOIN user ON statistic.userId = user.userId
         JOIN question q on statistic.questionId = q.questionId
         JOIN test t on q.testId = t.testId
WHERE user.userId=userIdInt
GROUP BY statistic.questionId, user.userId;
END;

CREATE PROCEDURE `getTestsStat` ()
    LANGUAGE SQL
    DETERMINISTIC
    SQL SECURITY DEFINER
    COMMENT 'A tests statistic procedure'
BEGIN
    SELECT test.name,
           ROUND(COUNT(statisticid) / (SELECT COUNT(*) FROM question where test.testId = question.testId)) AS count,
           ROUND(avg(correct), 2) * 100 AS avg
    FROM statistic
             JOIN question ON statistic.questionid = question.questionid
             JOIN test ON question.testid = test.testid
    GROUP BY test.name, test.testId;
END;

CREATE PROCEDURE `getQuestionsStat` ()
    LANGUAGE SQL
    DETERMINISTIC
    SQL SECURITY DEFINER
    COMMENT 'A questions statistic procedure'
BEGIN
    SELECT topic.name AS topic, test.name AS test, question.description AS question, count(statisticId) AS count, ROUND(AVG(correct), 1) * 100 as avg
    FROM statistic
             JOIN question ON statistic.questionid = question.questionid
             JOIN test ON question.testId = test.testId
             JOIN topic ON topic.topicId = test.topicId
    GROUP BY topic, test, question;
END;

CREATE PROCEDURE `getUsersStat` ()
    LANGUAGE SQL
    DETERMINISTIC
    SQL SECURITY DEFINER
    COMMENT 'A users statistic procedure'
BEGIN
    SELECT user.firstname, user.lastname, topic.name AS topicName, test.name AS testName,
           ROUND(COUNT(statisticid) / (SELECT COUNT(*) FROM question where test.testId = question.testId)) AS count,
           ROUND(avg(correct), 2) * 100 AS avg
    FROM statistic
             JOIN question on statistic.questionid = question.questionid
             JOIN test ON question.testid = test.testid
             JOIN user ON statistic.userid = user.userid
             JOIN topic ON topic.topicId = test.topicId
    GROUP BY user.firstname, user.lastname, topicName, testName, test.testId;
END;