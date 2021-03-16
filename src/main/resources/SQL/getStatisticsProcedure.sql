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