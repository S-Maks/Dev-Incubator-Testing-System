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
    SELECT test.name, COUNT(statisticId) AS count, ROUND(avg(correct), 2) * 100 AS avg
    FROM statistic
             JOIN question ON statistic.questionid = question.questionid
             JOIN test ON question.testid = test.testid
    GROUP BY test.name;
END;

CREATE PROCEDURE `getQuestionsStat` ()
    LANGUAGE SQL
    DETERMINISTIC
    SQL SECURITY DEFINER
    COMMENT 'A questions statistic procedure'
BEGIN
    SELECT description AS question, count(statisticId) AS count, ROUND(avg(correct), 2) * 100 AS avg
    FROM statistic
             JOIN question ON statistic.questionid = question.questionid
    GROUP BY question;
END;

CREATE PROCEDURE `getUsersStat` ()
    LANGUAGE SQL
    DETERMINISTIC
    SQL SECURITY DEFINER
    COMMENT 'A users statistic procedure'
BEGIN
    SELECT firstname, lastname, test.name, COUNT(statisticid) AS count, ROUND(avg(correct), 2) * 100 AS avg
    FROM statistic
             JOIN question on statistic.questionid = question.questionid
             JOIN test ON question.testid = test.testid
             JOIN user ON statistic.userid = user.userid
    GROUP BY firstname, lastname, test.name;
END;