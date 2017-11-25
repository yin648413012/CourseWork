# Name: Brian Loi
# Date: 4/21/17
# ISTA 116 Section C
# Lab Assignment 12
# Collaborator(s): None

download.file("http://www.openintro.org/stat/data/nc.RData", destfile = "nc.RData")
load("nc.RData")

#1
by(nc$weight, nc$habit, mean)
# nc$habit: nonsmoker
# [1] 7.144273
# --------------------------------------------------------- 
# nc$habit: smoker
# [1] 6.82873

#2
by(nc$weight, nc$habit, hist)
# Yes, the conditions are met for an inference

#3
# H0: The average weights of babies born from smoking and non-smoking mothers are not different.
# HA: The average weights of babies born from smoking and non-smoking mothers are different.
# H0: Mu1 = Mu2
# HA: Mu1 != Mu2

#4
t.test(nc$weight~nc$habit)
# Welch Two Sample t-test
# data:  nc$weight by nc$habit
# t = 2.359, df = 171.32, p-value = 0.01945
# alternative hypothesis: true difference in means is not equal to 0
# 95 percent confidence interval:
#   0.05151165 0.57957328
# sample estimates:
# mean in group nonsmoker    mean in group smoker 
#               7.144273                6.828730 
# Yes, there is a significant difference between the weights of smokers' children and nonsmokers' children.

#5
# Yes, I would be surprised because 0.8 is not within the confidence interval and is relatively far from the limits of the confidence interval.

#6
t.test(nc$weeks)
#     One Sample t-test
#
# data:  nc$weeks
# t = 413.1, df = 997, p-value < 2.2e-16
# alternative hypothesis: true mean is not equal to 0
# 95 percent confidence interval:
#   38.15257 38.51677
# sample estimates:
# mean of x 
#  38.33467 
# No, I would not be surprised because 38.5 is inside the confidence interval

#7
t.test(nc$weeks, conf.level = .9)
# 	One Sample t-test
#
#data:  nc$weeks
#t = 413.1, df = 997, p-value < 2.2e-16
#alternative hypothesis: true mean is not equal to 0
#90 percent confidence interval:
#  38.18189 38.48745
#sample estimates:
#  mean of x 
#  38.33467 
# No, I would not be surprised if the true average length of pregnancies was 38.5 weeks. The answer is the same as question 6 because the confidence percentage is now 90%, meaning that 1 out of 10 means will not be within the confidence interval, which is a pretty significant amount. In addition, 38.5 is really close to the confidence interval.

#8
t.test(nc$gained~nc$mature)
#	Welch Two Sample t-test
#
#data:  nc$gained by nc$mature
#t = -1.3765, df = 175.34, p-value = 0.1704
# alternative hypothesis: true difference in means is not equal to 0
#95 percent confidence interval:
#  -4.3071463  0.7676886
#sample estimates:
#  mean in group mature mom mean in group younger mom 
#                 28.79070                  30.56043 
# We can conclude that the average weight gained by younger moms is not different than the average weight gained by mature mothers. Because the p-value (0.1705) is greater than 0.05, we fail to reject the null hypothesis that the true difference in the means is equal to 0.

#9
nc$mage
nc$mature
nc$mature[867]
nc$mature[868]
nc$mage[867]
nc$mage[868]
# The mothers in the data set are organized from youngest to oldest. Likewise, the younger moms are at the beginning of the data set and the mature moms are at the end. Looking from the data, the last younger mom is at index 867 and the first mature mom is at index 868. Now, after looking at the ages of those indexes, it can be determined that the mothers who are 34 years old or younger are younger moms and mothers that are 35 years old or older are mature moms.

#10
# H0: The average weight gained during pregnancy in lbs for white moms is the same as the average weight gained during pregnancy in lbs for non-white moms.
# HA: The average weight gained during pregnancy in lbs for white moms is different from the average weight gained during pregnancy in lbs for non-white moms.
by(nc$gained, nc$whitemom, hist)
#The conditions necessary for inference are satisfied
t.test(nc$gained~nc$whitemom)
# Welch Two Sample t-test
#
#data:  nc$gained by nc$whitemom
#t = -2.1898, df = 468.39, p-value = 0.02903
#alternative hypothesis: true difference in means is not equal to 0
#95 percent confidence interval:
#  -4.3729072 -0.2365665
#sample estimates:
#  mean in group not white     mean in group white 
#                 28.67509                30.97983 
# From the t.test, the p-value is 0.02903 and the average weight gained during pregnancy for white moms is 30.97983 and 28.67509 for non-white moms. In addition, the t.test resulted in a 95% confidence interval of (-4.3729072, -0.2365665). Therefore 0 is not within the 95% confidence interval so the means are not equal a large majority of the time. Accordingly, it can be said that the weight gained is different for white moms and non-white moms most of the time. Furthermore, since the p-value, 0.02903, is less than alpha, 0.05, then we can reject the null hypthesis that the means are equal. As a result, we can conclude that there is a difference in the average weight gained during pregnancy between white mothers and non-white mothers.