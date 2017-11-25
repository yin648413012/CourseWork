# Name: Brian Loi
# Date: 2/15/17
# ISTA 116 Section C
# Lab Assignment 4
# Collaborator(s): Hannah Smith

library(openintro)

#1
boxplot(heartTr$survtime)
#There are 10 outliers

#2
boxplot(log(heartTr$survtime))
#There are no outliers

#3
# The number of outliers change because natural logarithms greatly reduces large numbers, so the previous outliers became closer to the non-outliers and the majority of the data. The boxplot that is not log-transformed is a better representation of the data because in this case, outliers are important and useful information. If some patients lived much longer than the majority of others after a heart transplant, it is important to note and see this.

#4
table(heartTr$survived, heartTr$transplant)
# 4 people in the control group survived

#5
prop.table(table(heartTr$survived, heartTr$transplant), margin = 2)
# Treatment patients were more likely to survive

#6
prop.table(table(heartTr$survived, heartTr$transplant), margin = 1)
# I would interpret these proportions as of those who survived, 0.1428571 were a part of the control group and 0.8571429 were a part of the treatment group. On the other hand, 40% of those who died were a part of the control group and 60% were a part of the treatment group. These are different from the proportions from the previous step because the proportions are based on the number of those who lived and died rather than the number of people in the control and treatment groups.

#7
barplot(table(heartTr$survived, heartTr$acceptyear))
# Generally, over time, the number of survivals compared to deaths increased as the years of the study increased. In other words, the rate of survival from transplants increased over the years of the study.

#8
barplot(table(heartTr$survived, heartTr$acceptyear), legend.text = TRUE)

#9
barplot(prop.table(table(heartTr$transplant, heartTr$acceptyear), margin = 2), legend.text = TRUE)
# Generally, the proportion of patients in the control group have decreased over the years of the study until the last year. Likewise, the proportion of patients in the treatment group generally increased over the years of the study until the last year.

#10
mosaicplot(table(heartTr$acceptyear,heartTr$transplant))
# Generally, the trend is that over time, the treatment group became greater in terms of the total amount of patients and quickly became larger than the control group until the last year. This plot allows us to see the proportions of the patients in either the control or treatment group each year according to the total number of patients. Furthermore, it shows how many more people were in the control or treatment group compared to each other.


