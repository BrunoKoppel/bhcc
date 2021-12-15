import json
from plotly.graph_objs import Scattergeo, Layout
from plotly import offline

filename = 'world_fires_1_day.json'

with open(filename) as f:
    all_wf_data = json.load(f)

# readable_file = 'data/readable_wf_data.json'
# with open(readable_file, 'w') as f:
#     json.dump(all_wf_data, f, indent=4)

# for object in all_wf_data:
#     printensity(object['latitude'])

intensities, lons, lats = [], [], []
# all_wf_dicts = all_wf_data['features']
for wf_dict in all_wf_data:
    intensity = wf_dict['frp']
    lon = wf_dict['longitude']
    lat = wf_dict['latitude']
    intensities.append(intensity)
    lons.append(lon)
    lats.append(lat)

data = {
    'type': 'scattergeo',
    'lon': lons,
    'lat': lats,
    'marker': {
        # 'size': [intensity for intensity in intensities],
        # 'color': [intensity for intensity in intensities],
        'colorscale': 'sunset',
        'reversescale': True,
        'colorbar': {'title': 'frp'}
    },
}

my_layout = Layout(title='Global Fires')

fig = {'data': data, 'layout': my_layout}
offline.plot(fig, filename='global_fires.html')
