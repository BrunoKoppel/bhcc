import pandas as pd
import matplotlib.pyplot as plt
df = pd.read_csv('data/air_quality_no2.csv', index_col=0,
                 parse_dates=True)

# print(df.head())
# aggregate functions
# print(df['station_london'].max())
# print(df['station_london'].mean())
# filtering

# print(df[(df['station_antwerp'] > 50) & (df['station_paris'] > 50)])
df.plot.scatter(x="station_london", y="station_paris", alpha=0.5)
