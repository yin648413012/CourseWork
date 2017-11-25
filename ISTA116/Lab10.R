# Name: Brian Loi
# Date: 4/5/17
# ISTA 116 Section C
# Lab Assignment 10
# Collaborator(s): Ryan Majka

download.file("http://www.openintro.org/stat/data/ames.RData", destfile = "ames.RData")
load("ames.RData")

#1
sample.60 <- sample(ames$Gr.Liv.Area, 60, replace = FALSE)
mean(sample.60)
# 1597.35
# Because this is a mean of a sample, this number will be different every time

#2
standard.err.60 <- sd(sample.60)/sqrt(60)
standard.err.60
# 63.44403
# This standard error changes every time because it is from a randomized sample

#3
upper.bound <- mean(sample.60) + qnorm(1-(1- .95)/2) * standard.err.60
lower.bound <- mean(sample.60) - qnorm(1-(1- .95)/2) * standard.err.60
c(lower.bound, upper.bound)
# 1482.075 1712.625

#4
mean(ames$Gr.Liv.Area)
# 1499.69
# Yes, it does fall within the confidence interval.

#5
a <- replicate(50, {
               sample.60 <- sample(ames$Gr.Liv.Area, 60, replace = FALSE);
               mean(sample.60);
               standard.err.60 <- sd(sample.60)/sqrt(60);
               upper.bound <- mean(sample.60) + qnorm(1-(1- .95)/2) * standard.err.60;
               lower.bound <- mean(sample.60) - qnorm(1-(1- .95)/2) * standard.err.60;
               c(lower.bound, upper.bound);
               })
dim(a)
# 2 50

#6
lower.bounds <- a[1,]
upper.bounds <- a[2,]
length(lower.bounds)
#50
length(upper.bounds)
#50

#7
plot_ci(lower.bounds, upper.bounds, mean(ames$Gr.Liv.Area))
# All of the confidence intervals contain the population mean. This does not match our expectations because we expected to see at least 2.5 not contain the population mean, but we saw 0.

#8
qnorm(1-(1-.9)/2)
# The confidence interval interval that we have chosen is .90
# 1.644854

#9
b <- replicate(50, {
  sample.60 <- sample(ames$Gr.Liv.Area, 60, replace = FALSE);
  mean(sample.60);
  standard.err.60 <- sd(sample.60)/sqrt(60);
  upper.bound <- mean(sample.60) + qnorm(1-(1- .9)/2) * standard.err.60;
  lower.bound <- mean(sample.60) - qnorm(1-(1- .9)/2) * standard.err.60;
  c(lower.bound, upper.bound);
})
lower.bounds <- b[1,]
upper.bounds <- b[2,]
plot_ci(lower.bounds, upper.bounds, mean(ames$Gr.Liv.Area))

#10
# 4 of our confidence intervals do not contain the population mean. This number is very different from step 7, because all of our confidence intervals contained the population mean in step 7 even though we expected 2.5. In addition, because the confidence interval is lower by .05 from 95% to 90%, there is a wider window for confidence intervals to not contain the population mean. This does not match our expectations, but was close to our expectations, because we expected 5 confidence intervals to not contain the population mean but only found 4.