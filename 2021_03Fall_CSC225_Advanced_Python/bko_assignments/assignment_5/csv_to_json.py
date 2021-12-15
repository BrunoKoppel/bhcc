import json
import csv


def make_json(csv_filename, json_filename):
    data = []
    with open(csv_filename, encoding='utf-8') as csvf:
        csv_dict_reader = csv.DictReader(csvf)

        for rows in csv_dict_reader:
            data.append(rows)

    with open(json_filename, 'w', encoding='utf-8') as jsonf:
        jsonf.write(json.dumps(data, indent=4))


csv_filename = 'world_fires_1_day.csv'
json_filename = 'world_fires_1_day.json'

make_json(csv_filename, json_filename)
