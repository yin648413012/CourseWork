# Name: Brian Loi
# Date: 3/22/17
# ISTA 116 Section C
# Lab Assignment 8
# Collaborator(s): Ryan Majka

download.file("http://www.openintro.org/stat/data/bdims.RData", destfile = "bdims.RData")
load("bdims.RData")

#1
fdims <- subset(bdims, sex == 0)
hist(fdims$hgt, probability = TRUE)
# The data slightly appears as a normal distribution. It is not perfect, but there is an increase, a peak, and then a decrease. It looks almost normal, but one side is slightly larger than the other.

#2
x <- seq(min(fdims$hgt), max(fdims$hgt), by = 0.1)

#3
y <- dnorm(x, mean(fdims$hgt), sd(fdims$hgt))

#4
lines(x, y, col = "red")
# In relation to the histogram, if this data is normally distributed, this line should form a nice, or almost perfect, curve that follows the data. The female height data somewhat follows the line, but there are many gaps and data going over the curve. 

#5
qqnorm(fdims$hgt)
qqline(fdims$hgt)
#If the data is normally distributed, then the QQ normality plot should be generally linear, increasing and should fall close to the QQ line. The qqnorm of the female height somewhat follows a pretty normal distribution. The data points are not exactly on the line for the most part, but are close enough. The data does not vary far off from the qq line.

#6
a <- rnorm(nrow(fdims), mean(fdims$hgt), sd(fdims$hgt))
qqnorm(a)
#A QQ normality plot of this generated data should look like a normal distribution, an a plot of points increasing from left to right that is a somewhat linear.
qqline(a)
#It looks like the qqnorm follows the qqline so it does look like the data is a normal distribution. The QQ normality plot looks like is should for this data, that was drawn from a normal distribution.

#7
qqnormsim(fdims$hgt)
# These plots can be used to be more confident about whether or not the actual data is normally distributed if the QQ plot of the actual data looks like the simulated QQ plots. In this case, the QQ plot of the actual data looks similar enough to the simulated QQ plots which confirms that the female height data is a normal distribution.

#8
qqnormsim(fdims$age)
#The age does not seem to be a normal distribution because the data plot does not match any of the simulated plots for age, as the plot of the actualy data is more curved and the qqline for it is very different from the qqlines of the simulated plots.
qqnormsim(fdims$wgt)
#The weight does not seem to be a normal distribution because the plot of the original data does not match any of the simulated plots for weight.

#9
pnorm(182, mean(fdims$hgt), sd(fdims$hgt), lower.tail = FALSE)
nrow(subset(fdims, hgt > 182)) / nrow(fdims)
# 0.004434387
# 0.003846154
# This probability estimated and the actual probability are not exactly the same, but very close to each other, because the difference between them is about 0.001.

#10
qnorm(.9, mean(fdims$hgt), sd(fdims$hgt))
pnorm(173.2596, mean(fdims$hgt), sd(fdims$hgt))
# 173.2596
# 0.9000013
# The proportion matches the expected percentile, because the 90th percentile was used for qnorm and when the output of that qnorm was used in pnorm to find the percent below that value, pnorm returned about .9. The proportion is not exactly .9 but very close.