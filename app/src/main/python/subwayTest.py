import pandas as pd
import geopandas as gpd
# import os
from os.path import dirname, join
#
filename = join(dirname(__file__), "DOITT_SUBWAY_STATION_04JAN2017.zip")
#
def getCoordX(i=0):
    stations=gpd.read_file(filename)
    lines=gpd.read_file(filename)
    stations.head()
    lines.head()
    return stations['geometry'].x[i]

#
# def getCoordY(i=0):
#     stations=gpd.read_file(filename)
#     lines=gpd.read_file(filename)
#     stations.head()
#     lines.head()
#     return stations['geometry'].y[i]