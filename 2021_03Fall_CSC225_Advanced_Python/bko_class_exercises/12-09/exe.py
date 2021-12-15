import pandas as pd
import folium
import os


rentsmart_data = pd.read_csv('rentsmart_20211130.csv')
rentsmart_data.rename(
    columns={'violotaion_type': 'violation_type'}, inplace=True)

sample_data = rentsmart_data.sample(20)

m = folium.Map()
for idx, row in sample_data.iterrows():
    folium.Marker(location=[row['latitude'], row['longitude']],
                  popup=row['violation_type'], tooltip=row['description']).add_to(m)

m().save("index.html")
