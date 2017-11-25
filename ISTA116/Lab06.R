# Name: Brian Loi
# Date: 3/1/17
# ISTA 116 Section C
# Lab Assignment 6
# Collaborator(s): Hannah Smith

#1
suits <- c("Spade", "Heart", "Diamond", "Club")
ranks <- c("Ace", 2, 3, 4, 5, 6, 7, 8, 9, 10, "Jack", "Queen", "King")

#2
df = expand.grid(suits=suits, ranks=ranks)

#3
df.prop <- prop.table(table(df$suits, df$ranks))
rowSums(df.prop)
colSums(df.prop)
df.prop
# The probability of drawing a Spade is 0.25
# The probability of drawing an Ace is 0.07692308
# The probability of drawing an Ace of Spades is 0.01923077

#4
s = sample(c(1:52), size = 10, prob = df.prop, replace = FALSE)
df[s,]
#      suits ranks
# 23 Diamond     6
# 20    Club     5
# 6    Heart     2
# 35 Diamond     9
# 43 Diamond  Jack
# 22   Heart     6
# 34   Heart     9
# 12    Club     3
# 39 Diamond    10
# 8     Club     2

#5
df.removed <- df[-s,]
df.removed.prop <- prop.table(table(df.removed$suits, df.removed$ranks))
rowSums(df.removed.prop)
colSums(df.removed.prop)
df.removed.prop
# No the probabilities are not the same as step 3, because the number of total cards in the deck is now different, and the number of Spades, Aces, and Ace of Spades may also be different, which changes the probabilities.

#6
dice <- c(1,2,3,4,5,6)
dice.df <- expand.grid(dice1 = dice, dice2 = dice, dice3 = dice)

#7
dice.df$sum = rowSums(dice.df)

#8
barplot(prop.table(table(dice.df$sum)))
# The most likely two outcomes when you roll three dice and take their sum are 10 and 11.

#9
diceRoll <- replicate(1000,{
          s1 <- sample(c(1,2,3,4,5,6), size = 3, replace = TRUE);
          sum.dices <- sum(s1);
          })
barplot(prop.table(table(diceRoll)))
# This graph generally has the same curve as that from step 8 and their probabilties are close and similar, but the most likely two outcomes are usually different from what is expected (from step 8).

#10
diceRoll2 <- replicate(1000,{
  s2 <- sample(c(1,2,3,4,5,6), size = 5, replace = TRUE);
  s2.sorted <- sort(s2, decreasing = TRUE);
  sum.dices2 <- s2.sorted[1] + s2.sorted[2] + s2.sorted[3];
})
barplot(prop.table(table(diceRoll2)))
# Unlike the other graphs which form a nice bell curve across the x-axis, this graph is more left-skewed than the others. This graph still has a bell curve, but is just more left-skewed. Because the highest sum of the highest 3 rolls are taken, the probability of higher sums occurring is greater, while smaller sums are less likely. As a result, the most likely two outcomes from this graph is greater than that from the other graphs. 