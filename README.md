# Coarse/Exact Location Services Study

This ia a final project for my Cyber Security senior elective.
In this project, I explore the security options both left to user control and built into Android Location Services.
The apps in this repository were used to track my movements for a month to show the value of this location data as well as the built-in protections from Android.

There are two levels of permission for apps to access your location on Android. The first is coarse location permission, and the second is precise or fine location permission. Coarse location services obscure the user's actual location from the app. How coarse location is determined was explored in this project.

The first app, CoarseLocationLogger, logged my location periodically using the Coarse permissions, and the second, ExactLocationLogger, logged my precise location periodically. An overview of these logs plotted on a map, as well as my analysis, can be found in the attached PowerPoint.

My most important finding in this study was that Coarse location seems to be determined by aligning Fine location (with some limited randomness) to a grid where the seperation between each point on the same latitude is 1.25 miles apart, while points longitudinally shift around a bit due to the curvature of the earth, but are also close to 1.25 miles apart. This built-in protection prevents attackers from obtaining a reasonable estimate for a Fine location based off of many Coarse location requests.
