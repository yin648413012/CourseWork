# Name: Brian Loi
# Date: 2/8/17
# ISTA 116 Section C
# Lab Assignment 3
# Collaborator(s): Malik Lewis

source("http://www.openintro.org/stat/data/cdc.R")

#1
plot(cdc$wtdesire, cdc$weight)
# There is a positive association between the people's weight and desired weight. Generally, as the people's desired weight increases, their weightalso increases.

#2
wdiff <- (cdc$weight - cdc$wtdesire)
# If an observation has wdiff of 0, then it means that the person's weight and desired weight is the same so they are already at their desired weight. If wdiff is positive, then the person wants to lose weight. If wdiff is negative, then the person wants to gain weight.

#3
median(wdiff)
# The center is 10. The used definition was median because there are a lot of numbers in the set, so adding in one more number would not greatly change the center.


#4
hist(wdiff, xlim=c(-100,150))
boxplot(wdiff, ylim=c(-30,50))
# The shape of wdiff is a right skew, and is heavy near 0 to 50. The spread is 80. The technique used to look at the shape was a histogram and a box plot was used for the spread. A histogram was used because it gives a visual representation of shape. A box plot was used because its whiskers and box sizes tell us the spread.

#5
# The center says that most people, or on average, want to lose around 10 weight. The shape says that most people are above their desired weight and want to lose weight. The spread says that most people's desired weights are within a range of 80 weight.

#6
boxplot(wdiff ~ cdc$gender, ylim=c(-100, 100))
# Yes, men and women differ in how they view weight, because more women want to lose weight than men.

#7
boxplot(wdiff ~ cdc$gender)
# There are two outliers in the male category, in which they desire to gain over 300 weight.

#8
mean(cdc$weight) - sd(cdc$weight)
mean(cdc$weight) + sd(cdc$weight)
mean(cdc$weight) - 2 * sd(cdc$weight)
mean(cdc$weight) + 2 * sd(cdc$weight)
# 129.602
# 209.7639
# 89.52101
# 249.8449

#9
length(subset(cdc$weight, cdc$weight >= mean(cdc$weight) - sd(cdc$weight) & cdc$weight <= mean(cdc$weight) + sd(cdc$weight))) / nrow(cdc)
length(subset(cdc$weight, cdc$weight >= mean(cdc$weight) - 2*sd(cdc$weight) & cdc$weight <= mean(cdc$weight) + 2*sd(cdc$weight))) / nrow(cdc)
# The proportion of observations that are within 1 standard deviation of the mean is 0.7076 (or 14152/20000).
# The proportion of obersations that are within 2 standard deviations of the mean is 0.9563 (or 19126/20000)

#10
length(subset(cdc$height, cdc$height >= mean(cdc$height) - sd(cdc$height) & cdc$height <= mean(cdc$height) + sd(cdc$height))) / nrow(cdc)
length(subset(cdc$height, cdc$height >= mean(cdc$height) - 2*sd(cdc$height) & cdc$height <= mean(cdc$height) + 2*sd(cdc$height))) / nrow(cdc)
length(subset(cdc$age, cdc$age >= mean(cdc$age) - sd(cdc$age) & cdc$age <= mean(cdc$age) + sd(cdc$age))) / nrow(cdc)
length(subset(cdc$age, cdc$age >= mean(cdc$age) - 2*sd(cdc$age) & cdc$age <= mean(cdc$age) + 2*sd(cdc$age))) / nrow(cdc)
# 0.62125 (or 12425/20000)
# 0.97725 (or 19545/20000)
# 0.6403 (or 12806/20000)
# 0.9693 (or 19386/20000)