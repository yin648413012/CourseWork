# Name: Brian Loi
# Date: 2/22/17
# ISTA 116 Section C
# Lab Assignment 5
# Collaborator(s): Hannah Smith

download.file("http://www.openintro.org/stat/data/kobe.RData", destfile = "kobe.RData")
load("kobe.RData")

#1
kobe.basket.prob <- prop.table(table(kobe$basket))

#2
kobe.basket.prob["H"]
# 0.4360902

#3
calc_streak(kobe$basket[1:13])
# 1 0 2 0 0 0 3 0
# This function is calculating the streaks of the hits and misses that Kobe makes in a row. So, if Kobe only makes one shot then misses, then it prints 1, but if he scores three times in a row, then it prints three.  If Kobe misses once or twice in a row, then it prints out 0.

#4
barplot(table(calc_streak(kobe$basket)), ylim = c(0,40))

#5
player <- sample(c("H","M"), size= nrow(kobe), prob = c(kobe.basket.prob["H"], kobe.basket.prob["M"]), replace = TRUE)

#6
prop.table(table(player))
# It differs from Kobe's probability distribution and it should because just because the probability of scoring or missing is the same as Kobe's, does not mean that the same results will occur each time. The probability affects each time a sample is pulled, and does not control the entire data set itself.

#7
barplot(table(calc_streak(player)), ylim = c(0,40))
# This bar plot has more bar's than Kobe's, meaning that the player had a larger variety of streaks and bigger streaks. On the other hand, the player has a smaller ammount of small streaks (such as a streak of 1) than Kobe did. There are also more 0's (streaks of misses) on this graph than Kobe's. 

#8
prop.table(table(calc_streak(kobe$basket)))
prop.table(table(calc_streak(player)))
# The probabilities are different from each other. The streaks begin with a large difference of about .1, but become smaller as the streak becomes bigger.

#9
s.prob.total <- replicate(100, 
          {
            s <- sample(c("H","M"), size= nrow(kobe), prob = c(kobe.basket.prob["H"], kobe.basket.prob["M"]), replace = TRUE);
            s.streak <- calc_streak(s);
            s.prob <- prop.table(table(s.streak));
            s.prob["0"];
          }
          )

summary(s.prob.total)
# Kobe's probability of length-0 streak is typical, because the difference from his 0-streak to the mean and median of the replicated data is only a few hundredths, which is a small difference. This means that Kobe's 0-streak is in his typical range for his median or average 0-streaks.

#10
s3.prob.total <- replicate(100, 
                          {
                            s3 <- sample(c("H","M"), size= nrow(kobe), prob = c(kobe.basket.prob["H"], kobe.basket.prob["M"]), replace = TRUE);
                            s3.streak <- calc_streak(s3);
                            s3.prob <- prop.table(table(s3.streak));
                            s3.prob["3"];
                          }
)

summary(s3.prob.total)
# Kobe's 3-streak is somewhat not typical because the difference between his probability of a 3-streak and the mean and median of the replicated data is about 0.03, which is not a huge difference, so it can be considered typical at the same time. On the other hand, Kobe's probability of a 3-streak is above the upper quartile of the replicated data. Kobe seems to be less likely to get a streak of successful shots as compared to a simulated player whose shots are independent from each other. A simulated player is able to get much larger streaks than Kobe was able to, although at a low probability.