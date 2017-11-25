# Name: Brian Loi
# Date: 3/8/17
# ISTA 116 Section C
# Lab Assignment 7
# Collaborator(s): Hannah Smith

#1
dice.df <- data.frame(roll = c(1,2,3,4,5,6), score = c(100, 0, 0, 0, 50, 0), prob = c( 1/6,1/6,1/6,1/6,1/6, 1/6))

#2
rollScore <- sample(dice.df$score, size = 10000, prob = dice.df$prob, replace = TRUE)
hist(rollScore)
# The possible scores are 0, 50, and 100. The occurence of a score of 50 and 100 on a roll are very similar and occur almost the same amount of times. The amount of scores of 50 and 100 are always below 2000, around 1600. There is more scores of 0 than 50 and 100 per roll, and its occurence is much greater than the other two scores, happening over 6000 times.

#3
mean(rollScore)
weighted.mean(dice.df$score, dice.df$prob)
# 25.205
# 25
# The sample mean does not differ much from the expected value. The sample mean is a little off and not perfectly the expected value due to probability. The sample mean and the expected value are very close because 10,000 samples were taken for the sample mean, which means it is more able to be accurate to the expected value. The greater number of samples, the closer the samples will reflect the probabilities.

#4
sd(rollScore)
sqrt(sum((dice.df$score-weighted.mean(dice.df$score,dice.df$prob))^2 * dice.df$prob))
# 38.34195
# 38.18813
# The standard deviation of the sample mean is extremely close to that of the random variable's. The sample's standard deviation and the standard deviation of the expected value are very close because 10,000 samples were taken for the sample standard deviation, which means it is more able to be accurate to the standard deviation of the random variables. The greater number of samples, the closer the samples will reflect the probabilities.

#5
loadedDice.df <- data.frame(roll = c(1,2,3,4,5,6), score = c(100, 0, 0, 0, 50, 0), prob = c( .1, .1, .1, .1, .5, .1))

#6
loadedRollScore <- sample(loadedDice.df$score, size = 10000, prob = loadedDice.df$prob, replace = TRUE)
hist(loadedRollScore)
# The possible scores are 0, 50, and 100 for each roll. A score of 50 on a roll occurs the most because it has the highest probability of happening. It occurs more than a score of 0 and 100, happening about 5000 times. A score of 100 occurs the least and happens about 1000 times (.1 of the time), which makes sense because it has the lowest probability out of the three possible scores. A score of 0 occurs 4000 times (.4 of the time). 

#7
mean(loadedRollScore)
weighted.mean(loadedDice.df$score, loadedDice.df$prob)
# 35.12
# 35
# The mean of the samples and the expected value are very close. There is a difference of 10 between these values and those from step 3. It is expected to earn 10 more points on average by using a loaded die instead of a reguler die.

#8
allScores <-replicate(10000, {
  regularScore <- sample(dice.df$score, size = 1, prob = dice.df$prob, replace = TRUE);
  loadedScore <- sample(loadedDice.df$score, size = 1, prob = loadedDice.df$prob, replace = TRUE);
  totalScore <- regularScore + loadedScore;
})
hist(allScores)
# This histogram has the same number of modes as step 6, which is 1, but has a different number of modes as step 2, which had 2. This is because this game has a larger variety of possible scores and different probabilities for each roll, unlike step 2 which two possible scores had the same probability of occurring.

#9
mean(allScores)
weighted.mean(dice.df$score, dice.df$prob) + weighted.mean(loadedDice.df$score, loadedDice.df$prob)
# 59.44
# 60
# The sample mean and the expected value of this game is much higher than the previous games because combining the scores from both rolls allows for the scores per turn to be much higher, allowing double the score of previous games per turn at most. In addition, the loaded die increases the chances of scoring at least 50 points in a turn, with the possible addition of more points from the regular dice. In other words, the sample mean and expected value from this game is higher because higher scores are possible and more likely to occur for each turn.

#10
MeanScore <-replicate(10000, {
  regularScore1 <- sample(dice.df$score, size = 1, prob = dice.df$prob, replace = TRUE);
  regularScore2 <- sample(dice.df$score, size = 1, prob = dice.df$prob, replace = TRUE);
  loadedScore1 <- sample(loadedDice.df$score, size = 1, prob = loadedDice.df$prob, replace = TRUE);
  loadedScore2 <- sample(loadedDice.df$score, size = 1, prob = loadedDice.df$prob, replace = TRUE);
  loadedScore3 <- sample(loadedDice.df$score, size = 1, prob = loadedDice.df$prob, replace = TRUE);
  avgScore <- (regularScore1 + regularScore2 + loadedScore1 + loadedScore2 + loadedScore3) / 5;
})
hist(MeanScore)
(2*weighted.mean(dice.df$score, dice.df$prob) + 3*weighted.mean(loadedDice.df$score, loadedDice.df$prob))/5
# 31
# The game with 5 dice would be the most profitable, because the cost of the game and the expected value of the other games result in an expected profit of 20 points, while the game with 5 dice has an expected profit of 21.
