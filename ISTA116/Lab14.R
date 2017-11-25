# Name: Brian Loi
# Date: 5/5/17
# ISTA 116 Section C
# Lab Assignment 14
# Collaborator(s): Maria Smith

download.file("http://www.openintro.org/stat/data/mlb11.RData", destfile = "mlb11.RData")
load("mlb11.RData")

#1
plot(mlb11$runs~mlb11$at_bats)
# A very small and weak linear association can be seen between these variables, because the plot almost appears scattered, but a weak positive association can be seen.

#2
cor(x = mlb11$runs, y = mlb11$at_bats)
# 0.610627
# The correlation coefficient tells us that the strength between the two variables is fairly decent. It tells us that is almost in the middle between no correlation and a perfect positive correlation, therefore there is a slight positive correlation and the strength between the two variables is not strong, but decent.

#3
plot_ss(x = mlb11$at_bats, y = mlb11$runs)
# Call:
#   lm(formula = y ~ x, data = pts)
#
# Coefficients:
#   (Intercept)            x  
#   -2599.2895       0.5978  
#
# Sum of Squares:  126279.7
# The smallest sum of squares of the residuals that I was able to calculate was 126279.7

#4
lm1 <- lm(mlb11$runs~mlb11$at_bats)
lm1
# Call:
#   lm(formula = mlb11$runs ~ mlb11$at_bats)
#
# Coefficients:
#   (Intercept)  mlb11$at_bats  
#   -2789.2429         0.6305
# The equation of the regression line is runs = 0.6305*(bats) - 2789.2429
# This line is quite different from the best one I created by hand, because this line's intercept is fairly lesser than mine and the slope is greater than mine.

#5
summary(lm(mlb11$runs~mlb11$at_bats))
# The variability in runs is explained by at_bats is 0.3505. The piece of the summary used to find this was the Adjusted R-squared.

#6
plot(lm1)
# The condition of linearity is met, because the data points mostly follower the dotted horizontal line in the Residuals vs Fitted plot. The condition of having nearly normal residuals is met, but the residuals are barely normal as there is a lot of variability, which can be seen in the Normal Q-Q plot, by comparing the data points to the QQ-line. The condition of constant variability is met, because the vertical spread is pretty much the same across the entire Residuals vs Fitted plot. 

#7
plot(mlb11$runs~mlb11$homeruns)
lm(formula = mlb11$runs ~ mlb11$homeruns)
# Call:
#  lm(formula = mlb11$runs ~ mlb11$homeruns)
#
# Coefficients:
#   (Intercept)  mlb11$homeruns  
#       415.239           1.835
# The equation of the regression line is runs = 1.835*(homeruns)+ 415.239

#8
summary(lm(mlb11$runs~mlb11$at_bats))
summary(lm(mlb11$runs~mlb11$homeruns))
# homeruns is better to predict runs, because its adjusted R-squared value is greater. When using homeruns, the adjusted R-squared value is 0.6132, while the adjusted R-squared value when using at_bats is 0.3505. This means that more variability in runs is explained by homeruns. To interperet the slope of the regression line using homeruns, we can say that for every 1 more homerun, we can expect to see 1.8345 more runs. On the other hand, to interperet the slope of the regression line using at_bats, we can say for for every 1 more at_bat, we can expect to see 0.6305 more runs.

#9
summary(lm(mlb11$runs~mlb11$hits))
summary(lm(mlb11$runs~mlb11$bat_avg))
summary(lm(mlb11$runs~mlb11$strikeouts))
summary(lm(mlb11$runs~mlb11$stolen_bases))
summary(lm(mlb11$runs~mlb11$wins))
# bat_avg is the best predictor of runs, because it has the greatest R-squared value, so  more variability in runs is explained by bat_avg than the other variables.

#10
model <- lm(runs ~ at_bats + hits + homeruns + bat_avg + strikeouts + stolen_bases + wins, data = mlb11)
summary(model)
#This model explains more of the variance than the single variable regression models we trained in the previous steps of this lab. This is because this model calculates multiple variables that could help explain the amount of runs, therefore the model produces the greatest R-squared value so much more variability in runs is explained by these multiple explanatory variables. The model has an adjusted R-squared value of 0.8922, which is higher than the R-squared values seen in the previous steps of the lab.