# Name: Brian Loi
# Date: 4/12/17
# ISTA 116 Section C
# Lab Assignment 11
# Collaborator(s): Maria Smith

download.file("http://www.openintro.org/stat/data/nc.RData", destfile = "nc.RData")
load("nc.RData")

nc <- na.omit(nc)

#1
# H0:The average number of weeks for children in North Carolina is 40
# HA:The average number of weeks for children in North Carolina is not 40
# H0: Mu = 40
# HA: Mu != 40

#2
hist(nc$weeks)
# The histogram does not look approximately normal, and is skewed to the left. It resembles a normal distribution in some way and could possibly be argued to be normal, but it is too skewed and uneven to be approximately normal. It does not need to look approximately like a normal distribution to perform a hypothesis test, because a hypothesis test can be done with T-testing and T-distribution, which does not require a normal distribution.

#3
avg <- mean(nc$weeks)
avg
# 38.4675
stdErr <- sd(nc$weeks)/sqrt(nrow(nc))
stdErr
# 0.09736159

#4
qnorm(1-(1-.99)/2)
# 2.575829

#5
avg-qnorm(1-(1-.99)/2)*stdErr
# 38.21671
avg+qnorm(1-(1-.99)/2)*stdErr
# 38.71829
# The 99% Confidence Interval is (38.21671, 38.71829). The null hypothesis does not lie within the confidence interval.

#6
ZScore <- (avg-40)/stdErr
ZScore
# -15.74029

#7
pVal <- pnorm(ZScore)*2
pVal
# 8.007101e-56
# Our calculation is two-sided, because we are using t-testing, so there is a pval to the left and right of the mean. From the pnorm, we can conclude that the amount of data lying outside the confidence interval is extremely small. In addition, because the pvalue is significantly smaller than alpha(0.05), then we reject the null hypothesis.

#8
RejVal <- qnorm(.05, 40, stdErr )
RejVal
# 39.83985

#9
pnorm(RejVal, 39+6/7, stdErr)
# 0.4295307
# I would not be satisfied with this level of power because it would mean that we would only correctly reject the null hypothesis less than half of the time. As a result, with a low power level as 42%, we won’t be able to correctly reject the null hypothesis a majority of the time.


#10
pnorm(RejVal, 39, stdErr)
# 1
# I would be satisfied with this level of power because it would mean that we would correctly reject the null hypothesis all the time. As a result, with a high power level of 100%, we will be able to correctly reject the null hypothesis all the time.
