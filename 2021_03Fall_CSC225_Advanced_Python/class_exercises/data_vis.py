import csv
from datetime import datetime
import matplotlib.pyplot as plt

filename = 'sitka_weather_2018_simple.csv'
with open(filename) as f:
    reader = csv.reader(f)
    header = next(reader)

    dates_sitka, daily_rainfall_sitka = [], []
    for row in reader:
        try:
            dates_sitka.append(datetime.strptime(row[2], '%Y-%m-%d'))
        except ValueError:
            print('error reading dates => Sitka')

        try:
            daily_rainfall_sitka.append(float(row[3]))
        except ValueError:
            print('error reading rainfall => Sitka')


filename = 'death_valley_2018_simple.csv'
with open(filename) as f:
    reader = csv.reader(f)
    header = next(reader)

    dates_death_valley, daily_rainfall_death_valley = [], []

    for row in reader:
        try:
            dates_death_valley.append(
                datetime.strptime(row[2], '%Y-%m-%d'))
        except ValueError:
            print('error reading dates => Death Valley')

        try:
            daily_rainfall_death_valley.append(float(row[3]))
        except ValueError:
            print('error reading rainfall => Death Valley')


fig, ax = plt.subplots()
line1, = ax.plot(dates_sitka, daily_rainfall_sitka,
                 label="Sitka Daily Rainfall")
line2, = ax.plot(dates_death_valley, daily_rainfall_death_valley,
                 label="Death Valley Daily Rainfall")
ax.legend(handles=[line1, line2])

plt.show()
