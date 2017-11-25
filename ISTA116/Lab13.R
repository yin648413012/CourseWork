# Name: Brian Loi
# Date: 4/28/17
# ISTA 116 Section C
# Lab Assignment 13
# Collaborator(s): Chris Benz

download.file("http://www.openintro.org/stat/data/atheism.RData", destfile = "atheism.RData")
load("atheism.RData")

#1
# These percentages appear to be sample statistics because based on the report, the entire global population did not participate in the survey, but only portions of the populations of countries. In addition, the term survey is used in the report which implies that only a portion of the population was used in the statistic, therefore the percentages in the report are a sample statistic.

#2
df <- subset(atheism, nationality == "United States")
atheism.us <- table(df$year, df$response)
atheism.us
#      atheist non-atheist
# 2005      10       992
# 2012      50       952

#3
prop.table(atheism.us, margin = 1)
#           atheist non-atheist
#   2005 0.00998004  0.99001996
#   2012 0.04990020  0.95009980
# 0.06694013 of respondents in 2012 had "atheist" as their response
# Yes, this calculation matches the number in Table 6 of the report because Table 6 shows that 5% of the U.S. was atheist, and our calculation shows that 4.99% of the U.S. was atheist. Yes, this confirms our answer from step 1, because our data used was sample statistics and gave the same number that was in the Table 6, therefore the report's percentages are sample statistics.

#4
# Yes, the conditions are met for constructing a confidence interval for this proportion, because the survey implies that random sampling was used so the data can be said to be independent and the sample is about 5% of the overall population which is less than 10% of the overall population is met. 
prop.test(as.table(atheism.us["2012",]))
# 	1-sample proportions test with continuity correction
#
# data:  as.table(atheism.us["2012", ]), null probability 0.5
# X-squared = 810.18, df = 1, p-value < 2.2e-16
# alternative hypothesis: true p is not equal to 0.5
# 95 percent confidence interval:
#  0.03761982 0.06574456
# sample estimates:
#         p 
# 0.0499002 
# The 95% confidence interval using prop.test over the single row of the atheism.us table that corresponds to 2012 is (0.03761982 0.06574456).


#5
prop.test(as.table(atheism.us["2012",]), p = .13)
# 	1-sample proportions test with continuity correction
#
# data:  as.table(atheism.us["2012", ]), null probability 0.13
# X-squared = 56.136, df = 1, p-value = 6.763e-14
# alternative hypothesis: true p is not equal to 0.13
# 95 percent confidence interval:
#   0.03761982 0.06574456
# sample estimates:
#   p 
# 0.0499002
# We can conclude that the proportion of atheists in the US in 2012 is significantly different from the global proportion in 2012.

#6
response.pooled.p <- prop.table(colSums(atheism.us))
row.count <- rowSums(atheism.us)
outer(row.count, response.pooled.p)
#      atheist non-atheist
# 2005      30         972
# 2012      30         972
# There are at least 10 in each, so our sample is sufficeiently large. This means that the conditions are met for testing.
prop.test(as.table(atheism.us), alternative = "less")
# The p-value is 1.594e-07, which is less than alpha(0.05) so the proportion of atheists in the US in 2005 lower than the proportion in 2012.

#7
n <- 1000
p <- seq(0, 1, 0.01)
standardErr = sqrt(p*(1-p)/n)

#8
plot(p, standardErr)
# Based on the plot, the value of p that would end up with the largest confidence interval is 0.5

#9
df.spain <- subset(atheism, nationality == "Spain")
atheism.spain <- table(df.spain$year, df.spain$response)
atheism.spain
#       atheist non-atheist
#  2005     115        1031
#  2012     103        1042
response.pooled.p <- prop.table(colSums(atheism.spain))
row.count <- rowSums(atheism.spain)
outer(row.count, response.pooled.p)
#       atheist non-atheist
# 2005 109.0476    1036.952
# 2012 108.9524    1036.048
# There are at least 10 in each, so our sample is sufficeiently large. This means that the conditions are met for testing.
prop.test(as.table(atheism.spain))
# Spain has not seen a significant change in its atheism index between 2005 and 2012. The prop.test resulted in a p-value of 0.4375 which is greater than alpha(0.05), so we fail to reject the null hypothesis that there is no difference in the atheism index between 2005 and 2012. In addition, the 95% confidence interval is (-0.01450680, 0.03529222) which includes 0 and is limited to values very close to 0, meaning that there is no change and if there is, it is small.

#10
df.BraCol = subset(atheism, year == "2012")
table.BraCol <- table(df.BraCol$nationality, df.BraCol$response)
atheism.BraCol <- table.BraCol[c("Colombia", "Brazil"),]
atheism.BraCol
#            atheist non-atheist
#   Colombia      18         588
#   Brazil        20        1982
response.pooled.p <- prop.table(colSums(atheism.BraCol))
row.count <- rowSums(atheism.BraCol)
outer(row.count, response.pooled.p)
#            atheist non-atheist
# Colombia  8.829755    597.1702
# Brazil   29.170245   1972.8298
# There are not at least 10 in each, so our sample is not sufficeiently large enough for testing. This means that the conditions are not met for testing, because the amount of atheists in Colombia used is 8.829 which is less than 10. As a result, no testing will be done as the conditions for an accurate test are not met.