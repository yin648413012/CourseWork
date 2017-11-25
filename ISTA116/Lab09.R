# Name: Brian Loi
# Date: 3/29/17
# ISTA 116 Section C
# Lab Assignment 9
# Collaborator(s): Ryan Majka

download.file("http://www.openintro.org/stat/data/ames.RData", destfile = "ames.RData")
load("ames.RData")

#1
mean(ames$Gr.Liv.Area)
#1499.69

#2
ames.gr.liv.area.sample <- sample(ames$Gr.Liv.Area, size=50, replace = FALSE)
mean(ames.gr.liv.area.sample)
#1551.56, This is going to be different because we are using sample
# This is different from the mean of the entire population because only 50 out of 2930 samples are being used for the mean. Essentially, different numbers are being calculated in the mean, and the total number of samples calculated in the mean is different.

#3
par(mfrow = c(2,1))
area.xlim <- range(ames$Gr.Liv.Area)

#4
hist(ames$Gr.Liv.Area, xlim = area.xlim)
abline(v=mean(ames$Gr.Liv.Area), col='red', lwd=2)

#5
hist(ames.gr.liv.area.sample, xlim = area.xlim)
abline(v=mean(ames.gr.liv.area.sample), col='red', lwd=2)
#The full population plot and the sample plots are similar in that they follow the same pattern and have similar frequency values, but not exactly the same. Their means are also pretty close to each other, but not the same. In addition, the full population plot seems to follow a more normal distribution than the sample population plot. 

#6
area.means.10 <- replicate(5000, {mean(sample(ames$Gr.Liv.Area, size=10, replace = FALSE))})
hist(area.means.10)
# The histogram looks similar to a normal distribution. It increases and decreases with one peak, and little skew. 

#7
area.means.50 <- replicate(5000, {mean(sample(ames$Gr.Liv.Area, size=10, replace = FALSE))})
area.means.100 <- replicate(5000, {mean(sample(ames$Gr.Liv.Area, size=10, replace = FALSE))})

#8
par(mfrow = c(3,1))
area.means.10.xlim <- range(area.means.10)

#9
hist(area.means.10, breaks = 20, xlim = area.means.10.xlim)
hist(area.means.50, breaks = 20, xlim = area.means.10.xlim)
hist(area.means.100, breaks = 20, xlim = area.means.10.xlim)
# I would choose the sample size of 100, because it uses the most data points so it gets the best normal distribution in the histogram. Compared to the other histograms, the plot with a sample size of 100 appears to have the most normal distribution.

#10
# If you took a sample of size 1 you would only get one data point in your histogram which doesn't tell you much information. The histogram would simply be one bar with a frequency of 1. Because of this, the plot would not be able to give us accurate information on the whole population. If you took a sample of size 2930 you would get a lot of data points which would give you a very well distributed histogram. The histogram would look like a normal distribution and be nicely spread. In addition, the plot's information would be very useful because the entire population size was used in the sample.